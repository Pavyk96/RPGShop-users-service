package payk96.rpg_shop.dto;

import lombok.Builder;
import payk96.rpg_shop.keycloak.model.UserEntity;

@Builder
public record UserResponse(
        String id,
        String username,
        String email,
        String firstName,
        String lastName
) {
    public static UserResponse fromEntity(UserEntity user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
