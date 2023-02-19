package de.htwberlin.core.domain.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checkout")
public class CheckoutItem implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", nullable = false, updatable = false)
  UUID id;

  @Column(name = "user_id", nullable = false, updatable = false)
  UUID userId;

  @Column(name = "pokemon_id", nullable = false, updatable = false)
  String pokemonId;

  @Column(name = "name")
  String name;

  @Column(name = "quantity")
  int quantity;

  @Column(name = "price")
  double price;
}
