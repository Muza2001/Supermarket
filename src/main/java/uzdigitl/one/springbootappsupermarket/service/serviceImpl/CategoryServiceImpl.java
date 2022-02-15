package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.CategoryDto;
import uzdigitl.one.springbootappsupermarket.entity.Category;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.repository.CategoryRepository;
import uzdigitl.one.springbootappsupermarket.service.CategoryService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category save(CategoryDto dto) {
        Long parent_id = dto.getParent_id();
        Optional<Category> categoryOptional = categoryRepository.findById(parent_id);
        Category category;
        if (categoryOptional.isEmpty()){
            return category = new Category(
                    dto.getName(),
                    true
            );
        } else {
            Category category1 = categoryOptional.get();
            return category = new Category(
                    dto.getName(),
                    category1,
                    true);
        }
    }

    @Override
    public Category findById(Long id) throws ClassNotFoundException {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");

        return byId.get();
    }

    @Override
    public String delete(Long id) throws ObjectNotFoundExeption {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        categoryRepository.delete(byId.get());
        return "Successfuly Delete";
    }
}
