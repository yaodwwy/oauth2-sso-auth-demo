package demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (OauthUserDetails)类
 *
 * @author Adam
 * @since 2020-04-14 09:15:36
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = OauthUserDetailsEntity.Table)
public class OauthUserDetailsEntity implements Serializable {

    private static final long serialVersionUID = -84607456826020832L;

    public static final String Table = "OAUTH_USER_DETAILS";
    @Id
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String authorities;
    private Boolean locked;
    private Boolean enabled;
    private LocalDateTime expiry;
    private LocalDateTime credentials;

    public User convertToUser() {
        return new OauthUserDetailsConvert().convert(this);
    }

    private static class OauthUserDetailsConvert implements Converter<OauthUserDetailsEntity, User> {

        @Override
        public User convert(OauthUserDetailsEntity entity) {

            String authorities = entity.getAuthorities();
            String[] strings = StringUtils.split(authorities, ",");
            List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
            if (strings != null) {
                Arrays.stream(strings).forEach(role -> {
                    authorityList.add(new SimpleGrantedAuthority(role));
                });
            }
            return new User(entity.getUsername(), entity.getPassword(), authorityList);
        }
    }
}