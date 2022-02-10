package uzdigitl.one.springbootappsupermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uzdigitl.one.springbootappsupermarket.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
