package ma.emsi.hotelManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;

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
}
