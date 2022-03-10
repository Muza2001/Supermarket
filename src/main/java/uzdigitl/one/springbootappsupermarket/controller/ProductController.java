package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.ProductDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.ProductService;

@RequiredArgsConstructor
@RestController("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ProductDto dto) throws ObjectNotFoundExeption {
        return productService.save(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) throws ClassNotFoundException {
        return productService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) throws ClassNotFoundException {
        return productService.findByIdDelete(id);
    }

}
