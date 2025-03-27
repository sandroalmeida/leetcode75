package info.sandroalmeida.leetcode150review.autodesk;

public class DinersClubValidator implements CardValidator {
    @Override
    public boolean matches(String cardNumber) {
      return cardNumber != null &&
          cardNumber.length() == 14 &&
          (cardNumber.startsWith("37") || cardNumber.startsWith("38"));
    }

    @Override
    public String getCardType() {
      return "Diners Club";
    }
  }