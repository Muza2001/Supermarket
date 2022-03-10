package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.Response;
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
    public ResponseEntity<?> save(RoleDto dto) {
        Role save = roleRepository.save(new Role(dto.getName()));
        Response response = new Response(true, "Successfuly save", save);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> findById(Long id) throws ClassNotFoundException {
        Role role = optionalRole(id);
        Response response = new Response(true, "Successfuly role", role);
        return ResponseEntity.ok().body(response);
    }

    public Role optionalRole(Long id) throws ClassNotFoundException {
        Optional<Role> byId = roleRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");
        return byId.get();
    }

    @Override
    public ResponseEntity<?> findByIdDelete(Long id) throws ClassNotFoundException {
        Role byId = optionalRole(id);
        roleRepository.delete(byId);
        return ResponseEntity.ok().body(new Response(true ,"Successfuly Delete !!!"));
    }
}
