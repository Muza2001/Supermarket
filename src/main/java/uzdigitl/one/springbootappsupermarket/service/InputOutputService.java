package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.InputOutputDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

import java.util.List;

public interface InputOutputService {
    Response save(InputOutputDto dto) throws ObjectNotFoundExeption;

    Response saveDetail(List<InputOutputDto.DetailDto> dto, Long id);
}
