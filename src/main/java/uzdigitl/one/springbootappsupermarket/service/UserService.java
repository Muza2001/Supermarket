package uzdigitl.one.springbootappsupermarket.service;

import org.springframework.http.ResponseEntity;
import uzdigitl.one.springbootappsupermarket.dto.UserDto;

public interface UserService {
    ResponseEntity<?> save(UserDto dto);

    ResponseEntity<?> findById(Long id) throws ClassNotFoundException;

    ResponseEntity<?> delete(Long id) throws ClassNotFoundException;
}
