package info.sandroalmeida.leetcode150review.autodesk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardServiceTest {

    private final CreditCardService service = new CreditCardService();

    @Test
    public void testAmericanExpress() {
        assertEquals("American Express", service.checkValidity("341234567890123"));
        assertEquals("American Express", service.checkValidity("351234567890123"));
    }

    @Test
    public void testDinersClub() {
        assertEquals("Diners Club", service.checkValidity("37123456789012"));
        assertEquals("Diners Club", service.checkValidity("38123456789012"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        service.checkValidity("");
    }

    @Test
    public void testUnknownCard() {
        // Example: a Visa card number that doesn't match any validator
        assertEquals("Unknown Card Type", service.checkValidity("4111111111111111"));
    }
}