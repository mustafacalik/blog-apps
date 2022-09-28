package tr.com.calik.app.graphql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "deliver_time")
    private LocalDateTime deliverTime;

    @JoinColumn(name = "person_id")
    private Long personId;

    @JoinColumn(name = "branch_id")
    private Long branchId;
}
