package ma.emsi.hotelManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;
    @Column(unique = true)
    private int numero;
    private int etage;
    private boolean disponibilite;
    private String telephone;
    private Long prix;

    @ManyToOne
    private Reservation reservation;

    @ManyToOne
    private Type type;
}
