package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.CurrensyDto;
import uzdigitl.one.springbootappsupermarket.entity.Currensy;
import uzdigitl.one.springbootappsupermarket.service.CurrensyService;

@RequiredArgsConstructor
@RestController("/api/v1/currensy")
public class CurrensyController {

    private final CurrensyService currensyService;

    @RequestMapping(value = "/post3", method = RequestMethod.POST)
    public Currensy save(@RequestBody CurrensyDto dto){
        return currensyService.save(dto);
    }

    @RequestMapping(value = "/3/{id}", method = RequestMethod.GET)
    public Currensy getCurrensy(@PathVariable Long id){
        return currensyService.findById(id);
    }

    @DeleteMapping("/3/{id}")
    public String delete(@PathVariable("id") Long id) throws ClassNotFoundException {
       return currensyService.delete(id);
    }
    
}
