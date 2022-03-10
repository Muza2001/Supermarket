package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.MeasurmentDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.MeasurmentService;

@RequiredArgsConstructor
@RestController("/api/v1/measurment")
public class MeasurmentController {

    private final MeasurmentService measurmentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody MeasurmentDto dto){
        return measurmentService.save(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable("id") Long id) throws ObjectNotFoundExeption {
        return measurmentService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) throws ObjectNotFoundExeption {
        return measurmentService.delete(id);
    }

}
