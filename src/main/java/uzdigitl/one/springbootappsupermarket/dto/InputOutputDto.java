package uzdigitl.one.springbootappsupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputOutputDto {
    private LocalDate date;
    private Long werhouse_Id;
    private Long supplier_Id;
    private Long currensy_Id;
    private String factureNumber;
    private String operationNumber;
    private String type;

}
