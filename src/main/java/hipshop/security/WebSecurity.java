package hipshop.security;

import static hipshop.security.Constants.LOGIN_URL;
import static hipshop.security.Constants.HEADER_AUTHORIZACION_KEY;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration 
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public WebSecurity(@Lazy UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Bean //Cifra las contraseñas. 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*
		 * 1. Se desactiva el uso de cookies. Las cookies son utilizadas cuando el servidor es monolítico (back y front juntos).
		 * 2. Se activa la configuración CORS con los valores por defecto. CORS se activa para configurar de qué direcciones vamos a recibir peticiones http y para que sean del mismo servidor. Es medida de protección que impide que otras personas hagan solicitudes de manera externa.
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		httpSecurity
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()// esta seccion hace q no genere cookies las desactiva
			.cors().and()  // configuracion el cors por defecto
			.csrf().disable()  // desactivar el csrf xq no hicimos el frontend en java 
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.POST, "/user").permitAll().and()
			.authorizeRequests().antMatchers(HttpMethod.GET, "/user").permitAll()
			//.authorizeRequests().antMatchers(HttpMethod.POST, "/users/").hasAuthority("ADMIN")
			.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Se define la clase que recupera los usuarios y el algoritmo para procesar las passwords
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
				.exposedHeaders(HEADER_AUTHORIZACION_KEY);
			}
		};
	}
}
