package de.htwberlin.core.domain.model;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class CheckoutItemFactory {
  private static final Faker faker = new Faker(Locale.GERMAN);

  public static CheckoutItem.CheckoutItemBuilder simpleCheckoutItem(UUID id) {
    return CheckoutItem.builder()
        .id(id)
        .userId(UUID.randomUUID())
        .name(faker.pokemon().name())
        .price(faker.number().randomDouble(2, 100, 1000))
        .quantity(faker.random().nextInt(1, 10))
        .pokemonId("P" + faker.pokemon().hashCode());
  }
}
