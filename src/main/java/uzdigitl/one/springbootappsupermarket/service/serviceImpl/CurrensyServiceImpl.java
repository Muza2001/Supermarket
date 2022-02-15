package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.CurrensyDto;
import uzdigitl.one.springbootappsupermarket.entity.Currensy;
import uzdigitl.one.springbootappsupermarket.repository.CurrensyRepository;
import uzdigitl.one.springbootappsupermarket.service.CurrensyService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CurrensyServiceImpl implements CurrensyService {

    private final CurrensyRepository currensyRepository;
    @Override
    public Currensy save(CurrensyDto dto) {
        return currensyRepository.save(new Currensy(dto.getName()));
    }

    @Override
    public Currensy findById(Long id) {
        Optional<Currensy> byId = currensyRepository.findById(id);
        return byId.orElse(null);
    }

    @Override
    public String delete(Long id) throws ClassNotFoundException {
        Optional<Currensy> byId = currensyRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");
        Currensy currensy = byId.get();
        currensyRepository.delete(currensy);
        return "Successfuly delete";
    }
}
