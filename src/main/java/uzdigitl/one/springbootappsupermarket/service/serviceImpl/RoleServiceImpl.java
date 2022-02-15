package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.RoleDto;
import uzdigitl.one.springbootappsupermarket.entity.Role;
import uzdigitl.one.springbootappsupermarket.repository.RoleRepository;
import uzdigitl.one.springbootappsupermarket.service.RoleService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role save(RoleDto dto) {
        return roleRepository.save(new Role(dto.getName()));
    }

    @Override
    public Role findById(Long id) throws ClassNotFoundException {
        Optional<Role> byId = roleRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");
        return byId.get();
    }

    @Override
    public String findByIdDelete(Long id) throws ClassNotFoundException {
        Role byId = findById(id);
        roleRepository.delete(byId);
        return "Successfuly Delete !!!";
    }
}
