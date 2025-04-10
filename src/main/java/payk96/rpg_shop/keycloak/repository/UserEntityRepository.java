package payk96.rpg_shop.keycloak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payk96.rpg_shop.keycloak.model.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
