package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The `NonNegativeNumberValidatorTest` class is a JUnit test class that tests
 * the functionality of the `NonNegativeNumberValidator` class.
 */
class NonNegativeNumberValidatorTest {

	private NonNegativeNumberValidator validator;

	/**
	 * Sets up the test environment by creating an instance of the
	 * `NonNegativeNumberValidator` class.
	 */
	@BeforeEach
	void setUp() {
		validator = new NonNegativeNumberValidator();
	}

	/**
	 * Tests the `isValid` method of the `NonNegativeNumberValidator` class with
	 * valid non-negative numbers. The test passes if the method returns `true` for
	 * all valid numbers.
	 */
	@Test
	public void testValidNonNegativeNumber() {
		assertTrue(validator.isValid(0));
		assertTrue(validator.isValid(10));
		assertTrue(validator.isValid(Integer.MAX_VALUE));
	}

	/**
	 * Tests the `isValid` method of the `NonNegativeNumberValidator` class with
	 * invalid negative numbers. The test passes if the method returns `false` for
	 * all invalid numbers.
	 */
	@Test
	public void testInvalidNegativeNumber() {
		assertFalse(validator.isValid(-5));
		assertFalse(validator.isValid(Integer.MIN_VALUE));
	}

	/**
	 * Tests the `isValid` method of the `NonNegativeNumberValidator` class with an
	 * invalid zero. The test passes if the method returns `false` for the invalid
	 * zero and the error message matches the expected error message.
	 */
	@Test
	public void testInvalidZeroWithErrorMessage() {
		assertFalse(validator.isValid(-1));
		assertEquals("Please enter a non-negative number.", validator.getErrorMessage());
	}

	/**
	 * Tests the `isValid` method of the `NonNegativeNumberValidator` class with an
	 * invalid negative number. The test passes if the method returns `false` for
	 * the invalid negative number and the error message matches the expected error
	 * message.
	 */
	@Test
	public void testInvalidNegativeNumberWithErrorMessage() {
		assertFalse(validator.isValid(-10));
		assertEquals("Please enter a non-negative number.", validator.getErrorMessage());
	}

	/**
	 * Tests the `isValid` method of the `NonNegativeNumberValidator` class with a
	 * valid zero. The test passes if the method returns `true` for the valid zero.
	 */
	@Test
	public void testValidZero() {
		assertTrue(validator.isValid(0));
	}
}