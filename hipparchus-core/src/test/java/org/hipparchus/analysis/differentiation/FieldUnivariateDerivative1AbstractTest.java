/*
 * Licensed to the Hipparchus project under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The Hipparchus project licenses this file to You under the Apache License, Version 2.0
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
package org.hipparchus.analysis.differentiation;

import org.hipparchus.Field;
import org.hipparchus.CalculusFieldElement;
import org.hipparchus.CalculusFieldElementAbstractTest;
import org.hipparchus.analysis.FieldUnivariateFunction;
import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.exception.MathIllegalArgumentException;
import org.hipparchus.util.FastMath;
import org.hipparchus.util.FieldSinCos;
import org.hipparchus.util.MathArrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test for class {@link FieldUnivariateDerivative1}.
 */
public abstract class FieldUnivariateDerivative1AbstractTest<T extends CalculusFieldElement<T>>
    extends CalculusFieldElementAbstractTest<FieldUnivariateDerivative1<T>> {

    protected abstract Field<T> getValueField();

    protected FieldUnivariateDerivative1<T> build(double value) {
        final Field<T> valueField = getValueField();
        return new FieldUnivariateDerivative1<>(valueField.getZero().newInstance(value),
                                                valueField.getOne());
    }

    private int getMaxOrder() {
        return 1;
    }

    protected FieldUnivariateDerivative1<T> build(final double f0, final double f1) {
        T prototype = build(0.0).getValue();
        return new FieldUnivariateDerivative1<>(prototype.newInstance(f0),
                                                prototype.newInstance(f1));
    }

    @Test
    public void testOrder() {
        Assert.assertEquals(getMaxOrder(), build(0).getOrder());
    }

    @Test
    public void testNewInstance() {
        FieldUnivariateDerivative1<T> ud = build(5.25);
        Assert.assertEquals(5.25, ud.getValue().getReal(), 1.0e-15);
        Assert.assertEquals(1.0,  ud.getDerivative(1).getReal(), 1.0e-15);
        FieldUnivariateDerivative1<T> newInstance = ud.newInstance(7.5);
        Assert.assertEquals(7.5, newInstance.getValue().getReal(), 1.0e-15);
        Assert.assertEquals(0.0, newInstance.getDerivative(1).getReal(), 1.0e-15);
    }

    @Test
    public void testGetDerivative() {
        FieldUnivariateDerivative1<T> x  = build(3.0);
        FieldUnivariateDerivative1<T> ud = x.multiply(x);
        try {
            ud.getDerivative(-1);
            Assert.fail("an exception should have been thrown");
        } catch (MathIllegalArgumentException miae) {
            Assert.assertEquals(LocalizedCoreFormats.OUT_OF_RANGE_SIMPLE, miae.getSpecifier());
        }
        Assert.assertEquals(9.0, ud.getValue().getReal(), 1.0e-15);
        Assert.assertEquals(9.0, ud.getDerivative(0).getReal(), 1.0e-15);
        Assert.assertEquals(6.0, ud.getDerivative(1).getReal(), 1.0e-15);
        for (int n = 2; n <= getMaxOrder(); ++n) {
            Assert.assertEquals(n == 2 ? 2.0 : 0.0, ud.getDerivative(n).getReal(), 1.0e-15);
        }
        try {
            ud.getDerivative(getMaxOrder() + 1);
            Assert.fail("an exception should have been thrown");
        } catch (MathIllegalArgumentException miae) {
            Assert.assertEquals(LocalizedCoreFormats.OUT_OF_RANGE_SIMPLE, miae.getSpecifier());
        }
    }

    protected void checkAgainstDS(final double x, final FieldUnivariateFunction f) {
        final FieldUnivariateDerivative1<T> xUD = build(x);
        final FieldUnivariateDerivative1<T> yUD = f.value(xUD);
        final FieldDerivativeStructure<T> yDS = f.value(xUD.toDerivativeStructure());
        for (int i = 0; i <= yUD.getOrder(); ++i) {
            Assert.assertEquals(yDS.getPartialDerivative(i).getReal(),
                                yUD.getDerivative(i).getReal(),
                                4.0e-14* FastMath.abs(yDS.getPartialDerivative(i).getReal()));
        }
    }

    @Test
    public void testArithmeticVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   final S y = x.add(3).multiply(x).subtract(5).multiply(0.5);
                                   return y.negate().divide(4).divide(x).add(y).subtract(x).multiply(2).reciprocal();
                               }
                           });
        }
    }

    @Test
    public void testRemainderDoubleVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.remainder(0.5);
                               }
                           });
        }
    }

    @Test
    public void testRemainderUdVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                              public <S extends CalculusFieldElement<S>> S value(S x) {
                                  return x.remainder(x.divide(0.7));
                              }
                           });
        }
    }

    @Test
    public void testAbsVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.norm();
                               }
                           });
        }
    }

    @Test
    public void testScalbVsDS() {
        for (int n = -4; n < 4; ++n) {
            final int theN = n;
            for (double x = -1.25; x < 1.25; x+= 0.5) {
                checkAgainstDS(x,
                               new FieldUnivariateFunction() {
                                   public <S extends CalculusFieldElement<S>> S value(S x) {
                                       return x.scalb(theN);
                                   }
                               });
            }
        }
    }

    @Test
    public void testHypotVsDS() {
        for (double x = -3.25; x < 3.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.cos().multiply(5).hypot(x.sin().multiply(2));
                               }
                           });
        }
    }

    @Test
    public void testAtan2VsDS() {
        for (double x = -3.25; x < 3.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.cos().multiply(5).atan2(x.sin().multiply(2));
                               }
                           });
        }
    }

    @Test
    public void testPowersVsDS() {
        for (double x = -3.25; x < 3.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   final FieldSinCos<S> sc = x.sinCos();
                                   return x.pow(3.2).add(x.pow(2)).subtract(sc.cos().norm().pow(sc.sin()));
                               }
                           });
        }
    }

    @Test
    public void testRootsVsDS() {
        for (double x = 0.001; x < 3.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.rootN(5);//x.sqrt().add(x.cbrt()).subtract(x.rootN(5));
                               }
                           });
        }
    }

    @Test
    public void testExpsLogsVsDS() {
        for (double x = 2.5; x < 3.25; x+= 0.125) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.exp().add(x.multiply(0.5).expm1()).log().log10().log1p();
                               }
                           });
        }
    }

    @Test
    public void testTrigonometryVsDS() {
        for (double x = -3.25; x < 3.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.cos().multiply(x.sin()).atan().divide(12).asin().multiply(0.1).acos().tan();
                               }
                           });
        }
    }

    @Test
    public void testHyperbolicVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.cosh().multiply(x.sinh()).multiply(12).norm().acosh().asinh().divide(7).tanh().multiply(0.1).atanh();
                               }
                           });
        }
    }

    @Test
    public void testConvertersVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.multiply(5).toDegrees().subtract(x).toRadians();
                               }
                           });
        }
    }

    @Test
    public void testLinearCombination2D2FVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.linearCombination(1.0, x.multiply(0.9),
                                                              2.0, x.multiply(0.8));
                               }
                           });
        }
    }

    @Test
    public void testLinearCombination2F2FVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.linearCombination(x.add(1), x.multiply(0.9),
                                                              x.add(2), x.multiply(0.8));
                               }
                           });
        }
    }

    @Test
    public void testLinearCombination3D3FVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.linearCombination(1.0, x.multiply(0.9),
                                                              2.0, x.multiply(0.8),
                                                              3.0, x.multiply(0.7));
                               }
                           });
        }
    }

    @Test
    public void testLinearCombination3F3FVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.linearCombination(x.add(1), x.multiply(0.9),
                                                              x.add(2), x.multiply(0.8),
                                                              x.add(3), x.multiply(0.7));
                               }
                           });
        }
    }

    @Test
    public void testLinearCombination4D4FVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.linearCombination(1.0, x.multiply(0.9),
                                                              2.0, x.multiply(0.8),
                                                              3.0, x.multiply(0.7),
                                                              4.0, x.multiply(0.6));
                               }
                           });
        }
    }

    @Test
    public void testLinearCombination4F4FVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   return x.linearCombination(x.add(1), x.multiply(0.9),
                                                              x.add(2), x.multiply(0.8),
                                                              x.add(3), x.multiply(0.7),
                                                              x.add(4), x.multiply(0.6));
                               }
                           });
        }
    }

    @Test
    public void testLinearCombinationnDnFVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   final S[] b = MathArrays.buildArray(x.getField(), 4);
                                   b[0] = x.add(0.9);
                                   b[1] = x.add(0.8);
                                   b[2] = x.add(0.7);
                                   b[3] = x.add(0.6);
                                   return x.linearCombination(new double[] { 1, 2, 3, 4 }, b);
                               }
                           });
        }
    }

    @Test
    public void testLinearCombinationnFnFVsDS() {
        for (double x = -1.25; x < 1.25; x+= 0.5) {
            checkAgainstDS(x,
                           new FieldUnivariateFunction() {
                               public <S extends CalculusFieldElement<S>> S value(S x) {
                                   final S[] a = MathArrays.buildArray(x.getField(), 4);
                                   a[0] = x.add(1);
                                   a[1] = x.add(2);
                                   a[2] = x.add(3);
                                   a[3] = x.add(4);
                                   final S[] b = MathArrays.buildArray(x.getField(), 4);
                                   b[0] = x.add(0.9);
                                   b[1] = x.add(0.8);
                                   b[2] = x.add(0.7);
                                   b[3] = x.add(0.6);
                                   return x.linearCombination(a, b);
                               }
                           });
        }
    }

    @Test
    public void testZero() {
        FieldUnivariateDerivative1<T> zero = build(17.0).getField().getZero();
        for (int i = 0; i <= zero.getOrder(); ++i) {
            Assert.assertEquals(0.0, zero.getDerivative(i).getReal(), 1.0e-15);
        }
    }

    @Test
    public void testOne() {
        FieldUnivariateDerivative1<T> one = build(17.0).getField().getOne();
        for (int i = 0; i <= one.getOrder(); ++i) {
            Assert.assertEquals(i == 0 ? 1.0 : 0.0, one.getDerivative(i).getReal(), 1.0e-15);
        }
    }

    @Test
    public void testGetFirstDerivative() {
        FieldUnivariateDerivative1<T> ud1 = build(-0.5, 2.5);
        Assert.assertEquals(-0.5, ud1.getReal(), 1.0e-15);
        Assert.assertEquals(-0.5, ud1.getValue().getReal(), 1.0e-15);
        Assert.assertEquals(+2.5, ud1.getFirstDerivative().getReal(), 1.0e-15);
    }

    @Test
    public void testConversion() {
        FieldUnivariateDerivative1<T> udA = build(-0.5, 2.5);
        FieldDerivativeStructure<T> ds = udA.toDerivativeStructure();
        Assert.assertEquals(1, ds.getFreeParameters());
        Assert.assertEquals(1, ds.getOrder());
        Assert.assertEquals(-0.5, ds.getValue().getReal(), 1.0e-15);
        Assert.assertEquals(-0.5, ds.getPartialDerivative(0).getReal(), 1.0e-15);
        Assert.assertEquals( 2.5, ds.getPartialDerivative(1).getReal(), 1.0e-15);
        FieldUnivariateDerivative1<T> udB = new FieldUnivariateDerivative1<>(ds);
        Assert.assertNotSame(udA, udB);
        Assert.assertEquals(udA, udB);
        try {
            new FieldUnivariateDerivative1<>(new FDSFactory<>(getValueField(), 2, 2).variable(0, 1.0));
            Assert.fail("an exception should have been thrown");
        } catch (MathIllegalArgumentException miae) {
            Assert.assertEquals(LocalizedCoreFormats.DIMENSIONS_MISMATCH, miae.getSpecifier());
        }
        try {
            new FieldUnivariateDerivative1<>(new FDSFactory<>(getValueField(), 1, 2).variable(0, 1.0));
            Assert.fail("an exception should have been thrown");
        } catch (MathIllegalArgumentException miae) {
            Assert.assertEquals(LocalizedCoreFormats.DIMENSIONS_MISMATCH, miae.getSpecifier());
        }
    }

    @Test
    public void testDoublePow() {
        Assert.assertSame(build(3).getField().getZero(), FieldUnivariateDerivative1.pow(0.0, build(1.5)));
        FieldUnivariateDerivative1<T> ud = FieldUnivariateDerivative1.pow(2.0, build(1.5));
        DSFactory factory = new DSFactory(1, 1);
        DerivativeStructure ds = factory.constant(2.0).pow(factory.variable(0, 1.5));
        Assert.assertEquals(ds.getValue(), ud.getValue().getReal(), 1.0e-15);
        Assert.assertEquals(ds.getPartialDerivative(1), ud.getFirstDerivative().getReal(), 1.0e-15);
    }

    @Test
    public void testTaylor() {
        Assert.assertEquals(2.5, build(2, 1).taylor(0.5).getReal(), 1.0e-15);
        Assert.assertEquals(2.5, build(2, 1).taylor(getValueField().getZero().newInstance(0.5)).getReal(), 1.0e-15);
    }

    @Test
    public void testEquals() {
        FieldUnivariateDerivative1<T> ud1 = build(12, -34);
        Assert.assertEquals(ud1, ud1);
        Assert.assertNotEquals(ud1, "");
        Assert.assertEquals(ud1,    build(12, -34));
        Assert.assertNotEquals(ud1, build(21, -34));
        Assert.assertNotEquals(ud1, build(12, -43));
        Assert.assertNotEquals(ud1, build(21, -43));
    }

    @Test
    public void testRunTimeClass() {
        Field<FieldUnivariateDerivative1<T>> field = build(0.0).getField();
        Assert.assertEquals(FieldUnivariateDerivative1.class, field.getRuntimeClass());
    }

}
