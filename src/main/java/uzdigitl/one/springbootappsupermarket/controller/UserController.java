package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.UserDto;
import uzdigitl.one.springbootappsupermarket.entity.User;
import uzdigitl.one.springbootappsupermarket.service.UserService;

@RequiredArgsConstructor
@RestController("/api/v1/user")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/post9", method = RequestMethod.POST)
    public User save(@RequestBody UserDto dto){
        return userService.save(dto);
    }

    @RequestMapping(value = "/9/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id) throws ClassNotFoundException {
        return userService.findById(id);
    }

    @RequestMapping(value = "/9/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) throws ClassNotFoundException {
        return userService.delete(id);
    }

}
