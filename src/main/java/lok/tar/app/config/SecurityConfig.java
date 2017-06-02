package lok.tar.app.config;

import lok.tar.app.service.security.MySQLUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Frank on 2017/5/27.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MySQLUserDetailsService userDetailsService;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http
//                .authorizeRequests()
//                .antMatchers("/noauth/**").permitAll()
//                .antMatchers("/users/create").permitAll()
//
//                // 为 Swagger2 增加规则 TODO 这种方式不是最优秀的，是否可以通过其他方式解决？
//                .antMatchers("/swagger-resources/**").permitAll()
//                .antMatchers("/webjars/**").permitAll()
//                .antMatchers("/swagger-ui.html").permitAll()
//                .antMatchers("/v2/api-docs").permitAll()
//
//                .anyRequest().authenticated()
//                .and().httpBasic()
//                .and().csrf().disable();
//        // @formatter:on
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    //@Override
    //@Bean
    //protected AuthenticationManager authenticationManager() throws Exception {
    //    return super.authenticationManager();
    //}
}
