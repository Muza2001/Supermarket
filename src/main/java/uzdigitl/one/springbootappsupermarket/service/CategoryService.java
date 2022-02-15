package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.CategoryDto;
import uzdigitl.one.springbootappsupermarket.entity.Category;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface CategoryService {
    Category save(CategoryDto dto);

    Category findById(Long id) throws ClassNotFoundException;

    String delete(Long id) throws ObjectNotFoundExeption;
}
