package payk96.rpg_shop.keycloak.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import payk96.rpg_shop.keycloak.model.UserRoleMapping;
import payk96.rpg_shop.keycloak.model.UserRoleMappingId;

import java.util.List;

@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, UserRoleMappingId> {
    List<UserRoleMapping> findByRoleId(String roleId);
}
