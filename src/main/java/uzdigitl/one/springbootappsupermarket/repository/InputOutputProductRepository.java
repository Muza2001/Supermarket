package uzdigitl.one.springbootappsupermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uzdigitl.one.springbootappsupermarket.dto.ProductDataDto;
import uzdigitl.one.springbootappsupermarket.entity.InputOutputProduct;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InputOutputProductRepository extends JpaRepository<InputOutputProduct, Long> {

    List<InputOutputProduct> findAllByInputOutputId(Long inputOutput_id);


    @Query("select new uzdigitl.one.springbootappsupermarket.dto.ProductDataDto(io.product.id, io.expireData, io.amount, io.price, io.inputOutput)from InputOutputProduct io where io.expireData < ?1")
    List<ProductDataDto> selectAllExpireDataSon(LocalDateTime time);


}
