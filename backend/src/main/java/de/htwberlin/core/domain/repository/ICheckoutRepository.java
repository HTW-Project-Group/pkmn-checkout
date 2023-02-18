package de.htwberlin.core.domain.repository;

import de.htwberlin.core.domain.model.Checkout;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheckoutRepository extends JpaRepository<Checkout, UUID> {}
