package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uzdigitl.one.springbootappsupermarket.entity.Attachment;
import uzdigitl.one.springbootappsupermarket.repository.AttachmentRepository;
import uzdigitl.one.springbootappsupermarket.service.AttachmentService;

import javax.annotation.processing.FilerException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    @Override
    public Attachment uploadToDb(MultipartFile multipartFile) throws IOException {

        String orginalFilename = multipartFile.getOriginalFilename();

        if ( orginalFilename != null && orginalFilename.contains(".."))
            throw new FilerException("File not found" + orginalFilename);

        String uniqueName = System.currentTimeMillis() + "_" + multipartFile.getName();

        return attachmentRepository.save(new Attachment(
            orginalFilename,
            uniqueName,
            multipartFile.getBytes(),
            multipartFile.getSize(),
            multipartFile.getContentType()
        ));
    }

    @Override
    public Attachment findById(Long id) throws ClassNotFoundException {

        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");

        return byId.get();
    }
}
