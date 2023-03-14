package com.spring.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Data
public class MemberDTO implements UserDetails {

    @NotBlank(message = "회원 번호는 필수 입력사항 입니다.")
    private int memberNo;
    @NotBlank(message = " 회원 아이디는 필수 입력사항 입니다.")
    private String memberId;
    @NotBlank(message = "비밀 번호는 필수 입력사항 입니다.")
    private String memberPw;
    @NotBlank(message = "이름은 필수 입력사항 입니다.")
    private String memberName;
    private String memberState;
    private String memberRole;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate regDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate modDateTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.memberRole));
    }

    // 시큐리티의 userName
    // -> 따라서 얘는 인증할 때 id를 봄
    @Override
    public String getUsername() {
        return this.memberId;
    }

    @Override
    public String getPassword() {
        return this.memberPw;
    }

    // VO의 UserName
    public String getUserName() {
        return this.memberName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
