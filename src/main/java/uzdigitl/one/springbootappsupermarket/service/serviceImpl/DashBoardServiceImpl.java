package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.InputOutputDto;
import uzdigitl.one.springbootappsupermarket.dto.ProductDataDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
import uzdigitl.one.springbootappsupermarket.entity.InputOutput;
import uzdigitl.one.springbootappsupermarket.entity.InputOutputProduct;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;
import uzdigitl.one.springbootappsupermarket.repository.InputOutputProductRepository;
import uzdigitl.one.springbootappsupermarket.repository.InputOutputRepository;
import uzdigitl.one.springbootappsupermarket.service.DashBoardService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DashBoardServiceImpl implements DashBoardService {

    private final InputOutputRepository inputOutputRepository;
    private final InputOutputProductRepository inputOutputProductRepository;
    @Override
    public ResponseEntity<?> getIncomeByDataRange(LocalDateTime start , LocalDateTime end, InputOutputType type) {
        List<InputOutput> list = inputOutputRepository.selectgetIncomeByDataRange(start,end, type);
        List<InputOutputDto.GetDto> result = getIncomes(list);
        Response response = new Response(true, "Successfuly", Collections.singletonList(result));
        return ResponseEntity.ok().body(response);
    }

    private List<InputOutputDto.GetDto> getIncomes(List<InputOutput> list) {
        List<InputOutputDto.GetDto> result = new ArrayList<>();

        for (InputOutput a : list){
            List<InputOutputProduct> allByInputOutputId = inputOutputProductRepository.findAllByInputOutputId(a.getId());
            InputOutputDto.GetDto inputOutput = new InputOutputDto.GetDto(
                    a.getDate(),
                    a.getWerhouse(),
                    a.getSupplier(),
                    a.getCurrensy(),
                    a.getCode(),
                    a.getType(),
                    allByInputOutputId
            );
            result.add(inputOutput);
        }
        return result;
    }

    @Override
    public ResponseEntity<?> getTop10InputOutputByDataRange(LocalDateTime start, LocalDateTime end, InputOutputType type) {

        List<InputOutput> list = inputOutputRepository.selectAllTop10(start,end,type);
        List<InputOutputDto.GetDto> result = getIncomes(list);
        Response response = new Response(true, "Successfuly", Collections.singletonList(result));
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> getAllExpireDataSoonProducts() {
        List<ProductDataDto> productDataDtos = inputOutputProductRepository
                .selectAllExpireDataSon(LocalDateTime.now()
                .plus(1, ChronoUnit.WEEKS));
        Response response = new Response(true, "Product list experi data", Collections.singletonList(productDataDtos));
        return ResponseEntity.ok().body(response);
    }
}
