package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uzdigitl.one.springbootappsupermarket.entity.Attachment;
import uzdigitl.one.springbootappsupermarket.rest.UploadFileResponse;
import uzdigitl.one.springbootappsupermarket.service.AttachmentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController("/api/v1/attachment")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @RequestMapping(value = "/post1/upload_file/db", method = RequestMethod.POST)
    public UploadFileResponse upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        Attachment attachment = attachmentService.uploadToDb(multipartFile);

        String downloadUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/v1/attachment/post1/download/")
                .path(attachment.getId()
                .toString())
                .toUriString();
        return new UploadFileResponse(attachment.getOrginalName(),downloadUrl, attachment.getContenttype(), attachment.getSize());
    }

    @RequestMapping(value = "/post1/upload_file/list/db", method = RequestMethod.POST)
    public List<UploadFileResponse> uploadList(@RequestParam("files") List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFileResponse> uploadFileResponses = new ArrayList<>();

        for (MultipartFile  a : multipartFiles) {
            uploadFileResponses.add(upload(a));
        }
        return uploadFileResponses;
    }

    @RequestMapping(value = "/post1/download/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> downloadFileToDb(@PathVariable Long id) throws ClassNotFoundException {
        Attachment attachment = attachmentService.findById(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getContenttype()))
                .body(new ByteArrayResource(attachment.getData()));
    }
}
