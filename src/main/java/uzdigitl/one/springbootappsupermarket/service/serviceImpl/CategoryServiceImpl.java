package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.CategoryDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
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
    public ResponseEntity<?> save(CategoryDto dto) {
        Long parent_id = dto.getParent_id();
        Response response = new Response();
        Optional<Category> categoryOptional = categoryRepository.findById(parent_id);
        Category category;
        if (categoryOptional.isEmpty()){
            categoryRepository.save( new Category(
                    dto.getName(),
                    true
            ));
            response.setStatus(true);
            response.setMessage("Successfully saved");
            return ResponseEntity.ok().body(response);
        } else {
            Category category1 = categoryOptional.get();
            categoryRepository.save(new Category(
                    dto.getName(),
                    category1,
                    true));
            response.setStatus(true);
            response.setMessage("Successfully saved");
            return ResponseEntity.ok().body(response);
        }
    }

    @Override
    public  ResponseEntity<?> findById(Long id) throws ClassNotFoundException {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");
        Category category = byId.get();
        Response response = new Response(true, "Category ", category);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public  ResponseEntity<?> delete(Long id) throws ObjectNotFoundExeption {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        categoryRepository.delete(byId.get());
        Response response = new Response(true, "Successfuly Delete ");
        return ResponseEntity.ok().body(response);
    }
}
