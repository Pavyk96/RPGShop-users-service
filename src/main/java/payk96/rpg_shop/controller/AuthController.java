package payk96.rpg_shop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payk96.rpg_shop.dto.KeycloakTokens;
import payk96.rpg_shop.service.AuthService;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<KeycloakTokens> login(
            @RequestParam String username,
            @RequestParam String password) {
        KeycloakTokens tokens = authService.login(username, password);

        return ResponseEntity.ok(tokens);
    }

    @PostMapping("/refresh")
    public ResponseEntity<KeycloakTokens> refresh(
            @RequestParam String refresh_token) {
        KeycloakTokens tokens = authService.refresh(refresh_token);

        return ResponseEntity.ok(tokens);
    }
}