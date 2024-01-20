package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The `InsuranceProgramTest` class contains test cases for the
 * `InsuranceCalculator` class.
 */
public class InsuranceProgramTest {

	private InsuranceCalculator insuranceCalculator;

	/**
	 * Set up method to initialize the `InsuranceCalculator` object before each test
	 * case.
	 */
	@BeforeEach
	void setUp() {
		insuranceCalculator = new InsuranceCalculator();
	}

	/**
	 * Test to ensure that the `calculateSurcharge` method provides the correct
	 * surcharge for a given age.
	 */
	@Test
	public void testCalculateSurcharge() {
		// Test case for age 25
		assertEquals(0, insuranceCalculator.calculateSurcharge(25),
				"The surcharge calculation was incorrect for age 25.");

		// Test case for age 40
		assertEquals(0, insuranceCalculator.calculateSurcharge(40),
				"The surcharge calculation was incorrect for age 40.");

		// Test case for age 60
		assertEquals(0, insuranceCalculator.calculateSurcharge(60),
				"The surcharge calculation was incorrect for age 60.");
	}

	/**
	 * Test to ensure that the `getInput` method provides the correct input value.
	 */
	@Test
	public void testGetInput() {
		// Set up the input stream with the age value
		String input = "25";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// Test the `getInput` method with the prompt "Enter your age: "
		assertEquals(25,
				InsuranceUtilities.getInput("Enter your age: ", new Scanner(System.in), new PositiveNumberValidator()),
				"The input value was incorrect for prompt 'Enter your age: '.");
	}

	/**
	 * Test to ensure that a NoSuchElementException is thrown for an empty input.
	 */
	@Test
	public void testNoSuchElementException() {
		// Set up the input stream with an empty value
		String input = "";
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// Use assertThrows to check if the expected exception is thrown
		assertThrows(NoSuchElementException.class, () -> {
			InsuranceUtilities.getInput("Enter your age: ", new Scanner(System.in), new PositiveNumberValidator());
		}, "Expected a NoSuchElementException for an empty input.");
	}
}
