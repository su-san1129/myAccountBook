package jp.co.demo.myAccountBook.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class LoginUser extends org.springframework.security.core.userdetails.User {
    private User user;

    private LoginUser(final User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getEmail(), user.getPassword(), authorities);
        this.user = user;
    }

    public static LoginUser of(final User user, Collection<? extends GrantedAuthority> authorities) {
        return new LoginUser(user, authorities);
    }
}
