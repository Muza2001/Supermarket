package uzdigitl.one.springbootappsupermarket.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    private Category parent_id;

    private Boolean active;

    public Category(String name, Category parent_id, Boolean active) {
        this.name = name;
        this.parent_id = parent_id;
        this.active = active;
    }

    public Category(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }
}
