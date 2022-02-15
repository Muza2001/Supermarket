package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.ProductDto;
import uzdigitl.one.springbootappsupermarket.entity.Product;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.ProductService;

@RequiredArgsConstructor
@RestController("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/post7", method = RequestMethod.POST)
    public Product save(@RequestBody ProductDto dto) throws ObjectNotFoundExeption {
        return productService.save(dto);
    }

    @RequestMapping(value = "/7/{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable Long id) throws ClassNotFoundException {
        return productService.findById(id);
    }

    @RequestMapping("/7/{id}")
    public String delete(@PathVariable Long id) throws ClassNotFoundException {
        return productService.findByIdDelete(id);
    }

}
