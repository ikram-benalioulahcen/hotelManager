package ma.emsi.hotelManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String nationalite;
    private boolean sexe;
    private String telephone;
    private String email;
    private boolean subscription;
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;

}
