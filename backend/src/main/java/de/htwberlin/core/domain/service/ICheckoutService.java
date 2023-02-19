package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.CheckoutItem;
import java.util.List;
import java.util.UUID;

public interface ICheckoutService {
  void saveCheckoutItem(List<CheckoutItem> checkoutItem);

  List<CheckoutItem> getAllCheckoutItemsByUserId(UUID id);
}
