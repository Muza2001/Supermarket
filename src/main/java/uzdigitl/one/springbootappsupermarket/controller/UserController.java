package uzdigitl.one.springbootappsupermarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzdigitl.one.springbootappsupermarket.dto.UserDto;
import uzdigitl.one.springbootappsupermarket.service.UserService;

@RequiredArgsConstructor
@RestController("/api/v1/user")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UserDto dto){
        return userService.save(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) throws ClassNotFoundException {
        return userService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) throws ClassNotFoundException {
        return userService.delete(id);
    }

}
