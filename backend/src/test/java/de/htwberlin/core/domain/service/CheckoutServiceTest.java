package de.htwberlin.core.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import de.htwberlin.core.domain.model.CheckoutItem;
import de.htwberlin.core.domain.repository.CheckoutInMemoryRepository;
import de.htwberlin.core.domain.repository.ICheckoutRepository;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutServiceTest {

  private ICheckoutService checkoutService;
  private ICheckoutRepository checkoutRepository;

  @BeforeEach
  void setUp() {
    checkoutRepository = new CheckoutInMemoryRepository();
    checkoutService = new CheckoutService(checkoutRepository);
  }

  @Test
  void shouldSaveCheckoutItems() {
    final UUID mockCheckoutId = UUID.fromString("10000000-0000-0000-0000-000000000000");
    final UUID mockUserId = UUID.fromString("00000000-0000-0000-0000-000000000000");
    final CheckoutItem mockCheckoutItem1 =
        new CheckoutItem(mockCheckoutId, mockUserId, "base1-4", "Charizard", 2, 300.5);
    final CheckoutItem mockCheckoutItem2 =
        new CheckoutItem(mockCheckoutId, mockUserId, "base1-44", "Bulbasaur", 5, 204.69);
    final List<CheckoutItem> mockCheckoutItemList = List.of(mockCheckoutItem1, mockCheckoutItem2);
    var result = checkoutService.saveCheckoutItem(mockCheckoutItemList);
    assertThat(result.get(0).getId()).isEqualTo(mockCheckoutId);
  }
}
