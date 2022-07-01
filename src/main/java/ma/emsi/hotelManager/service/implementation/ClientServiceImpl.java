package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Client;
import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.repository.ClientRepository;
import ma.emsi.hotelManager.service.ClientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        log.info("Saving Client");
        return clientRepository.save(client);
    }


    @Override
    public List<Client> list(int limit) {
        log.info("Showing Clients");
        return clientRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Client get(Long id) {
        log.info("getting client of id : "+ id);
        return clientRepository.findById(id).get();
    }

    @Override
    public Client update(Client client) {
        log.info("Updating Client");
        return clientRepository.save(client);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Client of id :{}", id);
        clientRepository.deleteById(id);
        return TRUE;
    }
}
