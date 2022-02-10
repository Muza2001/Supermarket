package uzdigitl.one.springbootappsupermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InputOutputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private InputOutput inputOutput;

    private Double price;

    private Double amount;

    private LocalDate expireData;

    public InputOutputProduct(Product product, InputOutput inputOutput,
                              Double price, Double amount, LocalDate expireData) {
        this.product = product;
        this.inputOutput = inputOutput;
        this.price = price;
        this.amount = amount;
        this.expireData = expireData;
    }
}
