package ie.atu.dip;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * `InsuranceTestSuite` class is a test suite that includes multiple test
 * classes for the insurance application. It is used to run all the test cases
 * in the selected test classes.
 */

@Suite
@SelectClasses({ InputValidatorTest.class, InsuranceCalculatorTest.class, InsuranceProgramTest.class,
		InsuranceUtilitiesTest.class, NonNegativeNumberValidatorTest.class, PositiveNumberValidatorTest.class

})

public class InsuranceTestSuite {

}
