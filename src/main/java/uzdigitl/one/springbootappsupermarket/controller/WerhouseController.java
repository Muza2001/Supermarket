package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.WerhouseDto;
import uzdigitl.one.springbootappsupermarket.entity.Werhouse;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.WerhouseService;

@RequiredArgsConstructor
@RestController("/api/v1/werhouse")
public class WerhouseController {

    private final WerhouseService werhouseService;

    @RequestMapping(value = "/post10", method = RequestMethod.POST)
    public Werhouse save(@RequestBody WerhouseDto dto){
        return werhouseService.save(dto);
    }

    @RequestMapping(value = "/10/{id}", method = RequestMethod.GET)
    public Werhouse findById(@PathVariable Long id) throws ObjectNotFoundExeption {
        return werhouseService.findById(id);
    }

    @RequestMapping(value = "/10/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) throws ObjectNotFoundExeption {
        return werhouseService.delete(id);
    }
}
