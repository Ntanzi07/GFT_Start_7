package dio.spring.security.repository;

import dio.spring.security.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query("SELECT u FROM UserModel u JOIN FETCH u.roles WHERE u.username = :username")
    UserModel findByUsername(@Param("username") String username);
}
