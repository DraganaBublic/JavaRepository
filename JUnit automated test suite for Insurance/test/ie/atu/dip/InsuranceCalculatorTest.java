package ie.atu.dip;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The `InsuranceCalculatorTest` class is a test class for the
 * `InsuranceCalculator` class. It contains test cases to verify the
 * functionality of the `InsuranceCalculator` class.
 */
public class InsuranceCalculatorTest {

	private InsuranceCalculator calculator;

	/**
	 * Set up method to initialize the `InsuranceCalculator` object before each test
	 * case.
	 */
	@BeforeEach
	void setUp() {
		calculator = new InsuranceCalculator();
	}

	/**
	 * Tear down method to clean up the `InsuranceCalculator` object after each test
	 * case.
	 */
	@AfterEach
	void tearDown() {
		calculator = null;
	}

	/**
	 * Test case to verify the calculation of additional surcharge for 5 accidents.
	 */
	@Test
	public void testAdditionalSurchargeFor5Accidents() {
		int additionalSurcharge = calculator.calculateAdditionalSurcharge(5);
		assertEquals(575, additionalSurcharge);
	}

	/**
	 * Test case to verify the calculation of surcharge for age under 25.
	 */
	@Test
	public void testUnder25() {
		int surcharge = calculator.calculateSurcharge(20);
		assertEquals(100, surcharge);
	}

	/**
	 * Test case to verify the exception for invalid age.
	 */
	@Test
	public void testInvalidAgeException() {
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.calculateSurcharge(150);
		}, "Expected an IllegalArgumentException for an invalid age.");
	}
}