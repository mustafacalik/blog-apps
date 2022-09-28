package tr.com.calik.app.graphql.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDto {
    private Long id;
    private String email;
    private List<OrderDto> orders;
}
