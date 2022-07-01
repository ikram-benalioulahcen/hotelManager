package ma.emsi.hotelManager.service;

import ma.emsi.hotelManager.model.Type;

import java.util.List;

public interface TypeService {
    Type create(Type type);
    List<Type> list(int limit);
    Type get(Long id);
    Type update(Type type);
    Boolean delete(Long id);
}
