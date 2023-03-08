package com.item.board.model;


import com.item.board.state.Right;
import com.item.board.state.UserState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberVO {

    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private String memberNumber;
    private UserState OFFICE;
    private Right USER;
}
