package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.InputOutputDto;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

import java.util.List;

public interface InputOutputService {
    ResponseEntity<?> save(InputOutputDto dto) throws ObjectNotFoundExeption;

    ResponseEntity<?> saveDetail(List<InputOutputDto.DetailDto> dto, Long id);
}
