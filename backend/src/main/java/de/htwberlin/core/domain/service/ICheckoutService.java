package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.CheckoutItem;
import java.util.List;

public interface ICheckoutService {
  List<CheckoutItem> saveCheckoutItem(List<CheckoutItem> checkoutItem);
}
