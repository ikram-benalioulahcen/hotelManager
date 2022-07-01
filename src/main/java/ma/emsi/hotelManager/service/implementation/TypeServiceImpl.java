package ma.emsi.hotelManager.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.emsi.hotelManager.model.Type;
import ma.emsi.hotelManager.repository.TypeRepository;
import ma.emsi.hotelManager.service.TypeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Override
    public Type create(Type type) {
        log.info("Saving Type");
        return typeRepository.save(type);
    }


    @Override
    public List<Type> list(int limit) {
        log.info("Showing Types");
        return typeRepository.findAll(PageRequest.of( 0, limit)).toList();
    }

    @Override
    public Type get(Long id) {
        log.info("getting type of id : "+ id);
        return typeRepository.findById(id).get();
    }

    @Override
    public Type update(Type type) {
        log.info("Updating Type");
        return typeRepository.save(type);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Type of id :{}", id);
        typeRepository.deleteById(id);
        return TRUE;
    }
}
