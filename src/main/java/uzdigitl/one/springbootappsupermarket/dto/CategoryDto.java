package uzdigitl.one.springbootappsupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String name;
    private Long parent_id;
    private Boolean active;

    public CategoryDto(String name, Boolean active) {
        this.name = name;
        this.active = active;
    }
}
