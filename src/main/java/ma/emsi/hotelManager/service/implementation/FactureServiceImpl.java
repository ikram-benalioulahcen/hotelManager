package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Facture;
import ma.emsi.hotelManager.repository.FactureRepository;
import ma.emsi.hotelManager.service.FactureService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;

    @Override
    public Facture create(Facture facture) {
        log.info("Saving facture");
        return factureRepository.save(facture);
    }

    @Override
    public List<Facture> list(int limit) {
        log.info("Showing Factures");
        return factureRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Facture get(Long id) {
        log.info("Showing facture by id  = "+ id);
        return factureRepository.findById(id).get();
    }

    @Override
    public Facture update(Facture facture) {
        log.info("updating facture ");
        return factureRepository.save(facture);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("deleting facture by id  = "+ id);
        factureRepository.deleteById(id);
        return TRUE;
    }
}
