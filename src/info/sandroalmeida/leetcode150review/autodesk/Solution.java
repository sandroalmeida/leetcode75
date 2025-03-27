package info.sandroalmeida.leetcode150review.autodesk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  Initial proposed exercise

  if starts with 34 or 35 and has length of 15 returns "American Express"
  if starts with 37 or 38 and has length of 14 returns "Dinners Club"
* */
public class Solution {

  public String checkValidity(String cardNumber) {
    return "";
  }


  @Test
  public void testCardValidity() {
    // American Express tests (should return "American Express")
    assertEquals("American Express", checkValidity("341234567890123"));
    assertEquals("American Express", checkValidity("351234567890123"));

    // Dinners Club tests (should return "Dinners Club")
    assertEquals("Dinners Club", checkValidity("37123456789012"));
    assertEquals("Dinners Club", checkValidity("38123456789012"));
  }
}
