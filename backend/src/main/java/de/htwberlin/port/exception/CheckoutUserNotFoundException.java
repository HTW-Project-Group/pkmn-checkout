package de.htwberlin.port.exception;

public class CheckoutUserNotFoundException extends RuntimeException {
  public CheckoutUserNotFoundException() {
    super("Checkout not found");
  }

  public CheckoutUserNotFoundException(String id) {
    super("Checkout not found: " + id);
  }
}
