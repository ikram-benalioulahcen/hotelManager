package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Chambre;
import ma.emsi.hotelManager.model.Client;
import ma.emsi.hotelManager.repository.ChambreRepository;
import ma.emsi.hotelManager.repository.ClientRepository;
import ma.emsi.hotelManager.service.ChambreService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ChambreServiceImpl implements ChambreService {

    private final ChambreRepository chambreRepository;

    @Override
    public Chambre create(Chambre chambre) {
        log.info("Saving chambre");
        return chambreRepository.save(chambre);
    }


    @Override
    public List<Chambre> list(int limit) {
        log.info("Showing Chambres");
        return chambreRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Chambre get(Long id) {
        log.info("getting chambre of id : "+ id);
        return chambreRepository.findById(id).get();
    }

    @Override
    public Chambre update(Chambre chambre) {
        log.info("Updating Chambre");
        return chambreRepository.save(chambre);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Chambre of id :{}", id);
        chambreRepository.deleteById(id);
        return TRUE;
    }
}
