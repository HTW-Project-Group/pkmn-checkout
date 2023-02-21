package de.htwberlin.core.appservice.mapper;

import de.htwberlin.core.domain.model.CheckoutItem;
import de.htwberlin.port.dto.CheckoutItemDto;
import java.util.List;

public interface ICheckoutItemMapper {

  CheckoutItem toCheckoutItem(CheckoutItemDto dto);

  List<CheckoutItem> toCheckoutItem(List<CheckoutItemDto> dtos);
}
