package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Facture;

import java.util.List;

public interface FactureService {
    Facture create(Facture facture);
    List<Facture> list(int limit);
    Facture get(Long id);
    Facture update(Facture facture);
    Boolean delete(Long id);
}
