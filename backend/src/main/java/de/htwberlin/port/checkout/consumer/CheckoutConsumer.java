package de.htwberlin.port.checkout.consumer;

import de.htwberlin.core.appservice.mapper.ICheckoutItemMapper;
import de.htwberlin.core.domain.service.ICheckoutService;
import de.htwberlin.port.dto.CheckoutItemDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class CheckoutConsumer {

  private final ICheckoutService checkoutService;
  private final ICheckoutItemMapper checkoutItemMapper;

  @RabbitListener(queues = {"basket"})
  public void consume(List<CheckoutItemDto> basket) {
    log.info(String.format("Received CheckoutItems from Basket Queue <- %s", basket.size()));

    try {
      checkoutService.saveCheckoutItem(checkoutItemMapper.toCheckoutItem(basket));
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
