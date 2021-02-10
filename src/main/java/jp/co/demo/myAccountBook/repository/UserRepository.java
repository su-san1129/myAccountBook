package jp.co.demo.myAccountBook.repository;

import jp.co.demo.myAccountBook.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT * FROM users WHERE email = :email")
    Optional<User> findByEmail(@Param("email") final String email);
}
