package uzdigitl.one.springbootappsupermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uzdigitl.one.springbootappsupermarket.entity.Currensy;

@Repository
public interface CurrensyRepository extends JpaRepository<Currensy, Long> {
}
