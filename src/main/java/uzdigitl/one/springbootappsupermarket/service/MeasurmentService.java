package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.MeasurmentDto;
import uzdigitl.one.springbootappsupermarket.entity.Measurment;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface MeasurmentService {
    Measurment save(MeasurmentDto dto);

    Measurment findById(Long id) throws ObjectNotFoundExeption;

    String delete(Long id) throws ObjectNotFoundExeption;
}
