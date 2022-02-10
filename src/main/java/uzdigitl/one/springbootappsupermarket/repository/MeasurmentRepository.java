package uzdigitl.one.springbootappsupermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uzdigitl.one.springbootappsupermarket.entity.Measurment;

@Repository
public interface MeasurmentRepository extends JpaRepository<Measurment, Long> {
}
