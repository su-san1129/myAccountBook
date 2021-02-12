package jp.co.demo.myAccountBook.service;

import jp.co.demo.myAccountBook.entity.User;
import jp.co.demo.myAccountBook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void create(final String name, final String password, final String email) {
        final User user = User.builder().name(name).password(passwordEncoder.encode(password)).email(email).build();
        userRepository.save(user);
    }
}
