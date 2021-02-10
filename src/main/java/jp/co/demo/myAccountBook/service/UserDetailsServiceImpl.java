package jp.co.demo.myAccountBook.service;

import jp.co.demo.myAccountBook.entity.LoginUser;
import jp.co.demo.myAccountBook.entity.User;
import jp.co.demo.myAccountBook.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("user not found."));
        return LoginUser.of(user, new ArrayList<>());
    }
}
