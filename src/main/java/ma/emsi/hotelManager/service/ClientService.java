package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Client;

import java.util.List;

public interface ClientService {
    Client create(Client client);
    List<Client> list(int limit);
    Client get(Long id);
    Client update(Long id,Client client);
    Boolean delete(Long id);
}
