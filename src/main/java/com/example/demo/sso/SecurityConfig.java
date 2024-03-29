package com.example.demo.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全配置
 *
 * Spring Security 安全配置。在安全配置类里我们配置了：
 *
 * 1. 配置请求URL的访问策略。
 *
 * 2. 自定义了同一认证登录页面URL。
 *
 * 3. 配置用户名密码信息从内存中创建并获取。
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/login")
                .antMatchers("/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()    // 自定义登录页面，这里配置了 loginPage, 就会通过 LoginController 的 login 接口加载登录页面
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置用户名密码，这里采用内存方式，生产环境需要从数据库获取
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("123"))
                .roles("USER");
        //也可以自定义,生产环境需要从数据库获取
//        auth.userDetailsService(userDetailsServiceImpl);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
