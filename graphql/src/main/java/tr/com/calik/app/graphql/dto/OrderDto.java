package tr.com.calik.app.graphql.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

    private Long id;

    private String deliverTime;

    private PersonDto person;

    private BranchDto branch;


}
