package de.htwberlin.port.checkout;

import de.htwberlin.core.domain.model.CheckoutItem;
import de.htwberlin.core.domain.service.ICheckoutService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/checkout")
@CrossOrigin(origins = "http://localhost:3000")
public class CheckoutController {

  private final ICheckoutService checkoutService;

  @GetMapping("/save")
  public void saveCheckoutItem(List<CheckoutItem> checkoutItem) {
    checkoutService.saveCheckoutItem(checkoutItem);
  }
}
