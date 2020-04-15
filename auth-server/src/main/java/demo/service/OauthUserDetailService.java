package demo.service;

import demo.domain.OauthUserDetailsEntity;
import demo.repo.OauthUserDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OauthUserDetailService implements UserDetailsService {

    private final OauthUserDetailRepository oauthUserDetailRepository;

    public OauthUserDetailService(OauthUserDetailRepository oauthUserDetailRepository) {
        this.oauthUserDetailRepository = oauthUserDetailRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OauthUserDetailsEntity o = oauthUserDetailRepository.findByUsername(username);
        User user;
        if (null != o) {
            user = o.convertToUser();
        } else {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username);
        }
        return user;
    }
}
