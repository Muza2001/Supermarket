package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.CategoryDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.CategoryService;
@RequiredArgsConstructor
@RestController("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CategoryDto dto){
        return categoryService.save(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public  ResponseEntity<?> findById(@PathVariable("id") Long id) throws ClassNotFoundException {
        return categoryService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public  ResponseEntity<?> delete(@PathVariable("id") Long id) throws ObjectNotFoundExeption {
        return categoryService.delete(id);
    }

}
