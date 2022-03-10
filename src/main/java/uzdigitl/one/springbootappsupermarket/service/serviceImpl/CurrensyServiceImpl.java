package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.CurrensyDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
import uzdigitl.one.springbootappsupermarket.entity.Currensy;
import uzdigitl.one.springbootappsupermarket.repository.CurrensyRepository;
import uzdigitl.one.springbootappsupermarket.service.CurrensyService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CurrensyServiceImpl implements CurrensyService {

    private final CurrensyRepository currensyRepository;
    @Override
    public ResponseEntity<?> save(CurrensyDto dto) {
        Currensy save = currensyRepository.save(new Currensy(dto.getName()));
        Response response = new Response(true,"Successfully saved", save);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Currensy> byId = currensyRepository.findById(id);
        Currensy currensy = byId.get();
        Response response = new Response(true, "Currensy ",currensy );
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws ClassNotFoundException {
        Optional<Currensy> byId = currensyRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");
        Currensy currensy = byId.get();
        currensyRepository.delete(currensy);
        Response response = new Response(true, "Successfully deleted ");
        return ResponseEntity.ok().body(response);
    }
}
