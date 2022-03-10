package uzdigitl.one.springbootappsupermarket.service;


import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.WerhouseDto;
import uzdigitl.one.springbootappsupermarket.entity.Werhouse;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface WerhouseService {
    ResponseEntity<?> save(WerhouseDto dto);

    ResponseEntity<?> findById(Long id) throws ObjectNotFoundExeption;

    ResponseEntity<?> delete(Long id) throws ObjectNotFoundExeption;
}
