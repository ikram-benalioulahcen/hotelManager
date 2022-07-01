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
public class Service {

    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;

    private String nom;

    private String description;

    private double prix;

    @ManyToMany
    private List<Facture> factures;

    @ManyToMany
    private List<Fedelite> fedelites;
}
