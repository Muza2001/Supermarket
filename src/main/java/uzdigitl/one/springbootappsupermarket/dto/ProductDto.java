package uzdigitl.one.springbootappsupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private Long category_Id;
    private Long measurment_Id;
    private UUID ProductCode;
    private List<Long> attachment_Id;


}
