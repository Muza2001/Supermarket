package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.RoleDto;

public interface RoleService {
    ResponseEntity<?> save(RoleDto dto);

    ResponseEntity<?> findById(Long id) throws ClassNotFoundException;

    ResponseEntity<?> findByIdDelete(Long id) throws ClassNotFoundException;
}
