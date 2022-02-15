package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.web.multipart.MultipartFile;
import uzdigitl.one.springbootappsupermarket.entity.Attachment;

import java.io.IOException;

public interface AttachmentService {

    Attachment uploadToDb(MultipartFile multipartFile) throws IOException;

    Attachment findById(Long id) throws ClassNotFoundException;
}
