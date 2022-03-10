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

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "OrginalName",nullable = false)
    private String OrginalName;

    @Column(name = "contenttype")
    private String contenttype;

    @Column(name = "contensizettype")
    private Long size;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "data")
    private byte[] data;

    @Column(name = "path")
    private String path;

    public Attachment(String name, String orginalName, String contenttype,
                      Long size, Boolean status, byte[] data, String path) {
        this.name = name;
        OrginalName = orginalName;
        this.contenttype = contenttype;
        this.size = size;
        this.status = status;
        this.data = data;
        this.path = path;
    }
    public Attachment(String name, String orginalName, byte[] data, long size, String contentType) {
        this.name = name;
        this.OrginalName = orginalName;
        this.data = data;
        this.size = size;
        this.contenttype = contentType;
    }
}
