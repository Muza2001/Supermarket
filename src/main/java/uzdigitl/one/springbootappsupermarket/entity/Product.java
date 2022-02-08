package uzdigitl.one.springbootappsupermarket.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

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
    private Long ProductCode;

    @ManyToMany
    private List<Attachment> attachment;
}
