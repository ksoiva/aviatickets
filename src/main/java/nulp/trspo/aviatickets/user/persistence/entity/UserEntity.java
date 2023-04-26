package nulp.trspo.aviatickets.user.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nulp.trspo.aviatickets.user.dictionary.Gender;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class UserEntity {
    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "hibernate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id")
    @ReadOnlyProperty
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "document_No", unique = true)
    private String documentNo;
    @Column(name = "document_expire_date")
    private Date docExpireDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserEntity that)) return false;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
