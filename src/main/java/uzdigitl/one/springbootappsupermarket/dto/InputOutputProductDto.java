package uzdigitl.one.springbootappsupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputOutputProductDto {

    private Long product_Id;
    private Long inputOutput_Id;
    private Double price;
    private Double amount;
    private LocalDate expireData;
}
