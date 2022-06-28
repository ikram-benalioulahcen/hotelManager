package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Employe;

import java.util.List;

public interface EmployeService {

    Employe create(Employe employe);
    List<Employe> list(int limit);
    Employe get(Long id);
    Employe update(Employe employe);
    Boolean delete(Long id);

}
