package de.htwberlin.port.exception;

public class CheckoutNotFoundException extends RuntimeException {
  public CheckoutNotFoundException() {
    super("Checkout not found");
  }

  public CheckoutNotFoundException(String id) {
    super("Checkout not found: " + id);
  }
}
