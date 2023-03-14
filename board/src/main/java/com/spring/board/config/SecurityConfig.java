package com.spring.board.config;


import com.spring.board.service.MemberService;
import com.spring.board.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberServiceImpl memberService;

    private final AuthenticationFailureHandler customFailureHandler;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests()
            .antMatchers( "/login", "/singUp", "/accessDenied", "/resources/**").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
            // USER, ADMIN 접근 허용
            .antMatchers("/userAccess").hasRole("USER")
            .antMatchers("/userAccess").hasRole("ADMIN")
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/loginProcess") // 로그인 form의  action과 일치시켜주어야 함.
                        .defaultSuccessUrl("/") // 로그인 성공 시 이동할 경로.
                        .failureHandler(customFailureHandler) // 로그인 실패 핸들러
                .and()
                    .logout()
                    .permitAll()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDenied_page") // 권한이 없는 대상이 접속을시도했을 때
                .and()
                .csrf().disable();

    }

    /**
     * 로그인 인증 처리 메소드
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(new BCryptPasswordEncoder());
    }


}
