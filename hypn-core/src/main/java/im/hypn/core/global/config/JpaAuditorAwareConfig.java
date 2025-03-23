package im.hypn.core.global.config;

import im.hypn.core.global.UserInfo;
import im.hypn.core.global.util.Util;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaAuditorAwareConfig implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        UserInfo userInfo = Util.getUserInfo();
        if (null != userInfo) {
            return Optional.of(userInfo.getId());
        }
        return Optional.empty();
    }
}
