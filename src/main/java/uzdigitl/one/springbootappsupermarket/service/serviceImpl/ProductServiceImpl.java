package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.ProductDto;
import uzdigitl.one.springbootappsupermarket.entity.Attachment;
import uzdigitl.one.springbootappsupermarket.entity.Measurment;
import uzdigitl.one.springbootappsupermarket.entity.Product;
import uzdigitl.one.springbootappsupermarket.exeption.ObjectNotFoundExeption;
import uzdigitl.one.springbootappsupermarket.repository.AttachmentRepository;
import uzdigitl.one.springbootappsupermarket.repository.CategoryRepository;
import uzdigitl.one.springbootappsupermarket.repository.MeasurmentRepository;
import uzdigitl.one.springbootappsupermarket.repository.ProductRepository;
import uzdigitl.one.springbootappsupermarket.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final MeasurmentRepository measurmentRepository;
    private final AttachmentRepository attachmentRepository;

    @Override
    public Product save(ProductDto dto) throws ObjectNotFoundExeption {
        List<Long> attachment_id = dto.getAttachment_Id();
        List<Attachment> attachments = null;
        for (Long a : attachment_id) {
            if (a != null){
                Optional<Attachment> optional = attachmentRepository.findById(a);
                optional.ifPresent(attachments::add);
            }
        }
        return productRepository.save( new Product(
                dto.getName(),
                categoryRepository.findById(dto.getCategory_Id()).orElseThrow(() -> new ObjectNotFoundExeption("ID not found")),
                measurmentRepository.findById(dto.getMeasurment_Id()).orElseThrow(() -> new ObjectNotFoundExeption("Id not found")),
                UUID.randomUUID(),
                attachments));
    }

    @Override
    public Product findById(Long id) throws ClassNotFoundException {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");
        return byId.get();
    }

    @Override
    public String findByIdDelete(Long id) throws ClassNotFoundException {
        Product byId = findById(id);
        productRepository.delete(byId);
        return "Successfuly delete !!!";
    }
}
