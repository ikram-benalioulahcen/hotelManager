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
public class Fedelite {
    @Id
    @GeneratedValue(strategy =  AUTO)
    private Long id;

    @OneToOne
    private Client client;

    @ManyToMany
    private List<Service> services;


}
