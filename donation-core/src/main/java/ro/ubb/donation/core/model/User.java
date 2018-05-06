package ro.ubb.donation.core.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "logged", nullable = false)
    private boolean logged;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Role role;

    public void removeRole(){
        this.role = null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", logged=" + logged+
                '}';
    }
}
