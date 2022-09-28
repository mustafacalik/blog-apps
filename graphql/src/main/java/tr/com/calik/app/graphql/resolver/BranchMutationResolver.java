package tr.com.calik.app.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tr.com.calik.app.graphql.dto.BranchDto;
import tr.com.calik.app.graphql.entity.Branch;
import tr.com.calik.app.graphql.repository.BranchRepository;

@Component
@RequiredArgsConstructor
public class BranchMutationResolver implements GraphQLMutationResolver {

    private final BranchRepository branchRepository;

    public BranchDto createBranch(String address) {
        Branch branch = new Branch();
        branch.setAddress(address);
        branch =  branchRepository.save(branch);
        BranchDto branchDto = new BranchDto();
        branchDto.setId( branch.getId());
        branchDto.setAddress(branch.getAddress());
        return branchDto;
    }
}