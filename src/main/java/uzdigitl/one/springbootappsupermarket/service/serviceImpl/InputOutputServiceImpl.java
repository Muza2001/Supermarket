package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.InputOutputDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
import uzdigitl.one.springbootappsupermarket.entity.InputOutput;
import uzdigitl.one.springbootappsupermarket.entity.InputOutputProduct;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.repository.*;
import uzdigitl.one.springbootappsupermarket.service.InputOutputService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InputOutputServiceImpl implements InputOutputService {

    private final InputOutputRepository inputOutputRepository;
    private final InputOutputProductRepository inputOutputProductRepository;
    private final WerhouseRepository werhouseRepository;
    private final UserRepository userRepository;
    private final CurrensyRepository currensyRepository;
    private final ProductRepository productRepository;

    @Override
    public Response save(InputOutputDto dto) throws ObjectNotFoundExeption {
        InputOutput inputOutput = new InputOutput(
            LocalDate.now(),
            werhouseRepository.findById(dto.getWerhouse_Id()).orElseThrow(() -> new ObjectNotFoundExeption("ID not found")),
            userRepository.findById(dto.getSupplier_Id()).orElseThrow(() -> new ObjectNotFoundExeption("ID not found")),
            currensyRepository.findById(dto.getCurrensy_Id()).orElseThrow(() -> new ObjectNotFoundExeption("ID not found")),
            dto.getFactureNumber(),
            UUID.randomUUID(),
            dto.getType()
        );
        inputOutputRepository.save(inputOutput);
        String message;
        InputOutputType type = dto.getType();
        if (type == InputOutputType.INPUT)
            message = "Input";
        else
            message = "Output";
        return new Response(true, message +"  Successfuly saved", inputOutput);
    }

    @Override
    public Response saveDetail(List <InputOutputDto.DetailDto> dto, Long id) {
        InputOutput inputOutput = inputOutputRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
        Set<InputOutputProduct> products = new HashSet<>();
        for (InputOutputDto.DetailDto detailDto : dto) {
            products.add(new InputOutputProduct(
                    productRepository.findById(detailDto.getProductId()).orElseThrow(() -> new RuntimeException("Product Id not found")),
                    inputOutput,
                    detailDto.getAmount(),
                    detailDto.getPrice(),
                    detailDto.getExpireData()));
        }
        if (products.size() > 0)
             inputOutputProductRepository.saveAll(products);

        return new Response(true, "Successfuly complated");
    }
}
