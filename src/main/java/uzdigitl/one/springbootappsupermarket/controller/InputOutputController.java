package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uzdigitl.one.springbootappsupermarket.dto.InputOutputDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.service.InputOutputService;

import java.util.List;

@RestController("/api/v1/input_output")
@RequiredArgsConstructor
public class InputOutputController {

    private final InputOutputService inputOutputService;


    @PostMapping("/post4")
    public Response save(@RequestBody InputOutputDto dto) throws ObjectNotFoundExeption {
       return inputOutputService.save(dto);
    }

    @PostMapping("/4/{id}/details")
    public Response saveDetail(@PathVariable Long id, @RequestBody List<InputOutputDto.DetailDto> dto){
        return inputOutputService.saveDetail(dto, id);
    }


}
