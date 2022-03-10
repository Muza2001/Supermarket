package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.WerhouseDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.WerhouseService;

@RequiredArgsConstructor
@RestController("/api/v1/werhouse")
public class WerhouseController {

    private final WerhouseService werhouseService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody WerhouseDto dto){
        return werhouseService.save(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) throws ObjectNotFoundExeption {
        return werhouseService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) throws ObjectNotFoundExeption {
        return werhouseService.delete(id);
    }
}
