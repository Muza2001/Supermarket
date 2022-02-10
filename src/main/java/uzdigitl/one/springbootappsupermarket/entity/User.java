package uzdigitl.one.springbootappsupermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(unique = true)
    private String userNumber;

    @Column(unique = true)
    private String password;

    @ManyToOne
    private Werhouse werhouse;

    @ManyToMany
    private List<Role> role;

    public User(String firstName, String lastName, String phoneNumber,
                String userNumber, String password, Werhouse werhouse, List<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.userNumber = userNumber;
        this.password = password;
        this.werhouse = werhouse;
        this.role = role;
    }
}
