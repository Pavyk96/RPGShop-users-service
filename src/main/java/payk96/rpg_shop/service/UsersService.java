package payk96.rpg_shop.service;

import payk96.rpg_shop.dto.UserResponse;

public interface UsersService {
    UserResponse getUserById(String userId);
}
