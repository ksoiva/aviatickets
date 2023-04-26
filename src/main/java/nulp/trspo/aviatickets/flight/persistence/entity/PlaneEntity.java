package nulp.trspo.aviatickets.flight.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "plane")
public class PlaneEntity {
    @Id
    @SequenceGenerator(name = "seq_plane", sequenceName = "hibernate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plane")
    @Column(name = "id")
    @ReadOnlyProperty
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "seat_count")
    private Integer seatCount;
    @Column(name = "row_count")
    private Integer rowCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaneEntity that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
