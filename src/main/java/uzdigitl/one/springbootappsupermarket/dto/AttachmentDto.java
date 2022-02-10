package uzdigitl.one.springbootappsupermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDto {

    private String name;
    private String OrginalName;
    private String contenttype;
    private Integer size;
    private Boolean status;
    private String data;
    private String path;

}
