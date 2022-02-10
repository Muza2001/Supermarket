package uzdigitl.one.springbootappsupermarket.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Measurment measurment;

    @Column(unique = true, nullable = false)
    private UUID ProductCode;

    @ManyToMany
    private List<Attachment> attachment;

    public Product(String name, Category category, Measurment measurment,
                   UUID productCode, List<Attachment> attachment) {
        this.name = name;
        this.category = category;
        this.measurment = measurment;
        ProductCode = productCode;
        this.attachment = attachment;
    }
}
