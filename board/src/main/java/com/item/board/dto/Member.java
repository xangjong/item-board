package com.item.board.dto;


import com.item.board.state.ROLE;
import com.item.board.state.UserState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Member {

    private String memberId;
    private String memberPw;
    private String memberName;
//    private String memberEmail;
//    private String memberNumber;
//    private UserState OFFICE;
//    private ROLE USER;
}
