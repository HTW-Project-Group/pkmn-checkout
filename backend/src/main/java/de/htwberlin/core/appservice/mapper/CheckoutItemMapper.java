package de.htwberlin.core.appservice.mapper;

import de.htwberlin.core.domain.model.CheckoutItem;
import de.htwberlin.port.dto.CheckoutItemDto;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CheckoutItemMapper implements ICheckoutItemMapper {

  @Override
  public CheckoutItem toCheckoutItem(CheckoutItemDto dto) {
    return CheckoutItem.builder()
        .id(dto.getId())
        .userId(dto.getUserId())
        .quantity(dto.getQuantity())
        .price(dto.getPrice())
        .build();
  }

  @Override
  public List<CheckoutItem> toCheckoutItem(List<CheckoutItemDto> dtos) {
    return dtos.stream().map(this::toCheckoutItem).toList();
  }
}
