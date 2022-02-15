package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.RoleDto;
import uzdigitl.one.springbootappsupermarket.entity.Role;
import uzdigitl.one.springbootappsupermarket.service.RoleService;
@RequiredArgsConstructor
@RestController("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    @RequestMapping(value = "/post8", method = RequestMethod.POST)
    public Role save(@RequestBody RoleDto dto){
        return roleService.save(dto);
    }

    @RequestMapping(value = "/8/{id}",method = RequestMethod.GET)
    public Role findById(@PathVariable Long id) throws ClassNotFoundException {
        return roleService.findById(id);
    }

    @RequestMapping(value = "/8/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) throws ClassNotFoundException {
        return roleService.findByIdDelete(id);
    }

}

