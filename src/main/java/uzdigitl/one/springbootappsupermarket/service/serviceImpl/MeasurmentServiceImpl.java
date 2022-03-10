package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.MeasurmentDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
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
    public ResponseEntity<?> save(MeasurmentDto dto) {
        Measurment measurment = new Measurment(dto.getName());
        Response response = new Response(true, "Successfully save", measurment);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws ObjectNotFoundExeption {
        Optional<Measurment> byId = measurmentRepository.findById(id);
        if (byId.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        Measurment measurment = byId.get();
        Response response = new Response(true, "Mesurment", measurment);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws ObjectNotFoundExeption {
        Optional<Measurment> optionalMeasurment = measurmentRepository.findById(id);

        if (optionalMeasurment.isEmpty())
            throw new ObjectNotFoundExeption("Id not found");

        measurmentRepository.delete(optionalMeasurment.get());
        Response response = new Response(true, "Successfully delete");
        return ResponseEntity.ok().body(response);
    }
}
