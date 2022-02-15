package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.MeasurmentDto;
import uzdigitl.one.springbootappsupermarket.entity.Measurment;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.repository.MeasurmentRepository;
import uzdigitl.one.springbootappsupermarket.service.MeasurmentService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MeasurmentServiceImpl implements MeasurmentService {

    private final MeasurmentRepository measurmentRepository;

    @Override
    public Measurment save(MeasurmentDto dto) {
        return new Measurment(dto.getName());
    }

    @Override
    public Measurment findById(Long id) throws ObjectNotFoundExeption {
        Optional<Measurment> byId = measurmentRepository.findById(id);
        if (byId.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        return byId.get();
    }

    @Override
    public String delete(Long id) throws ObjectNotFoundExeption {
        Optional<Measurment> optionalMeasurment = measurmentRepository.findById(id);

        if (optionalMeasurment.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        measurmentRepository.delete(optionalMeasurment.get());
        return "Successfuly Delete";
    }
}
