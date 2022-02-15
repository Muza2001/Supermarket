package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.ProductDto;
import uzdigitl.one.springbootappsupermarket.entity.Product;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface ProductService {
    Product save(ProductDto dto) throws ObjectNotFoundExeption;

    Product findById(Long id) throws ClassNotFoundException;

    String findByIdDelete(Long id) throws ClassNotFoundException;
}
