package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.ProductDataDto;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;

import java.time.LocalDateTime;
import java.util.List;

public interface DashBoardService {

    ResponseEntity<?> getIncomeByDataRange(LocalDateTime start, LocalDateTime end, InputOutputType type);

    ResponseEntity<?> getTop10InputOutputByDataRange(LocalDateTime start, LocalDateTime end, InputOutputType type);

    ResponseEntity<?> getAllExpireDataSoonProducts();

    List<ProductDataDto> forGetAllExpireDataSoonProducts();
}
