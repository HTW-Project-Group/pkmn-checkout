package de.htwberlin.port.checkout;

import de.htwberlin.core.domain.service.ICheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/checkout")
@CrossOrigin(origins = "http://localhost:3000")
public class CheckoutController {

  private final ICheckoutService checkoutService;
}
