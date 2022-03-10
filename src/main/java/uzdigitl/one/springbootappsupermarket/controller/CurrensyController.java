package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.CurrensyDto;
import uzdigitl.one.springbootappsupermarket.service.CurrensyService;

@RequiredArgsConstructor
@RestController("/api/v1/currensy")
public class CurrensyController {

    private final CurrensyService currensyService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody CurrensyDto dto){
        return currensyService.save(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrensy(@PathVariable Long id){
        return currensyService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) throws ClassNotFoundException {
       return currensyService.delete(id);
    }
    
}
