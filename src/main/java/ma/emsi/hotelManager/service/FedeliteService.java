package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Facture;
import ma.emsi.hotelManager.model.Fedelite;

import java.util.List;

public interface FedeliteService {
    Fedelite create(Fedelite fedelite);
    List<Fedelite> list(int limit);
    Fedelite get(Long id);
    Fedelite update(Fedelite fedelite);
    Boolean delete(Long id);
}
