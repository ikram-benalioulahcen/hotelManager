package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Facture;
import ma.emsi.hotelManager.model.Fedelite;
import ma.emsi.hotelManager.repository.FactureRepository;
import ma.emsi.hotelManager.repository.FedeliteRepository;
import ma.emsi.hotelManager.service.FedeliteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class FedeliteServiceImpl implements FedeliteService {
    private final FedeliteRepository fedeliteRepository;

    @Override
    public Fedelite create(Fedelite fedelite) {
        log.info("Saving fedelite");
        return fedeliteRepository.save(fedelite);
    }

    @Override
    public List<Fedelite> list(int limit) {
        log.info("Showing Fedelites");
        return fedeliteRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Fedelite get(Long id) {
        log.info("Showing fedelite by id  = "+ id);
        return fedeliteRepository.findById(id).get();
    }

    @Override
    public Fedelite update(Fedelite fedelite) {
        log.info("updating fedelite ");
        return fedeliteRepository.save(fedelite);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting fedelite by id  = "+ id);
        fedeliteRepository.deleteById(id);
        return TRUE;
    }
}
