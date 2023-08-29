package rw.mlms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import rw.mlms.audits.TimestampAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@OnDelete(action = OnDeleteAction.CASCADE)
public class User extends TimestampAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @NotBlank
    @Column(name = "password")
    private String password;

    public User(String fullName, String username) {
        this.fullName = fullName;
        this.username = username;
    }

    public User(String fullName, String username, String password) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }
}
