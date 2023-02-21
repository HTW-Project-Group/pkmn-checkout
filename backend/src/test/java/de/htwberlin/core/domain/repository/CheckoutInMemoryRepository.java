package de.htwberlin.core.domain.repository;

import de.htwberlin.core.domain.model.CheckoutItem;
import java.util.*;

@SuppressWarnings("NullableProblems")
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

  @Override
  public List<CheckoutItem> findAllCheckoutItemsByUserId(UUID userId) {
    return entities.values().stream().filter(b -> b.getUserId().equals(userId)).toList();
  }

  @Override
  public void deleteAllCheckoutItemsByUserId(UUID userId) {
    entities
        .keySet()
        .forEach(
            (key) -> {
              final var entity = entities.get(key);
              if (entity.getUserId().equals(userId)) {
                entities.remove(key);
              }
            });
  }

  @Override
  public List<CheckoutItem> findAll() {
    return entities.values().stream().toList();
  }

  @Override
  public <S extends CheckoutItem> S save(S entity) {
    entities.put(entity.getId(), entity);
    return entity;
  }
}
