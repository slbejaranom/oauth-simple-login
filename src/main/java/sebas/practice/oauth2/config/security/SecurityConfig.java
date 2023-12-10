package sebas.practice.oauth2.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests((authorize) -> authorize
        .requestMatchers("/").permitAll()
        .requestMatchers("/secured").authenticated())
        .oauth2Login(Customizer.withDefaults());
    return httpSecurity.build();
  }
}
