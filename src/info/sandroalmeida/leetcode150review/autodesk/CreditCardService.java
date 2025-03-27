package info.sandroalmeida.leetcode150review.autodesk;

import java.util.Arrays;
import java.util.List;

public class CreditCardService {

    private final List<CardValidator> validators;

    // Ideally, validators can be injected or loaded from configuration
    public CreditCardService() {
      this.validators = Arrays.asList(
          new AmericanExpressValidator(),
          new DinersClubValidator()
      );
    }

    public String checkValidity(String cardNumber) {
      if (cardNumber == null || cardNumber.isEmpty()) {
        throw new IllegalArgumentException("Card number must not be null or empty");
      }
      for (CardValidator validator : validators) {
        if (validator.matches(cardNumber)) {
          return validator.getCardType();
        }
      }
      return "Unknown Card Type";
    }
  }