package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Authentification;
import ma.emsi.hotelManager.repository.AuthentificationRepository;
import ma.emsi.hotelManager.service.AuthentificationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AuthentificationServiceImpl implements AuthentificationService {
    private final AuthentificationRepository authentificationRepository;

    @Override
    public Authentification create(Authentification authentification) {
        log.info("Saving Authentification");
        return authentificationRepository.save(authentification);
    }


    @Override
    public List<Authentification> list(int limit) {
        log.info("Showing Authentifications");
        return authentificationRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Authentification get(Long id) {
        log.info("getting authentification of id : "+ id);
        return authentificationRepository.findById(id).get();
    }

    @Override
    public Authentification update(Authentification authentification) {
        log.info("Updating Authentification");
        return authentificationRepository.save(authentification);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Authentification of id :{}", id);
        authentificationRepository.deleteById(id);
        return TRUE;
    }

    @Override
    public Authentification getByUsername(String username) {
        return authentificationRepository.findByUsername(username);
    }
}
