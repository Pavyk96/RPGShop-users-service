package payk96.rpg_shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payk96.rpg_shop.dto.UserResponse;
import payk96.rpg_shop.service.UsersService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UsersService service;

    @GetMapping("/user/{id}")
    public UserResponse getById(@PathVariable String id) {
        return service.getUserById(id);
    }
}
