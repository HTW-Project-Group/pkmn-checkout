package de.htwberlin.core.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import de.htwberlin.core.domain.model.CheckoutItem;
import de.htwberlin.core.domain.model.CheckoutItemFactory;
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
    // given
    final UUID mockCheckoutId = UUID.randomUUID();
    final UUID mockCheckoutId2 = UUID.randomUUID();
    final CheckoutItem mockCheckoutItem1 =
        CheckoutItemFactory.simpleCheckoutItem(mockCheckoutId).build();
    final CheckoutItem mockCheckoutItem2 =
        CheckoutItemFactory.simpleCheckoutItem(mockCheckoutId2).build();
    final List<CheckoutItem> mockCheckoutItemList = List.of(mockCheckoutItem1, mockCheckoutItem2);

    // when
    checkoutService.saveCheckoutItem(mockCheckoutItemList);
    var result = checkoutRepository.findAll();

    // then
    assertThat(result).hasSize(2);
    assertThat(result).containsExactlyInAnyOrder(mockCheckoutItem1, mockCheckoutItem2);
  }

  @Test
  void shouldGetAllCheckoutItemsByUserId() {
    // given
    final UUID mockCheckoutId = UUID.randomUUID();
    final UUID mockCheckoutId2 = UUID.randomUUID();
    final UUID mockUserId = UUID.randomUUID();
    final CheckoutItem mockCheckoutItem1 =
        CheckoutItemFactory.simpleCheckoutItem(mockCheckoutId).userId(mockUserId).build();
    final CheckoutItem mockCheckoutItem2 =
        CheckoutItemFactory.simpleCheckoutItem(mockCheckoutId2).userId(mockUserId).build();
    final List<CheckoutItem> mockCheckoutItemList = List.of(mockCheckoutItem1, mockCheckoutItem2);
    checkoutRepository.saveAll(mockCheckoutItemList);

    // when
    var resultOptional = checkoutService.getAllCheckoutItemsByUserId(mockUserId);

    // then
    assertThat(resultOptional).hasSize(2);
    assertThat(resultOptional).containsExactlyInAnyOrder(mockCheckoutItem1, mockCheckoutItem2);
  }

  @Test
  void shouldBeEmptyOptionalWhenGettingAllCheckoutItemsByUserIdDoesNotExist() {
    // given
    final UUID mockCheckoutId = UUID.randomUUID();
    final UUID mockUserId = UUID.randomUUID();
    final CheckoutItem mockCheckoutItem =
        CheckoutItemFactory.simpleCheckoutItem(mockCheckoutId).userId(mockUserId).build();
    checkoutRepository.save(mockCheckoutItem);

    // when
    final UUID otherUserId = UUID.randomUUID();
    var emptyResult = checkoutService.getAllCheckoutItemsByUserId(otherUserId);

    // then
    assertThat(emptyResult).isEmpty();
  }
}
