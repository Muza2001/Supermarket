package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.InputOutputDto;
import uzdigitl.one.springbootappsupermarket.dto.Response;
import uzdigitl.one.springbootappsupermarket.entity.InputOutput;
import uzdigitl.one.springbootappsupermarket.entity.InputOutputProduct;
import uzdigitl.one.springbootappsupermarket.repository.InputOutputProductRepository;
import uzdigitl.one.springbootappsupermarket.repository.InputOutputRepository;
import uzdigitl.one.springbootappsupermarket.service.DashBoardService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DashBoardServiceImpl implements DashBoardService {

    private final InputOutputRepository inputOutputRepository;
    private final InputOutputProductRepository inputOutputProductRepository;
    @Override
    public Response getIncomeByDataRange(LocalDateTime start , LocalDateTime end) {
        List<InputOutput> list = inputOutputRepository.selectgetIncomeByDataRange(start,end);
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
        return new Response(true,"Successfuly", result);
    }
}
