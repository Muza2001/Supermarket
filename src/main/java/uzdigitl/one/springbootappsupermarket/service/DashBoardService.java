package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.Response;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;

import java.time.LocalDateTime;

public interface DashBoardService {

    /**
     * Kunlik kirim bolgan mahsulotlar
     * @param start
     * @param end
     * @return
     */
    ResponseEntity<?> getIncomeByDataRange(LocalDateTime start, LocalDateTime end, InputOutputType type);

    ResponseEntity<?> getTop10InputOutputByDataRange(LocalDateTime start, LocalDateTime end, InputOutputType type);

    ResponseEntity<?> getAllExpireDataSoonProducts();
}
