package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.UserDto;
import uzdigitl.one.springbootappsupermarket.entity.User;

public interface UserService {
    User save(UserDto dto);

    User findById(Long id) throws ClassNotFoundException;

    String delete(Long id) throws ClassNotFoundException;
}
