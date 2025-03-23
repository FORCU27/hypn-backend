package im.hypn.core.repository.user;

import im.hypn.core.model.user.Role;
import im.hypn.core.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, QUserRepository {
    Optional<User> findByRefreshToken(String token);

    Optional<User> findByEmailAndRole(String email, Role role);

    Optional<User> findByNickname(String nickname);
}
