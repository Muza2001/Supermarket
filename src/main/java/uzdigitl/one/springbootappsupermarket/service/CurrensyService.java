package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.CurrensyDto;
import uzdigitl.one.springbootappsupermarket.entity.Currensy;

public interface CurrensyService {
    Currensy save(CurrensyDto dto);

    Currensy findById(Long id);

    String delete(Long id) throws ClassNotFoundException;
}
