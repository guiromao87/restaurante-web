package br.com.guiromao.restaurante.config;

import br.com.guiromao.restaurante.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
    }

    // form(login,senha) -> Controller -> repository -> usuario -> session -> JSSESIONID







    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("321"));
    }
}
