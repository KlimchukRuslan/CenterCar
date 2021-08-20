package com.centercity.server.config;

import com.centercity.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/passenger").not().fullyAuthenticated()
                .antMatchers("/get_user_fin").permitAll()
                .antMatchers("/fin_edit").hasAnyRole("FIN","ADMIN","KURATOR")

                .antMatchers("/registration").hasRole("ADMIN")
                .antMatchers("/add_car").hasRole("ADMIN")
                .antMatchers("/car").hasAnyRole("ADMIN","KURATOR")
                .antMatchers("/data_user").hasAnyRole("ADMIN","KURATOR")
//                .antMatchers("/car").hasRole("KURATOR")
                .antMatchers("/reg_works/**").hasAnyRole("ADMIN","MEHANIK")
//                .antMatchers("/reg_works/**").hasRole("MEHANIK")
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasAnyRole("ADMIN","KURATOR")
//                .antMatchers("/admin/**").hasRole("KURATOR")
                .antMatchers("/update_user/**").hasRole("ADMIN")
                .antMatchers("/update_car/**").hasRole("ADMIN")
                .antMatchers("/edit_user/**").hasRole("ADMIN")
                .antMatchers("/edit_car/**").hasRole("ADMIN")
                //Доступ разрешен всем пользователей
//                .antMatchers("/", "/resources/**").permitAll()
                .antMatchers("/").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

}