package ma.emsi.hotelManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;
    private int duree;
    private int checkIn;
    private String nom;
    private Date dateReservation;

    @OneToOne
    private Facture facture;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "reservation")
    private List<Chambre> chambres;


}
