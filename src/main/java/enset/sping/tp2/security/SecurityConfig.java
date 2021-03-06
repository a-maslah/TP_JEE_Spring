package enset.sping.tp2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
/*
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {



    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();
        System.out.println("*********************");
        System.out.println(passwordEncoder().encode("12345"));

auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN","USER");
auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
                .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
                .passwordEncoder(passwordEncoder)
                .rolePrefix("ROLE_");



    }
*/

    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
        //http.httpBasic();
      //http.formLogin().loginPage("/login");
     //   http.authorizeRequests().antMatchers("/admin/**","/save**/**","/delete**/**","/formPatient**/**").hasRole("ADMIN");
       // http.authorizeRequests().antMatchers("/patients**/**").hasRole("USER");
        //http.csrf();
       // http.authorizeRequests().antMatchers("/user/**","/login","/webjars/**").permitAll();
       // http.authorizeRequests().anyRequest().authenticated();
       // http.exceptionHandling().accessDeniedPage("/notAuthorized");
    //}
    //@Bean
    //public PasswordEncoder passwordEncoder(){
      //  return  new BCryptPasswordEncoder();
    //}
//}
