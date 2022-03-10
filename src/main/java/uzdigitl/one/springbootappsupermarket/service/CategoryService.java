package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.CategoryDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface CategoryService {
    ResponseEntity<?> save(CategoryDto dto);

    ResponseEntity<?> findById(Long id) throws ClassNotFoundException;

    ResponseEntity<?> delete(Long id) throws ObjectNotFoundExeption;
}
