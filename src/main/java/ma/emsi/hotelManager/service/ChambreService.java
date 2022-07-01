package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Chambre;

import java.util.List;

public interface ChambreService {
    Chambre create(Chambre chambre);
    List<Chambre> list(int limit);
    Chambre get(Long id);
    Chambre update(Chambre chambre);
    Boolean delete(Long id);

}
