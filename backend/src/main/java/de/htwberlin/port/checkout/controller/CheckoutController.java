package de.htwberlin.port.checkout.controller;

import de.htwberlin.core.domain.model.CheckoutItem;
import de.htwberlin.core.domain.service.ICheckoutService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/checkout")
public class CheckoutController {

  private final ICheckoutService checkoutService;

  @GetMapping("/save")
  public void saveCheckoutItem(List<CheckoutItem> checkoutItem) {
    checkoutService.saveCheckoutItem(checkoutItem);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<CheckoutItem>> getCheckoutForUser(
      @PathVariable("userId") UUID userId) {
    return new ResponseEntity<>(checkoutService.getAllCheckoutItemsByUserId(userId), HttpStatus.OK);
  }
}
