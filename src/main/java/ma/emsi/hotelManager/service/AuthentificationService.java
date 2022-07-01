package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Authentification;

import java.util.List;

public interface AuthentificationService {
    Authentification create(Authentification authentification);
    List<Authentification> list(int limit);
    Authentification get(Long id);
    Authentification update(Authentification authentification);
    Boolean delete(Long id);
}
