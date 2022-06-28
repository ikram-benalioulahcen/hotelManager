package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Employe;
import ma.emsi.hotelManager.repository.EmployeRepository;
import ma.emsi.hotelManager.service.EmployeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j // for logs
public class EmployeServiceImpl implements EmployeService {

    private final EmployeRepository employeRepository;
    @Override
    public Employe create(Employe employe) {
        log.info("Saving Employe");
        return employeRepository.save(employe);
    }


    @Override
    public List<Employe> list(int limit) {
        log.info("Showing Employes");
        return employeRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Employe get(Long id) {
        Employe employe = employeRepository.findById(id).get();
        return employe;
    }

    @Override
    public Employe update(Employe employe) {
        log.info("Updating Employe");
        return employeRepository.save(employe);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Employe by id :{}", id);
        employeRepository.deleteById(id);
        return TRUE;
    }
}
