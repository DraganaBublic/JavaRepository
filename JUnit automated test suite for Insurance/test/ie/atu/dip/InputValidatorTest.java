package ie.atu.dip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The `InputValidatorTest` class is a test class that contains test cases for
 * different input validators.
 */
class InputValidatorTest {

	/**
	 * This method is executed before each test case. It sets up the necessary
	 * resources or configurations for each test.
	 */
	@BeforeEach
	void initializeEach() {
		System.out.println("Setting up for each test");
	}

	/**
	 * Test case for the `NonNegativeNumberValidator` with invalid input. It uses
	 * the `ParameterizedTest` annotation to run the test with multiple input
	 * values. The `ValueSource` annotation provides the input values for the test.
	 * The `Timeout` annotation sets a timeout of 3 seconds for the test.
	 *
	 * @param input The input value for the test.
	 */
	@ParameterizedTest
	@ValueSource(ints = { -3 })
	@Timeout(3)
	void nonNegativeNumberValidatorInvalidInput(int input) {
		// Create an instance of the NonNegativeNumberValidator
		InputValidator validator = new NonNegativeNumberValidator();

		// Assert that the validator returns false for the invalid input
		assertFalse(validator.isValid(input));
	}

	/**
	 * Test case for the `NonNegativeNumberValidator` error message. It creates an
	 * instance of the `NonNegativeNumberValidator` and asserts that the error
	 * message is correct.
	 */
	@Test
	void nonNegativeNumberValidatorErrorMessage() {
		// Create an instance of the NonNegativeNumberValidator
		InputValidator validator = new NonNegativeNumberValidator();

		// Assert that the error message is correct
		assertEquals("Please enter a non-negative number.", validator.getErrorMessage());
	}

	/**
	 * Test case for the `PositiveNumberValidator` with valid input. It uses the
	 * `ParameterizedTest` annotation to run the test with multiple input values.
	 * The `ValueSource` annotation provides the input values for the test.
	 *
	 * @param input The input value for the test.
	 */
	@ParameterizedTest
	@ValueSource(ints = { 10 })
	void positiveNumberValidatorValidInput(int input) {
		// Create an instance of the PositiveNumberValidator
		InputValidator validator = new PositiveNumberValidator();

		// Assert that the validator returns true for the valid input
		assertTrue(validator.isValid(input));
	}

	/**
	 * This method is executed after all the test cases have been run. It cleans up
	 * any resources or configurations that were set up for the tests.
	 */
	@AfterAll
	static void tearDownAll() {
		System.out.println("Cleaning up after all tests");
	}
}