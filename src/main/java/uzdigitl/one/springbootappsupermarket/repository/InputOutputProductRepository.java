package uzdigitl.one.springbootappsupermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uzdigitl.one.springbootappsupermarket.entity.InputOutputProduct;

@Repository
public interface InputOutputProductRepository extends JpaRepository<InputOutputProduct, Long> {
}
