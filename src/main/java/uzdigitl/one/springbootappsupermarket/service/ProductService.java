package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.ProductDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface ProductService {
    ResponseEntity<?> save(ProductDto dto) throws ObjectNotFoundExeption;

    ResponseEntity<?> findById(Long id) throws ClassNotFoundException;

    ResponseEntity<?> findByIdDelete(Long id) throws ClassNotFoundException;
}
