package uzdigitl.one.springbootappsupermarket.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.RoleDto;
import uzdigitl.one.springbootappsupermarket.service.RoleService;
@RequiredArgsConstructor
@RestController("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody RoleDto dto){
        return roleService.save(dto);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) throws ClassNotFoundException {
        return roleService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) throws ClassNotFoundException {
        return roleService.findByIdDelete(id);
    }

}

