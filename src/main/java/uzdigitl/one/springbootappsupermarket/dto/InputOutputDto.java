package uzdigitl.one.springbootappsupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uzdigitl.one.springbootappsupermarket.entity.Currensy;
import uzdigitl.one.springbootappsupermarket.entity.InputOutputProduct;
import uzdigitl.one.springbootappsupermarket.entity.User;
import uzdigitl.one.springbootappsupermarket.entity.Werhouse;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputOutputDto {
    private LocalDate date;
    private Long werhouse_Id;
    private Long supplier_Id;
    private Long currensy_Id;
    private String factureNumber;
    private InputOutputType type;

    // INNER CLASS
    @Data
    public static class DetailDto {
        private Long productId;
        private Double price;
        private Double amount;
        private LocalDate expireData;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetDto{
        private LocalDate date;
        private Werhouse werhouse;
        private User user;
        private Currensy currency;
        private UUID code;
        private InputOutputType type;
        private List<InputOutputProduct> deteils;

    }
}
