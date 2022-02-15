package uzdigitl.one.springbootappsupermarket.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzdigitl.one.springbootappsupermarket.dto.UserDto;
import uzdigitl.one.springbootappsupermarket.entity.Role;
import uzdigitl.one.springbootappsupermarket.entity.User;
import uzdigitl.one.springbootappsupermarket.repository.RoleRepository;
import uzdigitl.one.springbootappsupermarket.repository.UserRepository;
import uzdigitl.one.springbootappsupermarket.repository.WerhouseRepository;
import uzdigitl.one.springbootappsupermarket.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WerhouseRepository werhouseRepository;
    private final RoleRepository roleRepository;
    @Override
    public User save(UserDto dto) {

        List<Role> roles = new ArrayList<>();
        List<Long> role_id = dto.getRole_Id();
        for (Long a : role_id) {
            if (a != null) {
                Optional<Role> byId = roleRepository.findById(a);
                byId.ifPresent(roles::add);
            }
        }
        return userRepository.save(new User(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getPhoneNumber(),
                dto.getUserNumber(),
                dto.getPassword(),
                werhouseRepository.findById(dto.getWerhouse_Id()).orElseThrow(() -> new ClassCastException("Id not found")),
                roles
        ));
    }

    @Override
    public User findById(Long id) throws ClassNotFoundException {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty())
            throw new ClassNotFoundException("Id not found");

        return byId.get();
    }

    @Override
    public String delete(Long id) throws ClassNotFoundException {
        User byId = findById(id);
        userRepository.delete(byId);
        return "Successfuly Delete !!!";
    }
}
