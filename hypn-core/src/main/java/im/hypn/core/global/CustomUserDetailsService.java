package im.hypn.core.global;

import im.hypn.core.global.exception.ApiException;
import im.hypn.core.global.exception.ErrorCode;
import im.hypn.core.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService {
    private final UserRepository userRepository;

    public UserDetails loadUserByUserId(long id) {
        UserInfo user = userRepository.findById(id)
                .map(UserInfo::new)
                .orElseThrow(() -> new ApiException(ErrorCode.ACCESS_DENIED_EXCEPTION));
        initAuthority(user);
        return user;
    }

    private void initAuthority(UserInfo userInfo) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userInfo.getRole().getValue()));
        userInfo.setAuthorities(grantedAuthorities);
    }
}
