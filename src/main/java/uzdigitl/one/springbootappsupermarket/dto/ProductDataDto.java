package uzdigitl.one.springbootappsupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uzdigitl.one.springbootappsupermarket.entity.InputOutput;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataDto {

    private Long productId;
    private String productName;
    private LocalDateTime expireData;
    private Double amount;
    private Double price;
    private InputOutput inputOutput;

    public ProductDataDto(Long productId, String productName, LocalDateTime expireData, Double amount, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.expireData = expireData;
        this.amount = amount;
        this.price = price;
    }
}
