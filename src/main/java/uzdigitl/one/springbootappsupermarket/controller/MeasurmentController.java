package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.MeasurmentDto;
import uzdigitl.one.springbootappsupermarket.entity.Measurment;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.MeasurmentService;

@RequiredArgsConstructor
@RestController("/api/v1/measurment")
public class MeasurmentController {

    private final MeasurmentService measurmentService;

    @RequestMapping(value = "/post6", method = RequestMethod.POST)
    public Measurment save(@RequestBody MeasurmentDto dto){
        return measurmentService.save(dto);
    }

    @RequestMapping(value = "/6/{id}", method = RequestMethod.GET)
    public Measurment findById(@PathVariable("id") Long id) throws ObjectNotFoundExeption {
        return measurmentService.findById(id);
    }

    @RequestMapping(value = "/6/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) throws ObjectNotFoundExeption {
        return measurmentService.delete(id);
    }

}
