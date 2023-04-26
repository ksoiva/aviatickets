package nulp.trspo.aviatickets.ticket.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nulp.trspo.aviatickets.flight.persistence.entity.FlightEntity;
import nulp.trspo.aviatickets.user.persistence.entity.UserEntity;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @SequenceGenerator(name = "seq_ticket", sequenceName = "hibernate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ticket")
    @Column(name = "id")
    @ReadOnlyProperty
    private Long id;
    @Column(name = "seat")
    private String seat;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity passenger;
    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private FlightEntity flight;
    @Column(name = "baggage")
    private Boolean baggage;
    @Column(name = "priority")
    private Boolean priority;
    @Column(name = "total_price")
    private Float totalPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketEntity that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
