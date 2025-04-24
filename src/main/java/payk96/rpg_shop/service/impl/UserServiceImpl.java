package payk96.rpg_shop.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import payk96.rpg_shop.dto.UserResponse;
import payk96.rpg_shop.keycloak.repository.UserEntityRepository;
import payk96.rpg_shop.service.UsersService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final UserEntityRepository repository;

    @Override
    public UserResponse getUserById(String userId) {
        return repository.findById(userId)
                .map(UserResponse::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }

}
