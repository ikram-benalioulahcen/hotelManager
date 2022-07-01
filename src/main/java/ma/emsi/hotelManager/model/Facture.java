package ma.emsi.hotelManager.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
