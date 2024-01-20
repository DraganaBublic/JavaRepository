package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositiveNumberValidatorTest {

    private PositiveNumberValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PositiveNumberValidator();
    }

    /**
     * Test to ensure that the error message is correct.
     */
    @Test
    public void testErrorMessage() {
        assertEquals("Please enter a positive number.", validator.getErrorMessage(), "The error message is incorrect.");
    }

    /**
     * Test to ensure that zero is considered invalid.
     */
    @Test
    public void testZeroValidation() {
        assertFalse(validator.isValid(0), "Zero should be considered invalid.");
    }

    /**
     * Test to ensure that a positive number is considered valid.
     */
    @Test
    public void testPositiveNumberValidation() {
        assertTrue(validator.isValid(5), "A positive number should be considered valid.");
    }
}


