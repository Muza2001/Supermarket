package uzdigitl.one.springbootappsupermarket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(nullable = false)
    private String OrginalName;

    private String contenttype;

    private Integer size;

    private Boolean status;

    private byte[] data;

    private String path;

    public Attachment(String name, String orginalName, String contenttype,
                      Integer size, Boolean status, byte[] data, String path) {
        this.name = name;
        OrginalName = orginalName;
        this.contenttype = contenttype;
        this.size = size;
        this.status = status;
        this.data = data;
        this.path = path;
    }
}
