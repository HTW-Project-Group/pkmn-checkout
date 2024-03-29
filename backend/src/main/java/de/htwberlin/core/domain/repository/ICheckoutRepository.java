package de.htwberlin.core.domain.repository;

import de.htwberlin.core.domain.model.CheckoutItem;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheckoutRepository extends JpaRepository<CheckoutItem, UUID> {

  List<CheckoutItem> findAllCheckoutItemsByUserId(UUID userid);

  @Modifying
  @Query(value = "DELETE FROM checkout WHERE user_id = ?1", nativeQuery = true)
  void deleteAllCheckoutItemsByUserId(UUID userId);
}
