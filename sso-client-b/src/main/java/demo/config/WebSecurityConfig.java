package demo.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Value("${oauth2-server}")
//    private String oauth2Server;
//
//    private static final String[] IGNORES = {
//            "/oauth/**", "/favicon.ico","/login"
//    };
//
//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/bootstrap/**");
//    }
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
        // http.authorizeRequests().mvcMatchers("/login").permitAll().anyRequest().permitAll();

//        http.logout().logoutSuccessUrl(oauth2Server + "/logout")
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
    }
}
