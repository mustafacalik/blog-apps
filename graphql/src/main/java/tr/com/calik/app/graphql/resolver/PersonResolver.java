package tr.com.calik.app.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import tr.com.calik.app.graphql.dto.OrderDto;
import tr.com.calik.app.graphql.dto.PersonDto;
import tr.com.calik.app.graphql.entity.Order;
import tr.com.calik.app.graphql.repository.OrderRepository;
import tr.com.calik.app.graphql.repository.PersonRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PersonResolver implements GraphQLResolver<PersonDto> {

    private final PersonRepository personRepository;

    private final OrderRepository orderRepository;

    public List<OrderDto> orders(PersonDto person){
        return orderRepository.findByPersonId(person.getId()).stream().map(order -> orderToDto(order)).collect(Collectors.toList());
    }
    private OrderDto orderToDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setDeliverTime(order.getDeliverTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return orderDto;
    }
}