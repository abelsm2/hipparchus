/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hipparchus.distribution.continuous;

import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.random.RandomGenerator;
import org.hipparchus.random.Well19937c;
import org.hipparchus.util.CombinatoricsUtils;
import org.hipparchus.util.FastMath;
import org.hipparchus.util.MathUtils;
import org.hipparchus.util.ResizableDoubleArray;

/**
 * Implementation of the exponential distribution.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Exponential_distribution">Exponential distribution (Wikipedia)</a>
 * @see <a href="http://mathworld.wolfram.com/ExponentialDistribution.html">Exponential distribution (MathWorld)</a>
 */
public class ExponentialDistribution extends AbstractRealDistribution {
    /** Serializable version identifier */
    private static final long serialVersionUID = 20160320L;
    /**
     * Used when generating Exponential samples.
     * Table containing the constants
     * q_i = sum_{j=1}^i (ln 2)^j/j! = ln 2 + (ln 2)^2/2 + ... + (ln 2)^i/i!
     * until the largest representable fraction below 1 is exceeded.
     *
     * Note that
     * 1 = 2 - 1 = exp(ln 2) - 1 = sum_{n=1}^infty (ln 2)^n / n!
     * thus q_i -> 1 as i -> +inf,
     * so the higher i, the closer to one we get (the series is not alternating).
     *
     * By trying, n = 16 in Java is enough to reach 1.0.
     */
    private static final double[] EXPONENTIAL_SA_QI;
    /** The mean of this distribution. */
    private final double mean;
    /** The logarithm of the mean, stored to reduce computing time. **/
    private final double logMean;

    /**
     * Initialize tables.
     */
    static {
        /**
         * Filling EXPONENTIAL_SA_QI table.
         * Note that we don't want qi = 0 in the table.
         */
        final double LN2 = FastMath.log(2);
        double qi = 0;
        int i = 1;

        /**
         * ArithmeticUtils provides factorials up to 20, so let's use that
         * limit together with Precision.EPSILON to generate the following
         * code (a priori, we know that there will be 16 elements, but it is
         * better to not hardcode it).
         */
        final ResizableDoubleArray ra = new ResizableDoubleArray(20);

        while (qi < 1) {
            qi += FastMath.pow(LN2, i) / CombinatoricsUtils.factorial(i);
            ra.addElement(qi);
            ++i;
        }

        EXPONENTIAL_SA_QI = ra.getElements();
    }

    /**
     * Create an exponential distribution with the given mean.
     * <p>
     * <b>Note:</b> this constructor will implicitly create an instance of
     * {@link Well19937c} as random generator to be used for sampling only (see
     * {@link #sample()} and {@link #sample(int)}). In case no sampling is
     * needed for the created distribution, it is advised to pass {@code null}
     * as random generator via the appropriate constructors to avoid the
     * additional initialisation overhead.
     *
     * @param mean Mean of this distribution.
     * @throws MathIllegalArgumentException if {@code mean <= 0}.
     */
    public ExponentialDistribution(double mean) {
        this(new Well19937c(), mean);
    }

    /**
     * Creates an exponential distribution.
     *
     * @param rng Random number generator.
     * @param mean Mean of this distribution.
     * @throws MathIllegalArgumentException if {@code mean <= 0}.
     */
    public ExponentialDistribution(RandomGenerator rng,
                                   double mean)
        throws MathIllegalArgumentException {
        super(rng);

        if (mean <= 0) {
            throw new MathIllegalArgumentException(LocalizedCoreFormats.MEAN, mean);
        }

        this.mean    = mean;
        this.logMean = FastMath.log(mean);
    }

    /**
     * Access the mean.
     *
     * @return the mean.
     */
    public double getMean() {
        return mean;
    }

    /** {@inheritDoc} */
    @Override
    public double density(double x) {
        final double logDensity = logDensity(x);
        return logDensity == Double.NEGATIVE_INFINITY ? 0 : FastMath.exp(logDensity);
    }

    /** {@inheritDoc} **/
    @Override
    public double logDensity(double x) {
        if (x < 0) {
            return Double.NEGATIVE_INFINITY;
        }
        return -x / mean - logMean;
    }

    /**
     * {@inheritDoc}
     *
     * The implementation of this method is based on:
     * <ul>
     * <li>
     * <a href="http://mathworld.wolfram.com/ExponentialDistribution.html">
     * Exponential Distribution</a>, equation (1).</li>
     * </ul>
     */
    @Override
    public double cumulativeProbability(double x)  {
        double ret;
        if (x <= 0.0) {
            ret = 0.0;
        } else {
            ret = 1.0 - FastMath.exp(-x / mean);
        }
        return ret;
    }

    /**
     * {@inheritDoc}
     *
     * Returns {@code 0} when {@code p= = 0} and
     * {@code Double.POSITIVE_INFINITY} when {@code p == 1}.
     */
    @Override
    public double inverseCumulativeProbability(double p) throws MathIllegalArgumentException {
        MathUtils.checkRangeInclusive(p, 0, 1);

        double ret;
        if (p == 1.0) {
            ret = Double.POSITIVE_INFINITY;
        } else {
            ret = -mean * FastMath.log(1.0 - p);
        }

        return ret;
    }

    /**
     * {@inheritDoc}
     *
     * <p><strong>Algorithm Description</strong>: this implementation uses the
     * <a href="http://www.jesus.ox.ac.uk/~clifford/a5/chap1/node5.html">
     * Inversion Method</a> to generate exponentially distributed random values
     * from uniform deviates.</p>
     *
     * @return a random value.
     */
    @Override
    public double sample() {
        // Step 1:
        double a = 0;
        double u = random.nextDouble();

        // Step 2 and 3:
        while (u < 0.5) {
            a += EXPONENTIAL_SA_QI[0];
            u *= 2;
        }

        // Step 4 (now u >= 0.5):
        u += u - 1;

        // Step 5:
        if (u <= EXPONENTIAL_SA_QI[0]) {
            return mean * (a + u);
        }

        // Step 6:
        int i = 0; // Should be 1, be we iterate before it in while using 0
        double u2 = random.nextDouble();
        double umin = u2;

        // Step 7 and 8:
        do {
            ++i;
            u2 = random.nextDouble();

            if (u2 < umin) {
                umin = u2;
            }

            // Step 8:
        } while (u > EXPONENTIAL_SA_QI[i]); // Ensured to exit since EXPONENTIAL_SA_QI[MAX] = 1

        return mean * (a + umin * EXPONENTIAL_SA_QI[0]);
    }

    /**
     * {@inheritDoc}
     *
     * For mean parameter {@code k}, the mean is {@code k}.
     */
    @Override
    public double getNumericalMean() {
        return getMean();
    }

    /**
     * {@inheritDoc}
     *
     * For mean parameter {@code k}, the variance is {@code k^2}.
     */
    @Override
    public double getNumericalVariance() {
        final double m = getMean();
        return m * m;
    }

    /**
     * {@inheritDoc}
     *
     * The lower bound of the support is always 0 no matter the mean parameter.
     *
     * @return lower bound of the support (always 0)
     */
    @Override
    public double getSupportLowerBound() {
        return 0;
    }

    /**
     * {@inheritDoc}
     *
     * The upper bound of the support is always positive infinity
     * no matter the mean parameter.
     *
     * @return upper bound of the support (always Double.POSITIVE_INFINITY)
     */
    @Override
    public double getSupportUpperBound() {
        return Double.POSITIVE_INFINITY;
    }

    /**
     * {@inheritDoc}
     *
     * The support of this distribution is connected.
     *
     * @return {@code true}
     */
    @Override
    public boolean isSupportConnected() {
        return true;
    }
}
