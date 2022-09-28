package tr.com.calik.app.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import tr.com.calik.app.graphql.dto.BranchDto;
import tr.com.calik.app.graphql.dto.OrderDto;
import tr.com.calik.app.graphql.entity.Branch;
import tr.com.calik.app.graphql.entity.Order;
import tr.com.calik.app.graphql.repository.BranchRepository;
import tr.com.calik.app.graphql.repository.OrderRepository;
import tr.com.calik.app.graphql.repository.PersonRepository;

@Controller
@RequiredArgsConstructor
public class OrderResolver implements GraphQLResolver<OrderDto> {

    private final OrderRepository orderRepository;
    private final BranchRepository branchRepository;

    private final PersonRepository personRepository;


    public BranchDto branch(OrderDto order) {
        Order orderEntity = orderRepository.findById(order.getId()).get();
        Branch branch = branchRepository.findById(orderEntity.getBranchId()).get();
        return branchToDto(branch);
    }

    private BranchDto branchToDto(Branch branch){
        BranchDto branchDto = new BranchDto();
        branchDto.setId(branch.getId());
        branchDto.setAddress(branch.getAddress());
        return branchDto;
    }

}