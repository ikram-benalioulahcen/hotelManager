package ma.emsi.hotelManager.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;

    private Double montant;
    private Double montantRegle;

    @OneToOne
    private Reservation reservation;

    @ManyToMany
    private List<Service> services;

}
