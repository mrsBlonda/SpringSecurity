package prohvataeva.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

         auth.inMemoryAuthentication()
                .withUser("Maksim").password("{noop}Maksim").roles("Sales")
                 .and()
                .withUser("Anna").password("{noop}Anna").roles("Economist")
                 .and()
                .withUser("Oksana").password("{noop}Oksana").roles("Sales", "Economist")
                 .and()
                .withUser("Alina").password("{noop}Alina").roles("HR");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/hello").permitAll()
                .and()
                .formLogin()
                .and()
                .authorizeRequests().antMatchers("/employees").hasAnyRole("Sales", "Economist", "HR")
                .and()
                .authorizeRequests().antMatchers("/employees/economist").hasRole("Economist")
                .and()
                .authorizeRequests().antMatchers("/employees/sales").hasRole("Sales")
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
