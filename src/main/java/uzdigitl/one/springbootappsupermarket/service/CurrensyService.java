package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.CurrensyDto;

public interface CurrensyService {
    ResponseEntity<?> save(CurrensyDto dto);

    ResponseEntity<?> findById(Long id);

    ResponseEntity<?> delete(Long id) throws ClassNotFoundException;
}
