package nulp.trspo.aviatickets.flight.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "flight")
public class FlightEntity {
    @Id
    @SequenceGenerator(name = "seq_flight", sequenceName = "hibernate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_flight")
    @Column(name = "id")
    @ReadOnlyProperty
    private Long id;
    @Column(name = "departure_airport")
    private String departureAirport;
    @Column(name = "arrival_airport")
    private String arrivalAirport;
    @Column(name = "departure_date")
    private Timestamp departureDate;
    @Column(name = "arrival_date")
    private Timestamp arrivalDate;
    @Column(name = "initial_price")
    private Float initialPrice;
    @ManyToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    private PlaneEntity plane;
    @Column(name = "available_seats")
    private Integer availableSeats;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightEntity that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
