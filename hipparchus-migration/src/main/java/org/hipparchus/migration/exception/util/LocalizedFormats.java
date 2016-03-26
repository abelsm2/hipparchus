/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License(LocalizedCoreFormats.License), Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing(LocalizedCoreFormats.writing), software
 * distributed under the License is distributed on an "AS IS" BASIS(LocalizedCoreFormats.BASIS),
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND(LocalizedCoreFormats.KIND), either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hipparchus.migration.exception.util;

import java.util.Locale;

import org.hipparchus.exception.Localizable;
import org.hipparchus.exception.LocalizedCoreFormats;
import org.hipparchus.fitting.LocalizedFittingFormats;
import org.hipparchus.genetics.LocalizedGeneticsFormats;
import org.hipparchus.geometry.LocalizedGeometryFormats;
import org.hipparchus.migration.LocalizedMigrationFormats;
import org.hipparchus.clustering.LocalizedClusteringFormats;
import org.hipparchus.ode.LocalizedODEFormats;
import org.hipparchus.optim.LocalizedOptimFormats;
import org.hipparchus.transform.LocalizedFFTFormats;

/**
 * Enumeration for localized messages formats used in exceptions messages.
 * <p>
 * The constants in this enumeration represent the available
 * formats as localized strings. These formats are intended to be
 * localized using simple properties files(LocalizedCoreFormats.files), using the constant
 * name as the key and the property value as the message format.
 * The source English format is provided in the constants themselves
 * to serve both as a reminder for developers to understand the parameters
 * needed by each format(LocalizedCoreFormats.format), as a basis for translators to create
 * localized properties files(LocalizedCoreFormats.files), and as a default format if some
 * translation is missing.
 * </p>
 * @deprecated this class is only meant as a migration help from Apache Commons Math,
 * it is really replaced by {@link LocalizedCoreFormats}, {@link LocalizedFFTFormats},
 * {@link LocalizedFittingFormats}, {@link LocalizedGeneticsFormats},
 * {@link LocalizedGeometryFormats} and {@link LocalizedMLFormats}
 */
@Deprecated
public enum LocalizedFormats implements Localizable {

    // CHECKSTYLE: stop MultipleVariableDeclarations
    // CHECKSTYLE: stop JavadocVariable

    ARGUMENT_OUTSIDE_DOMAIN(LocalizedCoreFormats.ARGUMENT_OUTSIDE_DOMAIN),
    ARRAY_SIZE_EXCEEDS_MAX_VARIABLES(LocalizedCoreFormats.ARRAY_SIZE_EXCEEDS_MAX_VARIABLES),
    ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1(LocalizedCoreFormats.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1),
    ARRAY_SUMS_TO_ZERO(LocalizedCoreFormats.ARRAY_SUMS_TO_ZERO),
    ASSYMETRIC_EIGEN_NOT_SUPPORTED(LocalizedMigrationFormats.ASSYMETRIC_EIGEN_NOT_SUPPORTED),
    AT_LEAST_ONE_COLUMN(LocalizedCoreFormats.AT_LEAST_ONE_COLUMN),
    AT_LEAST_ONE_ROW(LocalizedCoreFormats.AT_LEAST_ONE_ROW),
    BANDWIDTH(LocalizedCoreFormats.BANDWIDTH),
    BESSEL_FUNCTION_BAD_ARGUMENT(LocalizedCoreFormats.BESSEL_FUNCTION_BAD_ARGUMENT),
    BESSEL_FUNCTION_FAILED_CONVERGENCE(LocalizedCoreFormats.BESSEL_FUNCTION_FAILED_CONVERGENCE),
    BINOMIAL_INVALID_PARAMETERS_ORDER(LocalizedCoreFormats.BINOMIAL_INVALID_PARAMETERS_ORDER),
    BINOMIAL_NEGATIVE_PARAMETER(LocalizedCoreFormats.BINOMIAL_NEGATIVE_PARAMETER),
    CANNOT_CLEAR_STATISTIC_CONSTRUCTED_FROM_EXTERNAL_MOMENTS(LocalizedMigrationFormats.CANNOT_CLEAR_STATISTIC_CONSTRUCTED_FROM_EXTERNAL_MOMENTS),
    CANNOT_COMPUTE_0TH_ROOT_OF_UNITY(LocalizedCoreFormats.CANNOT_COMPUTE_0TH_ROOT_OF_UNITY),
    CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA(LocalizedCoreFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_0_FOR_SOME_ALPHA),
    CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA(LocalizedCoreFormats.CANNOT_COMPUTE_BETA_DENSITY_AT_1_FOR_SOME_BETA),
    CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N(LocalizedCoreFormats.CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N),
    CANNOT_DISCARD_NEGATIVE_NUMBER_OF_ELEMENTS(LocalizedCoreFormats.CANNOT_DISCARD_NEGATIVE_NUMBER_OF_ELEMENTS),
    CANNOT_FORMAT_INSTANCE_AS_3D_VECTOR(LocalizedMigrationFormats.CANNOT_FORMAT_INSTANCE_AS_3D_VECTOR),
    CANNOT_FORMAT_INSTANCE_AS_COMPLEX(LocalizedCoreFormats.CANNOT_FORMAT_INSTANCE_AS_COMPLEX),
    CANNOT_FORMAT_INSTANCE_AS_REAL_VECTOR(LocalizedMigrationFormats.CANNOT_FORMAT_INSTANCE_AS_REAL_VECTOR),
    CANNOT_FORMAT_OBJECT_TO_FRACTION(LocalizedCoreFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION),
    CANNOT_INCREMENT_STATISTIC_CONSTRUCTED_FROM_EXTERNAL_MOMENTS(LocalizedMigrationFormats.CANNOT_INCREMENT_STATISTIC_CONSTRUCTED_FROM_EXTERNAL_MOMENTS),
    CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR(LocalizedGeometryFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR),
    CANNOT_RETRIEVE_AT_NEGATIVE_INDEX(LocalizedMigrationFormats.CANNOT_RETRIEVE_AT_NEGATIVE_INDEX),
    CANNOT_SET_AT_NEGATIVE_INDEX(LocalizedMigrationFormats.CANNOT_SET_AT_NEGATIVE_INDEX),
    CANNOT_SUBSTITUTE_ELEMENT_FROM_EMPTY_ARRAY(LocalizedCoreFormats.CANNOT_SUBSTITUTE_ELEMENT_FROM_EMPTY_ARRAY),
    CANNOT_TRANSFORM_TO_DOUBLE(LocalizedCoreFormats.CANNOT_TRANSFORM_TO_DOUBLE),
    CARDAN_ANGLES_SINGULARITY(LocalizedGeometryFormats.CARDAN_ANGLES_SINGULARITY),
    CLASS_DOESNT_IMPLEMENT_COMPARABLE(LocalizedMigrationFormats.CLASS_DOESNT_IMPLEMENT_COMPARABLE),
    CLOSE_VERTICES(LocalizedGeometryFormats.CLOSE_VERTICES),
    CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT(LocalizedGeometryFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT),
    COLUMN_INDEX_OUT_OF_RANGE(LocalizedMigrationFormats.COLUMN_INDEX_OUT_OF_RANGE),
    COLUMN_INDEX(LocalizedCoreFormats.COLUMN_INDEX),
    CONSTRAINT(LocalizedCoreFormats.CONSTRAINT),
    CONTINUED_FRACTION_INFINITY_DIVERGENCE(LocalizedCoreFormats.CONTINUED_FRACTION_INFINITY_DIVERGENCE),
    CONTINUED_FRACTION_NAN_DIVERGENCE(LocalizedCoreFormats.CONTINUED_FRACTION_NAN_DIVERGENCE),
    CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR(LocalizedCoreFormats.CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR),
    CONTRACTION_CRITERIA_SMALLER_THAN_ONE(LocalizedCoreFormats.CONTRACTION_CRITERIA_SMALLER_THAN_ONE),
    CONVERGENCE_FAILED(LocalizedCoreFormats.CONVERGENCE_FAILED),
    CROSSING_BOUNDARY_LOOPS(LocalizedGeometryFormats.CROSSING_BOUNDARY_LOOPS),
    CROSSOVER_RATE(LocalizedGeneticsFormats.CROSSOVER_RATE),
    CUMULATIVE_PROBABILITY_RETURNED_NAN(LocalizedCoreFormats.CUMULATIVE_PROBABILITY_RETURNED_NAN),
    DIFFERENT_ROWS_LENGTHS(LocalizedCoreFormats.DIFFERENT_ROWS_LENGTHS),
    DIFFERENT_ORIG_AND_PERMUTED_DATA(LocalizedGeneticsFormats.DIFFERENT_ORIG_AND_PERMUTED_DATA),
    DIGEST_NOT_INITIALIZED(LocalizedCoreFormats.DIGEST_NOT_INITIALIZED),
    DIMENSIONS_MISMATCH_2x2(LocalizedCoreFormats.DIMENSIONS_MISMATCH_2x2),
    DIMENSIONS_MISMATCH(LocalizedCoreFormats.DIMENSIONS_MISMATCH),
    DISCRETE_CUMULATIVE_PROBABILITY_RETURNED_NAN(LocalizedCoreFormats.DISCRETE_CUMULATIVE_PROBABILITY_RETURNED_NAN),
    DISTRIBUTION_NOT_LOADED(LocalizedCoreFormats.DISTRIBUTION_NOT_LOADED),
    DUPLICATED_ABSCISSA_DIVISION_BY_ZERO(LocalizedCoreFormats.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO),
    EDGE_CONNECTED_TO_ONE_FACET(LocalizedGeometryFormats.EDGE_CONNECTED_TO_ONE_FACET),
    ELITISM_RATE(LocalizedGeneticsFormats.ELITISM_RATE),
    EMPTY_CLUSTER_IN_K_MEANS(LocalizedClusteringFormats.EMPTY_CLUSTER_IN_K_MEANS),
    EMPTY_INTERPOLATION_SAMPLE(LocalizedCoreFormats.EMPTY_INTERPOLATION_SAMPLE),
    EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY(LocalizedCoreFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY),
    EMPTY_SELECTED_COLUMN_INDEX_ARRAY(LocalizedCoreFormats.EMPTY_SELECTED_COLUMN_INDEX_ARRAY),
    EMPTY_SELECTED_ROW_INDEX_ARRAY(LocalizedCoreFormats.EMPTY_SELECTED_ROW_INDEX_ARRAY),
    EMPTY_STRING_FOR_IMAGINARY_CHARACTER(LocalizedMigrationFormats.EMPTY_STRING_FOR_IMAGINARY_CHARACTER),
    ENDPOINTS_NOT_AN_INTERVAL(LocalizedCoreFormats.ENDPOINTS_NOT_AN_INTERVAL),
    EQUAL_VERTICES_IN_SIMPLEX(LocalizedOptimFormats.EQUAL_VERTICES_IN_SIMPLEX),
    EULER_ANGLES_SINGULARITY(LocalizedGeometryFormats.EULER_ANGLES_SINGULARITY),
    EVALUATION(LocalizedCoreFormats.EVALUATION),
    EXPANSION_FACTOR_SMALLER_THAN_ONE(LocalizedCoreFormats.EXPANSION_FACTOR_SMALLER_THAN_ONE),
    FACET_ORIENTATION_MISMATCH(LocalizedGeometryFormats.FACET_ORIENTATION_MISMATCH),
    FACTORIAL_NEGATIVE_PARAMETER(LocalizedCoreFormats.FACTORIAL_NEGATIVE_PARAMETER),
    FAILED_BRACKETING(LocalizedCoreFormats.FAILED_BRACKETING),
    FAILED_FRACTION_CONVERSION(LocalizedCoreFormats.FAILED_FRACTION_CONVERSION),
    FIRST_COLUMNS_NOT_INITIALIZED_YET(LocalizedCoreFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET),
    FIRST_ELEMENT_NOT_ZERO(LocalizedFFTFormats.FIRST_ELEMENT_NOT_ZERO),
    FIRST_ROWS_NOT_INITIALIZED_YET(LocalizedCoreFormats.FIRST_ROWS_NOT_INITIALIZED_YET),
    FRACTION_CONVERSION_OVERFLOW(LocalizedCoreFormats.FRACTION_CONVERSION_OVERFLOW),
    FUNCTION_NOT_DIFFERENTIABLE(LocalizedMigrationFormats.FUNCTION_NOT_DIFFERENTIABLE),
    FUNCTION_NOT_POLYNOMIAL(LocalizedMigrationFormats.FUNCTION_NOT_POLYNOMIAL),
    GCD_OVERFLOW_32_BITS(LocalizedCoreFormats.GCD_OVERFLOW_32_BITS),
    GCD_OVERFLOW_64_BITS(LocalizedCoreFormats.GCD_OVERFLOW_64_BITS),
    HOLE_BETWEEN_MODELS_TIME_RANGES(LocalizedODEFormats.HOLE_BETWEEN_MODELS_TIME_RANGES),
    ILL_CONDITIONED_OPERATOR(LocalizedCoreFormats.ILL_CONDITIONED_OPERATOR),
    INCONSISTENT_STATE_AT_2_PI_WRAPPING(LocalizedGeometryFormats.INCONSISTENT_STATE_AT_2_PI_WRAPPING),
    INDEX_LARGER_THAN_MAX(LocalizedCoreFormats.INDEX_LARGER_THAN_MAX),
    INDEX_NOT_POSITIVE(LocalizedCoreFormats.INDEX_NOT_POSITIVE),
    INDEX_OUT_OF_RANGE(LocalizedMigrationFormats.INDEX_OUT_OF_RANGE),
    INDEX(LocalizedCoreFormats.INDEX),
    NOT_FINITE_NUMBER(LocalizedCoreFormats.NOT_FINITE_NUMBER),
    INFINITE_BOUND(LocalizedCoreFormats.INFINITE_BOUND),
    ARRAY_ELEMENT(LocalizedCoreFormats.ARRAY_ELEMENT),
    INFINITE_ARRAY_ELEMENT(LocalizedCoreFormats.INFINITE_ARRAY_ELEMENT),
    INFINITE_VALUE_CONVERSION(LocalizedCoreFormats.INFINITE_VALUE_CONVERSION),
    INITIAL_CAPACITY_NOT_POSITIVE(LocalizedCoreFormats.INITIAL_CAPACITY_NOT_POSITIVE),
    INITIAL_COLUMN_AFTER_FINAL_COLUMN(LocalizedCoreFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN),
    INITIAL_ROW_AFTER_FINAL_ROW(LocalizedCoreFormats.INITIAL_ROW_AFTER_FINAL_ROW),
    INSUFFICIENT_DATA(LocalizedCoreFormats.INSUFFICIENT_DATA),
    INSUFFICIENT_DATA_FOR_T_STATISTIC(LocalizedCoreFormats.INSUFFICIENT_DATA_FOR_T_STATISTIC),
    INSUFFICIENT_DIMENSION(LocalizedCoreFormats.INSUFFICIENT_DIMENSION),
    DIMENSION(LocalizedCoreFormats.DIMENSION),
    INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE(LocalizedCoreFormats.INSUFFICIENT_OBSERVED_POINTS_IN_SAMPLE),
    INSUFFICIENT_ROWS_AND_COLUMNS(LocalizedCoreFormats.INSUFFICIENT_ROWS_AND_COLUMNS),
    INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS(LocalizedODEFormats.INTEGRATION_METHOD_NEEDS_AT_LEAST_TWO_PREVIOUS_POINTS),
    INTERNAL_ERROR(LocalizedCoreFormats.INTERNAL_ERROR),
    INVALID_BINARY_DIGIT(LocalizedGeneticsFormats.INVALID_BINARY_DIGIT),
    INVALID_BINARY_CHROMOSOME(LocalizedGeneticsFormats.INVALID_BINARY_CHROMOSOME),
    INVALID_BRACKETING_PARAMETERS(LocalizedMigrationFormats.INVALID_BRACKETING_PARAMETERS),
    INVALID_FIXED_LENGTH_CHROMOSOME(LocalizedGeneticsFormats.INVALID_FIXED_LENGTH_CHROMOSOME),
    INVALID_IMPLEMENTATION(LocalizedFittingFormats.INVALID_IMPLEMENTATION),
    INVALID_INTERVAL_INITIAL_VALUE_PARAMETERS(LocalizedMigrationFormats.INVALID_INTERVAL_INITIAL_VALUE_PARAMETERS),
    INVALID_ITERATIONS_LIMITS(LocalizedMigrationFormats.INVALID_ITERATIONS_LIMITS),
    INVALID_MAX_ITERATIONS(LocalizedCoreFormats.INVALID_MAX_ITERATIONS),
    NOT_ENOUGH_DATA_REGRESSION(LocalizedCoreFormats.NOT_ENOUGH_DATA_REGRESSION),
    INVALID_REGRESSION_ARRAY(LocalizedMigrationFormats.INVALID_REGRESSION_ARRAY),
    INVALID_REGRESSION_OBSERVATION(LocalizedCoreFormats.INVALID_REGRESSION_OBSERVATION),
    INVALID_ROUNDING_METHOD(LocalizedCoreFormats.INVALID_ROUNDING_METHOD),
    ITERATOR_EXHAUSTED(LocalizedMigrationFormats.ITERATOR_EXHAUSTED),
    ITERATIONS(LocalizedCoreFormats.ITERATIONS),
    LCM_OVERFLOW_32_BITS(LocalizedCoreFormats.LCM_OVERFLOW_32_BITS),
    LCM_OVERFLOW_64_BITS(LocalizedCoreFormats.LCM_OVERFLOW_64_BITS),
    LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE(LocalizedGeneticsFormats.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE),
    LOESS_EXPECTS_AT_LEAST_ONE_POINT(LocalizedMigrationFormats.LOESS_EXPECTS_AT_LEAST_ONE_POINT),
    LOWER_BOUND_NOT_BELOW_UPPER_BOUND(LocalizedCoreFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND),
    LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT(LocalizedCoreFormats.LOWER_ENDPOINT_ABOVE_UPPER_ENDPOINT),
    MAP_MODIFIED_WHILE_ITERATING(LocalizedMigrationFormats.MAP_MODIFIED_WHILE_ITERATING),
    MULTISTEP_STARTER_STOPPED_EARLY(LocalizedODEFormats.MULTISTEP_STARTER_STOPPED_EARLY),
    EVALUATIONS(LocalizedCoreFormats.EVALUATIONS),
    MAX_COUNT_EXCEEDED(LocalizedCoreFormats.MAX_COUNT_EXCEEDED),
    MAX_ITERATIONS_EXCEEDED(LocalizedMigrationFormats.MAX_ITERATIONS_EXCEEDED),
    MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION(LocalizedODEFormats.MINIMAL_STEPSIZE_REACHED_DURING_INTEGRATION),
    MISMATCHED_LOESS_ABSCISSA_ORDINATE_ARRAYS(LocalizedMigrationFormats.MISMATCHED_LOESS_ABSCISSA_ORDINATE_ARRAYS),
    MUTATION_RATE(LocalizedGeneticsFormats.MUTATION_RATE),
    NAN_ELEMENT_AT_INDEX(LocalizedCoreFormats.NAN_ELEMENT_AT_INDEX),
    NAN_VALUE_CONVERSION(LocalizedCoreFormats.NAN_VALUE_CONVERSION),
    NEGATIVE_BRIGHTNESS_EXPONENT(LocalizedMigrationFormats.NEGATIVE_BRIGHTNESS_EXPONENT),
    NEGATIVE_COMPLEX_MODULE(LocalizedCoreFormats.NEGATIVE_COMPLEX_MODULE),
    NEGATIVE_ELEMENT_AT_2D_INDEX(LocalizedMigrationFormats.NEGATIVE_ELEMENT_AT_2D_INDEX),
    NEGATIVE_ELEMENT_AT_INDEX(LocalizedCoreFormats.NEGATIVE_ELEMENT_AT_INDEX),
    NEGATIVE_NUMBER_OF_SUCCESSES(LocalizedCoreFormats.NEGATIVE_NUMBER_OF_SUCCESSES),
    NUMBER_OF_SUCCESSES(LocalizedCoreFormats.NUMBER_OF_SUCCESSES),
    NEGATIVE_NUMBER_OF_TRIALS(LocalizedMigrationFormats.NEGATIVE_NUMBER_OF_TRIALS),
    NUMBER_OF_INTERPOLATION_POINTS(LocalizedCoreFormats.NUMBER_OF_INTERPOLATION_POINTS),
    NUMBER_OF_TRIALS(LocalizedCoreFormats.NUMBER_OF_TRIALS),
    NOT_CONVEX(LocalizedGeometryFormats.NOT_CONVEX),
    NOT_CONVEX_HYPERPLANES(LocalizedGeometryFormats.NOT_CONVEX_HYPERPLANES),
    ROBUSTNESS_ITERATIONS(LocalizedCoreFormats.ROBUSTNESS_ITERATIONS),
    START_POSITION(LocalizedCoreFormats.START_POSITION),
    NON_CONVERGENT_CONTINUED_FRACTION(LocalizedCoreFormats.NON_CONVERGENT_CONTINUED_FRACTION),
    NON_INVERTIBLE_TRANSFORM(LocalizedGeometryFormats.NON_INVERTIBLE_TRANSFORM),
    NON_POSITIVE_MICROSPHERE_ELEMENTS(LocalizedMigrationFormats.NON_POSITIVE_MICROSPHERE_ELEMENTS),
    NON_POSITIVE_POLYNOMIAL_DEGREE(LocalizedMigrationFormats.NON_POSITIVE_POLYNOMIAL_DEGREE),
    NON_REAL_FINITE_ABSCISSA(LocalizedMigrationFormats.NON_REAL_FINITE_ABSCISSA),
    NON_REAL_FINITE_ORDINATE(LocalizedMigrationFormats.NON_REAL_FINITE_ORDINATE),
    NON_REAL_FINITE_WEIGHT(LocalizedMigrationFormats.NON_REAL_FINITE_WEIGHT),
    NON_SQUARE_MATRIX(LocalizedCoreFormats.NON_SQUARE_MATRIX),
    NORM(LocalizedCoreFormats.NORM),
    NORMALIZE_INFINITE(LocalizedCoreFormats.NORMALIZE_INFINITE),
    NORMALIZE_NAN(LocalizedCoreFormats.NORMALIZE_NAN),
    NOT_ADDITION_COMPATIBLE_MATRICES(LocalizedMigrationFormats.NOT_ADDITION_COMPATIBLE_MATRICES),
    NOT_DECREASING_NUMBER_OF_POINTS(LocalizedMigrationFormats.NOT_DECREASING_NUMBER_OF_POINTS),
    NOT_DECREASING_SEQUENCE(LocalizedCoreFormats.NOT_DECREASING_SEQUENCE),
    NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS(LocalizedCoreFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS),
    NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION(LocalizedCoreFormats.NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION),
    NOT_INCREASING_NUMBER_OF_POINTS(LocalizedMigrationFormats.NOT_INCREASING_NUMBER_OF_POINTS),
    NOT_INCREASING_SEQUENCE(LocalizedCoreFormats.NOT_INCREASING_SEQUENCE),
    NOT_MULTIPLICATION_COMPATIBLE_MATRICES(LocalizedMigrationFormats.NOT_MULTIPLICATION_COMPATIBLE_MATRICES),
    NOT_POSITIVE_DEFINITE_MATRIX(LocalizedCoreFormats.NOT_POSITIVE_DEFINITE_MATRIX),
    NON_POSITIVE_DEFINITE_MATRIX(LocalizedMigrationFormats.NON_POSITIVE_DEFINITE_MATRIX),
    NON_POSITIVE_DEFINITE_OPERATOR(LocalizedCoreFormats.NON_POSITIVE_DEFINITE_OPERATOR),
    NON_SELF_ADJOINT_OPERATOR(LocalizedCoreFormats.NON_SELF_ADJOINT_OPERATOR),
    NON_SQUARE_OPERATOR(LocalizedCoreFormats.NON_SQUARE_OPERATOR),
    DEGREES_OF_FREEDOM(LocalizedCoreFormats.DEGREES_OF_FREEDOM),
    NOT_POSITIVE_DEGREES_OF_FREEDOM(LocalizedMigrationFormats.NOT_POSITIVE_DEGREES_OF_FREEDOM),
    NOT_POSITIVE_ELEMENT_AT_INDEX(LocalizedMigrationFormats.NOT_POSITIVE_ELEMENT_AT_INDEX),
    NOT_POSITIVE_EXPONENT(LocalizedCoreFormats.NOT_POSITIVE_EXPONENT),
    NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE(LocalizedCoreFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE),
    BASE(LocalizedCoreFormats.BASE),
    EXPONENT(LocalizedCoreFormats.EXPONENT),
    NOT_POSITIVE_LENGTH(LocalizedMigrationFormats.NOT_POSITIVE_LENGTH),
    LENGTH(LocalizedCoreFormats.LENGTH),
    NOT_POSITIVE_MEAN(LocalizedMigrationFormats.NOT_POSITIVE_MEAN),
    MEAN(LocalizedCoreFormats.MEAN),
    NOT_POSITIVE_NUMBER_OF_SAMPLES(LocalizedCoreFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES),
    NUMBER_OF_SAMPLES(LocalizedCoreFormats.NUMBER_OF_SAMPLES),
    NOT_POSITIVE_PERMUTATION(LocalizedMigrationFormats.NOT_POSITIVE_PERMUTATION),
    PERMUTATION_SIZE(LocalizedCoreFormats.PERMUTATION_SIZE),
    NOT_POSITIVE_POISSON_MEAN(LocalizedMigrationFormats.NOT_POSITIVE_POISSON_MEAN),
    NOT_POSITIVE_POPULATION_SIZE(LocalizedMigrationFormats.NOT_POSITIVE_POPULATION_SIZE),
    POPULATION_SIZE(LocalizedCoreFormats.POPULATION_SIZE),
    NOT_POSITIVE_ROW_DIMENSION(LocalizedMigrationFormats.NOT_POSITIVE_ROW_DIMENSION),
    NOT_POSITIVE_SAMPLE_SIZE(LocalizedMigrationFormats.NOT_POSITIVE_SAMPLE_SIZE),
    NOT_POSITIVE_SCALE(LocalizedCoreFormats.NOT_POSITIVE_SCALE),
    SCALE(LocalizedCoreFormats.SCALE),
    NOT_POSITIVE_SHAPE(LocalizedMigrationFormats.NOT_POSITIVE_SHAPE),
    SHAPE(LocalizedCoreFormats.SHAPE),
    NOT_POSITIVE_STANDARD_DEVIATION(LocalizedMigrationFormats.NOT_POSITIVE_STANDARD_DEVIATION),
    STANDARD_DEVIATION(LocalizedCoreFormats.STANDARD_DEVIATION),
    NOT_POSITIVE_UPPER_BOUND(LocalizedMigrationFormats.NOT_POSITIVE_UPPER_BOUND),
    NOT_POSITIVE_WINDOW_SIZE(LocalizedCoreFormats.NOT_POSITIVE_WINDOW_SIZE),
    NOT_POWER_OF_TWO(LocalizedFFTFormats.NOT_POWER_OF_TWO),
    NOT_POWER_OF_TWO_CONSIDER_PADDING(LocalizedFFTFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING),
    NOT_POWER_OF_TWO_PLUS_ONE(LocalizedFFTFormats.NOT_POWER_OF_TWO_PLUS_ONE),
    NOT_STRICTLY_DECREASING_NUMBER_OF_POINTS(LocalizedMigrationFormats.NOT_STRICTLY_DECREASING_NUMBER_OF_POINTS),
    NOT_STRICTLY_DECREASING_SEQUENCE(LocalizedCoreFormats.NOT_STRICTLY_DECREASING_SEQUENCE),
    NOT_STRICTLY_INCREASING_KNOT_VALUES(LocalizedMigrationFormats.NOT_STRICTLY_INCREASING_KNOT_VALUES),
    NOT_STRICTLY_INCREASING_NUMBER_OF_POINTS(LocalizedMigrationFormats.NOT_STRICTLY_INCREASING_NUMBER_OF_POINTS),
    NOT_STRICTLY_INCREASING_SEQUENCE(LocalizedCoreFormats.NOT_STRICTLY_INCREASING_SEQUENCE),
    NOT_SUBTRACTION_COMPATIBLE_MATRICES(LocalizedMigrationFormats.NOT_SUBTRACTION_COMPATIBLE_MATRICES),
    NOT_SUPPORTED_IN_DIMENSION_N(LocalizedGeometryFormats.NOT_SUPPORTED_IN_DIMENSION_N),
    NOT_SUPPORTED_NAN_STRATEGY(LocalizedCoreFormats.NOT_SUPPORTED_NAN_STRATEGY),
    NOT_SYMMETRIC_MATRIX(LocalizedMigrationFormats.NOT_SYMMETRIC_MATRIX),
    NON_SYMMETRIC_MATRIX(LocalizedCoreFormats.NON_SYMMETRIC_MATRIX),
    NO_BIN_SELECTED(LocalizedMigrationFormats.NO_BIN_SELECTED),
    NO_CONVERGENCE_WITH_ANY_START_POINT(LocalizedCoreFormats.NO_CONVERGENCE_WITH_ANY_START_POINT),
    NO_DATA(LocalizedCoreFormats.NO_DATA),
    NO_DEGREES_OF_FREEDOM(LocalizedMigrationFormats.NO_DEGREES_OF_FREEDOM),
    NO_DENSITY_FOR_THIS_DISTRIBUTION(LocalizedMigrationFormats.NO_DENSITY_FOR_THIS_DISTRIBUTION),
    NO_FEASIBLE_SOLUTION(LocalizedOptimFormats.NO_FEASIBLE_SOLUTION),
    NO_OPTIMUM_COMPUTED_YET(LocalizedCoreFormats.NO_OPTIMUM_COMPUTED_YET),
    NO_REGRESSORS(LocalizedCoreFormats.NO_REGRESSORS),
    NO_RESULT_AVAILABLE(LocalizedMigrationFormats.NO_RESULT_AVAILABLE),
    NO_SUCH_MATRIX_ENTRY(LocalizedMigrationFormats.NO_SUCH_MATRIX_ENTRY),
    NAN_NOT_ALLOWED(LocalizedCoreFormats.NAN_NOT_ALLOWED),
    NULL_NOT_ALLOWED(LocalizedCoreFormats.NULL_NOT_ALLOWED),
    ARRAY_ZERO_LENGTH_OR_NULL_NOT_ALLOWED(LocalizedCoreFormats.ARRAY_ZERO_LENGTH_OR_NULL_NOT_ALLOWED),
    COVARIANCE_MATRIX(LocalizedCoreFormats.COVARIANCE_MATRIX),
    DENOMINATOR(LocalizedCoreFormats.DENOMINATOR),
    DENOMINATOR_FORMAT(LocalizedCoreFormats.DENOMINATOR_FORMAT),
    FRACTION(LocalizedCoreFormats.FRACTION),
    FUNCTION(LocalizedCoreFormats.FUNCTION),
    IMAGINARY_FORMAT(LocalizedCoreFormats.IMAGINARY_FORMAT),
    INPUT_ARRAY(LocalizedCoreFormats.INPUT_ARRAY),
    NUMERATOR(LocalizedCoreFormats.NUMERATOR),
    NUMERATOR_FORMAT(LocalizedCoreFormats.NUMERATOR_FORMAT),
    OBJECT_TRANSFORMATION(LocalizedCoreFormats.OBJECT_TRANSFORMATION),
    REAL_FORMAT(LocalizedCoreFormats.REAL_FORMAT),
    WHOLE_FORMAT(LocalizedCoreFormats.WHOLE_FORMAT),
    NUMBER_TOO_LARGE(LocalizedCoreFormats.NUMBER_TOO_LARGE),
    NUMBER_TOO_SMALL(LocalizedCoreFormats.NUMBER_TOO_SMALL),
    NUMBER_TOO_LARGE_BOUND_EXCLUDED(LocalizedCoreFormats.NUMBER_TOO_LARGE_BOUND_EXCLUDED),
    NUMBER_TOO_SMALL_BOUND_EXCLUDED(LocalizedCoreFormats.NUMBER_TOO_SMALL_BOUND_EXCLUDED),
    NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE(LocalizedCoreFormats.NUMBER_OF_SUCCESS_LARGER_THAN_POPULATION_SIZE),
    NUMERATOR_OVERFLOW_AFTER_MULTIPLY(LocalizedCoreFormats.NUMERATOR_OVERFLOW_AFTER_MULTIPLY),
    N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED(LocalizedMigrationFormats.N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED),
    OBSERVED_COUNTS_ALL_ZERO(LocalizedMigrationFormats.OBSERVED_COUNTS_ALL_ZERO),
    OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY(LocalizedCoreFormats.OBSERVED_COUNTS_BOTTH_ZERO_FOR_ENTRY),
    BOBYQA_BOUND_DIFFERENCE_CONDITION(LocalizedMigrationFormats.BOBYQA_BOUND_DIFFERENCE_CONDITION),
    OUT_OF_BOUNDS_QUANTILE_VALUE(LocalizedCoreFormats.OUT_OF_BOUNDS_QUANTILE_VALUE),
    OUT_OF_BOUNDS_CONFIDENCE_LEVEL(LocalizedCoreFormats.OUT_OF_BOUNDS_CONFIDENCE_LEVEL),
    OUT_OF_BOUND_SIGNIFICANCE_LEVEL(LocalizedCoreFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL),
    SIGNIFICANCE_LEVEL(LocalizedCoreFormats.SIGNIFICANCE_LEVEL),
    OUT_OF_ORDER_ABSCISSA_ARRAY(LocalizedMigrationFormats.OUT_OF_ORDER_ABSCISSA_ARRAY),
    OUT_OF_PLANE(LocalizedGeometryFormats.OUT_OF_PLANE),
    OUT_OF_RANGE_ROOT_OF_UNITY_INDEX(LocalizedCoreFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX),
    OUT_OF_RANGE(LocalizedCoreFormats.OUT_OF_RANGE),
    OUT_OF_RANGE_SIMPLE(LocalizedCoreFormats.OUT_OF_RANGE_SIMPLE),
    OUT_OF_RANGE_LEFT(LocalizedCoreFormats.OUT_OF_RANGE_LEFT),
    OUT_OF_RANGE_RIGHT(LocalizedMigrationFormats.OUT_OF_RANGE_RIGHT),
    OUTLINE_BOUNDARY_LOOP_OPEN(LocalizedGeometryFormats.OUTLINE_BOUNDARY_LOOP_OPEN),
    OVERFLOW(LocalizedCoreFormats.OVERFLOW),
    OVERFLOW_IN_FRACTION(LocalizedCoreFormats.OVERFLOW_IN_FRACTION),
    OVERFLOW_IN_ADDITION(LocalizedCoreFormats.OVERFLOW_IN_ADDITION),
    OVERFLOW_IN_SUBTRACTION(LocalizedCoreFormats.OVERFLOW_IN_SUBTRACTION),
    OVERFLOW_IN_MULTIPLICATION(LocalizedCoreFormats.OVERFLOW_IN_MULTIPLICATION),
    PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD(LocalizedCoreFormats.PERCENTILE_IMPLEMENTATION_CANNOT_ACCESS_METHOD),
    PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD(LocalizedCoreFormats.PERCENTILE_IMPLEMENTATION_UNSUPPORTED_METHOD),
    PERMUTATION_EXCEEDS_N(LocalizedCoreFormats.PERMUTATION_EXCEEDS_N),
    POLYNOMIAL(LocalizedCoreFormats.POLYNOMIAL),
    POLYNOMIAL_INTERPOLANTS_MISMATCH_SEGMENTS(LocalizedMigrationFormats.POLYNOMIAL_INTERPOLANTS_MISMATCH_SEGMENTS),
    POPULATION_LIMIT_NOT_POSITIVE(LocalizedGeneticsFormats.POPULATION_LIMIT_NOT_POSITIVE),
    POWER_NEGATIVE_PARAMETERS(LocalizedMigrationFormats.POWER_NEGATIVE_PARAMETERS),
    PROPAGATION_DIRECTION_MISMATCH(LocalizedODEFormats.PROPAGATION_DIRECTION_MISMATCH),
    RANDOMKEY_MUTATION_WRONG_CLASS(LocalizedGeneticsFormats.RANDOMKEY_MUTATION_WRONG_CLASS),
    ROOTS_OF_UNITY_NOT_COMPUTED_YET(LocalizedCoreFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET),
    ROTATION_MATRIX_DIMENSIONS(LocalizedGeometryFormats.ROTATION_MATRIX_DIMENSIONS),
    ROW_INDEX_OUT_OF_RANGE(LocalizedMigrationFormats.ROW_INDEX_OUT_OF_RANGE),
    ROW_INDEX(LocalizedCoreFormats.ROW_INDEX),
    NOT_BRACKETING_INTERVAL(LocalizedCoreFormats.NOT_BRACKETING_INTERVAL),
    SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE(LocalizedCoreFormats.SAMPLE_SIZE_EXCEEDS_COLLECTION_SIZE),
    SAMPLE_SIZE_LARGER_THAN_POPULATION_SIZE(LocalizedCoreFormats.SAMPLE_SIZE_LARGER_THAN_POPULATION_SIZE),
    SIMPLEX_NEED_ONE_POINT(LocalizedOptimFormats.SIMPLEX_NEED_ONE_POINT),
    SIMPLE_MESSAGE(LocalizedCoreFormats.SIMPLE_MESSAGE),
    SINGULAR_MATRIX(LocalizedCoreFormats.SINGULAR_MATRIX),
    SINGULAR_OPERATOR(LocalizedCoreFormats.SINGULAR_OPERATOR),
    SUBARRAY_ENDS_AFTER_ARRAY_END(LocalizedCoreFormats.SUBARRAY_ENDS_AFTER_ARRAY_END),
    TOO_LARGE_CUTOFF_SINGULAR_VALUE(LocalizedCoreFormats.TOO_LARGE_CUTOFF_SINGULAR_VALUE),
    TOO_LARGE_TOURNAMENT_ARITY(LocalizedGeneticsFormats.TOO_LARGE_TOURNAMENT_ARITY),
    TOO_MANY_ELEMENTS_TO_DISCARD_FROM_ARRAY(LocalizedCoreFormats.TOO_MANY_ELEMENTS_TO_DISCARD_FROM_ARRAY),
    TOO_MANY_REGRESSORS(LocalizedCoreFormats.TOO_MANY_REGRESSORS),
    TOO_SMALL_COST_RELATIVE_TOLERANCE(LocalizedFittingFormats.TOO_SMALL_COST_RELATIVE_TOLERANCE),
    TOO_SMALL_INTEGRATION_INTERVAL(LocalizedODEFormats.TOO_SMALL_INTEGRATION_INTERVAL),
    TOO_SMALL_ORTHOGONALITY_TOLERANCE(LocalizedFittingFormats.TOO_SMALL_ORTHOGONALITY_TOLERANCE),
    TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE(LocalizedFittingFormats.TOO_SMALL_PARAMETERS_RELATIVE_TOLERANCE),
    TRUST_REGION_STEP_FAILED(LocalizedOptimFormats.TRUST_REGION_STEP_FAILED),
    TWO_OR_MORE_CATEGORIES_REQUIRED(LocalizedCoreFormats.TWO_OR_MORE_CATEGORIES_REQUIRED),
    TWO_OR_MORE_VALUES_IN_CATEGORY_REQUIRED(LocalizedCoreFormats.TWO_OR_MORE_VALUES_IN_CATEGORY_REQUIRED),
    UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH(LocalizedMigrationFormats.UNABLE_TO_BRACKET_OPTIMUM_IN_LINE_SEARCH),
    UNABLE_TO_COMPUTE_COVARIANCE_SINGULAR_PROBLEM(LocalizedMigrationFormats.UNABLE_TO_COMPUTE_COVARIANCE_SINGULAR_PROBLEM),
    UNABLE_TO_FIRST_GUESS_HARMONIC_COEFFICIENTS(LocalizedMigrationFormats.UNABLE_TO_FIRST_GUESS_HARMONIC_COEFFICIENTS),
    UNABLE_TO_ORTHOGONOLIZE_MATRIX(LocalizedGeometryFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX),
    UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN(LocalizedFittingFormats.UNABLE_TO_PERFORM_QR_DECOMPOSITION_ON_JACOBIAN),
    UNBOUNDED_SOLUTION(LocalizedOptimFormats.UNBOUNDED_SOLUTION),
    UNKNOWN_MODE(LocalizedCoreFormats.UNKNOWN_MODE),
    UNKNOWN_PARAMETER(LocalizedODEFormats.UNKNOWN_PARAMETER),
    UNMATCHED_ODE_IN_EXPANDED_SET(LocalizedODEFormats.UNMATCHED_ODE_IN_EXPANDED_SET),
    CANNOT_PARSE_AS_TYPE(LocalizedCoreFormats.CANNOT_PARSE_AS_TYPE),
    CANNOT_PARSE(LocalizedCoreFormats.CANNOT_PARSE),
    UNPARSEABLE_3D_VECTOR(LocalizedMigrationFormats.UNPARSEABLE_3D_VECTOR),
    UNPARSEABLE_COMPLEX_NUMBER(LocalizedMigrationFormats.UNPARSEABLE_COMPLEX_NUMBER),
    UNPARSEABLE_REAL_VECTOR(LocalizedMigrationFormats.UNPARSEABLE_REAL_VECTOR),
    UNSUPPORTED_EXPANSION_MODE(LocalizedMigrationFormats.UNSUPPORTED_EXPANSION_MODE),
    UNSUPPORTED_OPERATION(LocalizedCoreFormats.UNSUPPORTED_OPERATION),
    ARITHMETIC_EXCEPTION(LocalizedCoreFormats.ARITHMETIC_EXCEPTION),
    ILLEGAL_STATE(LocalizedCoreFormats.ILLEGAL_STATE),
    USER_EXCEPTION(LocalizedCoreFormats.USER_EXCEPTION),
    URL_CONTAINS_NO_DATA(LocalizedCoreFormats.URL_CONTAINS_NO_DATA),
    VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC(LocalizedCoreFormats.VALUES_ADDED_BEFORE_CONFIGURING_STATISTIC),
    VECTOR_LENGTH_MISMATCH(LocalizedMigrationFormats.VECTOR_LENGTH_MISMATCH),
    VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT(LocalizedCoreFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT),
    WEIGHT_AT_LEAST_ONE_NON_ZERO(LocalizedCoreFormats.WEIGHT_AT_LEAST_ONE_NON_ZERO),
    WRONG_BLOCK_LENGTH(LocalizedMigrationFormats.WRONG_BLOCK_LENGTH),
    WRONG_NUMBER_OF_POINTS(LocalizedCoreFormats.WRONG_NUMBER_OF_POINTS),
    NUMBER_OF_POINTS(LocalizedCoreFormats.NUMBER_OF_POINTS),
    ZERO_DENOMINATOR(LocalizedCoreFormats.ZERO_DENOMINATOR),
    ZERO_DENOMINATOR_IN_FRACTION(LocalizedCoreFormats.ZERO_DENOMINATOR_IN_FRACTION),
    ZERO_FRACTION_TO_DIVIDE_BY(LocalizedCoreFormats.ZERO_FRACTION_TO_DIVIDE_BY),
    ZERO_NORM(LocalizedCoreFormats.ZERO_NORM),
    ZERO_NORM_FOR_ROTATION_AXIS(LocalizedGeometryFormats.ZERO_NORM_FOR_ROTATION_AXIS),
    ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR(LocalizedGeometryFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR),
    ZERO_NOT_ALLOWED(LocalizedCoreFormats.ZERO_NOT_ALLOWED);

    // CHECKSTYLE: resume JavadocVariable
    // CHECKSTYLE: resume MultipleVariableDeclarations


    /** Delegate format. */
    private final Localizable delegate;

    /** Simple constructor.
     * @param delegate delegate format
     */
    LocalizedFormats(final Localizable delegate) {
        this.delegate = delegate;
    }

    /** {@inheritDoc} */
    @Override
    public String getSourceString() {
        return delegate.getSourceString();
    }

    /** {@inheritDoc} */
    @Override
    public String getLocalizedString(final Locale locale) {
        return delegate.getLocalizedString(locale);
    }

}
