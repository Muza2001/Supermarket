package uzdigitl.one.springbootappsupermarket.service;

import uzdigitl.one.springbootappsupermarket.dto.RoleDto;
import uzdigitl.one.springbootappsupermarket.entity.Role;

public interface RoleService {
    Role save(RoleDto dto);

    Role findById(Long id) throws ClassNotFoundException;

    String findByIdDelete(Long id) throws ClassNotFoundException;
}
