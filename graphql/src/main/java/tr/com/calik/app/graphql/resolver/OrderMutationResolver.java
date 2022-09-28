package tr.com.calik.app.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tr.com.calik.app.graphql.dto.BranchDto;
import tr.com.calik.app.graphql.dto.OrderDto;
import tr.com.calik.app.graphql.dto.PersonDto;
import tr.com.calik.app.graphql.entity.Order;
import tr.com.calik.app.graphql.repository.OrderRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class OrderMutationResolver implements GraphQLMutationResolver {

    private final OrderRepository orderRepository;

    public OrderDto createOrder(Long person, Long branch) {
        Order order = new Order();
        order.setPersonId(person);
        order.setBranchId(branch);
        order.setDeliverTime(LocalDateTime.now());
        order = orderRepository.save(order);
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        PersonDto personDto = new PersonDto();
        personDto.setId(order.getPersonId());

        BranchDto branchDto = new BranchDto();
        branchDto.setId(order.getBranchId());

        orderDto.setPerson(personDto);
        orderDto.setBranch(branchDto);
        return orderDto;
    }
}