package uzdigitl.one.springbootappsupermarket.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileResponse {

    private String fileName;
    private String downloadUrl;
    private String type;
    private Long size;
}
