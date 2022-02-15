package uzdigitl.one.springbootappsupermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uzdigitl.one.springbootappsupermarket.dto.InputOutputDto;
import uzdigitl.one.springbootappsupermarket.entity.InputOutput;
import uzdigitl.one.springbootappsupermarket.enums.InputOutputType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InputOutputRepository extends JpaRepository<InputOutput, Long> {
    @Query("select io from InputOutput io where io.date >= ?1 and io.date <= ?2")
    List<InputOutput> selectgetIncomeByDataRange(LocalDateTime start, LocalDateTime end);

}
