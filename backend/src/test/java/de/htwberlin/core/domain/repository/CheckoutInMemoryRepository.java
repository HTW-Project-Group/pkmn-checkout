package de.htwberlin.core.domain.repository;

import de.htwberlin.core.domain.model.CheckoutItem;
import java.util.*;

public class CheckoutInMemoryRepository extends BaseInMemoryRepository<CheckoutItem, UUID>
    implements ICheckoutRepository {
  private final Map<UUID, CheckoutItem> entities = new HashMap<>();

  @Override
  public <S extends CheckoutItem> List<S> saveAll(Iterable<S> entities) {
    entities.forEach((entity) -> this.entities.put(entity.getId(), entity));
    List<S> result = new ArrayList<>();
    entities.forEach(result::add);
    return result;
  }
}
