package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.Response;
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
    public ResponseEntity<?> save(WerhouseDto dto) {
        Werhouse save = werhouseRepository.save(new Werhouse(
                dto.getName(),
                dto.isActive()
        ));
        return ResponseEntity.ok().body(new Response(true, "Successfully save", save));
    }

    public Werhouse optionalWerhouse(Long id) throws ObjectNotFoundExeption {
        Optional<Werhouse> byId = werhouseRepository.findById(id);
        if (byId.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        return byId.get();
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws ObjectNotFoundExeption {
        Werhouse werhouse = optionalWerhouse(id);
        return ResponseEntity.ok().body(new Response(true, "Werhouse", werhouse));
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws ObjectNotFoundExeption {
        Werhouse byId = optionalWerhouse(id);
        werhouseRepository.delete(byId);
        return ResponseEntity.ok().body(new Response(true,"Successfuly Delete !!!"));
    }
}
