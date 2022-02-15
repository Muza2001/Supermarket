package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.WerhouseDto;
import uzdigitl.one.springbootappsupermarket.entity.Werhouse;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.repository.WerhouseRepository;
import uzdigitl.one.springbootappsupermarket.service.WerhouseService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WerhouseServiceImpl implements WerhouseService {

    private final WerhouseRepository werhouseRepository;
    @Override
    public Werhouse save(WerhouseDto dto) {
        return werhouseRepository.save(new Werhouse(
                dto.getName(),
                dto.isActive()
        ));
    }

    @Override
    public Werhouse findById(Long id) throws ObjectNotFoundExeption {
        Optional<Werhouse> byId = werhouseRepository.findById(id);
        if (byId.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        return byId.get();
    }

    @Override
    public String delete(Long id) throws ObjectNotFoundExeption {
        Werhouse byId = findById(id);
        werhouseRepository.delete(byId);
        return "Successfuly Delete !!!";
    }
}
