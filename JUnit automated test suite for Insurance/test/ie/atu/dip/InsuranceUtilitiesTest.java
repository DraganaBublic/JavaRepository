package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class InsuranceUtilitiesTest {

	/**
	 * Test to ensure that the getInput method returns the correct input value.
	 */
	@Test
	public void testValidInput() {
		// Set the expected input value
		int expectedInput = 10;
		// Set the expected prompt message
		String prompt = "Enter a number: ";

		// Prepare the input stream with the expected input
		ByteArrayInputStream inputStream = new ByteArrayInputStream(String.valueOf(expectedInput).getBytes());
		// Create a real Scanner object using the prepared input stream
		Scanner scanner = new Scanner(inputStream);

		// Create a real InputValidator object
		InputValidator validator = new PositiveNumberValidator();

		// Call the getInput method
		int result = InsuranceUtilities.getInput(prompt, scanner, validator);

		// Verify that the result matches the expected input value
		assertEquals(expectedInput, result, "The getInput method returned an incorrect input value.");
	}

	/**
	 * Test to ensure that the getInput method handles invalid input correctly.
	 */
	@Test
	public void testInvalidInput() {
		// Set the expected prompt message
		String prompt = "Enter a number: ";

		// Prepare the input stream with invalid and then valid input
		ByteArrayInputStream inputStream = new ByteArrayInputStream("0\n10\n".getBytes());
		// Create a real Scanner object using the prepared input stream
		Scanner scanner = new Scanner(inputStream);

		// Create a real InputValidator object
		InputValidator validator = new PositiveNumberValidator();

		// Call the getInput method
		int result = InsuranceUtilities.getInput(prompt, scanner, validator);

		// Verify that the scanner received the nextInt method call twice
		assertEquals(10, result, "The getInput method returned an incorrect input value.");
	}

	/**
	 * Test to ensure that a NullPointerException is thrown when a null
	 * InputValidator is provided.
	 */
	@Test
	public void testNullInputValidatorException() {
		// Prepare the input stream with valid input
		ByteArrayInputStream inputStream = new ByteArrayInputStream("10\n".getBytes());
		Scanner scanner = new Scanner(inputStream);

		// Test for NullPointerException
		assertThrows(NullPointerException.class, () -> {
			InsuranceUtilities.getInput("Enter a number: ", scanner, null);
		}, "Expected a NullPointerException for null InputValidator.");
	}

}
