package uzdigitl.one.springbootappsupermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InputOutput {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Werhouse werhouse;

    @ManyToOne
    private User supplier;

    @ManyToOne
    private Currensy currensy;

    @Column(unique = true, nullable = false)
    private String factureNumber;

    private UUID code;

    @Enumerated(EnumType.STRING)
    private InputOutputType type = InputOutputType.INPUT;

    public InputOutput(LocalDate date, Werhouse werhouse, User supplier,
                       Currensy currensy, String factureNumber, UUID code, InputOutputType type) {
        this.date = date;
        this.werhouse = werhouse;
        this.supplier = supplier;
        this.currensy = currensy;
        this.factureNumber = factureNumber;
        this.code = code;
        this.type = type;
    }



}
