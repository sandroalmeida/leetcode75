package info.sandroalmeida.leetcode150review.autodesk;

public class AmericanExpressValidator implements CardValidator {
  @Override
  public boolean matches(String cardNumber) {
    return cardNumber != null &&
        cardNumber.length() == 15 &&
        (cardNumber.startsWith("34") || cardNumber.startsWith("35"));
  }

  @Override
  public String getCardType() {
    return "American Express";
  }
}