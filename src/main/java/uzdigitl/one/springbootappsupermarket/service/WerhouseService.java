package uzdigitl.one.springbootappsupermarket.service;


import uzdigitl.one.springbootappsupermarket.dto.WerhouseDto;
import uzdigitl.one.springbootappsupermarket.entity.Werhouse;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;

public interface WerhouseService {
    Werhouse save(WerhouseDto dto);

    Werhouse findById(Long id) throws ObjectNotFoundExeption;

    String delete(Long id) throws ObjectNotFoundExeption;
}
