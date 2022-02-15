package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.CategoryDto;
import uzdigitl.one.springbootappsupermarket.entity.Category;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.CategoryService;
@RequiredArgsConstructor
@RestController("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @RequestMapping(value = "/post2", method = RequestMethod.POST)
    public Category save(@RequestBody CategoryDto dto){
        return categoryService.save(dto);
    }

    @RequestMapping(value = "/2/{id}", method = RequestMethod.GET)
    public Category findById(@PathVariable("id") Long id) throws ClassNotFoundException {
        return categoryService.findById(id);
    }

    @RequestMapping(value = "/2/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) throws ObjectNotFoundExeption {
        return categoryService.delete(id);
    }

}
