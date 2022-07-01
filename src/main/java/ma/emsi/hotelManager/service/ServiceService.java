package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Service;

import java.util.List;

public interface ServiceService {
    Service create(Service service);
    List<Service> list(int limit);
    Service get(Long id);
    Service update(Service service);
    Boolean delete(Long id);
}
