package ma.emsi.hotelManager.service.implementation;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Service;
import ma.emsi.hotelManager.repository.ServiceRepository;
import ma.emsi.hotelManager.service.ServiceService;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
@Transactional
@Slf4j
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

    @Override
    public Service create(Service service) {
        log.info("Saving Service");
        return serviceRepository.save(service);
    }


    @Override
    public List<Service> list(int limit) {
        log.info("Showing Services");
        return serviceRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Service get(Long id) {
        log.info("getting service of id : "+ id);
        return serviceRepository.findById(id).get();
    }

    @Override
    public Service update(Service service) {
        log.info("Updating Service");
        return serviceRepository.save(service);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Service of id :{}", id);
        serviceRepository.deleteById(id);
        return TRUE;
    }
}
