package ma.emsi.hotelManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private int role;
    private String cin;
    private String adresse;
    private String email;
    private LocalDate dateNaissance;

    @OneToOne
    private Authentification authentification;

    @OneToMany(mappedBy = "employe")
    private List<Reservation> reservations;

}
