package de.htwberlin.core.domain.service;

import de.htwberlin.core.domain.model.CheckoutItem;
import de.htwberlin.core.domain.repository.ICheckoutRepository;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Transactional
@Validated
@RequiredArgsConstructor
public class CheckoutService implements ICheckoutService {

  private final ICheckoutRepository checkoutRepository;

  @Override
  public void saveCheckoutItem(List<CheckoutItem> checkoutItems) {
    checkoutItems.stream()
        .map(CheckoutItem::getUserId)
        .distinct()
        .findFirst()
        .ifPresent(checkoutRepository::deleteAllCheckoutItemsByUserId);
    checkoutRepository.saveAll(checkoutItems);
  }

  @Override
  public List<CheckoutItem> getAllCheckoutItemsByUserId(UUID id) {
    return checkoutRepository.findAllCheckoutItemsByUserId(id);
  }
}
