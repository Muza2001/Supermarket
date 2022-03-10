package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.MeasurmentDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface MeasurmentService {
    ResponseEntity<?> save(MeasurmentDto dto);

    ResponseEntity<?> findById(Long id) throws ObjectNotFoundExeption;

    ResponseEntity<?> delete(Long id) throws ObjectNotFoundExeption;
}
