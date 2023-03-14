

$(document).ready(function () {

    let reg = null;

    $('#idCheckBtn').on('click', function () {
                if(!$('#memberId').val()){
                    alert("아이디를 입력해주세요.");
                    $('#memberId').val().focus();
                    return  false;
                } else {
                    if(!validMemberIdCheck($('#memberId').val())) {
                        alert('유효하지 않은 아이디입니다. 영문과 숫자를 조합하여 4~12자 내로 입력해주세요.');
                        return false;
                    } else {
                        $.ajax({
                            type: "POST",
                            url: "/memberIdCheck",
                            data: {
                                "memberId" : $('#memberId').val()
                            },
                            success: function (result) {
                                if (result === 1) {
                                    alert("이미 사용중인 ID 입니다.");
                                    return false;
                                } else if(result === 0) {
                                    alert("사용 가능한 ID 입니다.");
                                }
                            },
                            error: function () {
                                alert('오류!')
                            },
                        }); // ajax
                    } // else
                }
    }); // memberIdCheck


    $('#submitBtn').on('click', function () {

        if(!$('#memberId').val() || !$('#memberPw').val() || !$('#memberName').val() || !$('#memberPwCfm').val()) {

            if(!$('#memberId').val()){
                alert("아이디 항목을 입력해주세요.");
                $('#memberId').val().focus();
                return false;
            } else if(!validMemberIdCheck($('#memberId').val())) {
                alert('유효하지 않은 아이디입니다. 영문과 숫자를 조합하여 4~12자 내로 입력해주세요.');
                return false;
            }

            if (!$('#memberName').val()){
                alert("이름을 입력해주세요.");
                return false;
            } else if(!validMemberNameCheck($('#memberName').val())) {
                alert('이름은 한글과 영문으로만 입력해주세요.');
                return false;
            }

            if (!$('#memberPw').val() || !$('#memberPwCfm').val()){
                alert("비밀번호 항목을 입력해주세요.");
                return false;
            } else if( !validMemberPwCheck($('#memberPw').val()) ) {
                alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
                return false;
            } else if( $('#memberPw').val() != $('#memberPwCfm').val() ){
                alert("비밀번호가 일치하지 않습니다.")
                return false;
            }

            alert("비어있는 항목이 있습니다.");
            return false;

        } else {

            $.ajax({
                type   : "POST",
                url    : "/signUp",
                data   : {
                    "memberId"  : $('#memberId').val(),
                    "memberName": $('#memberName').val(),
                    "memberPw"  : $('#memberPw').val()
                },
                success: function (data) {
                    alert("회원 가입이 완료되었습니다.")
                    location.href = "/"
                },
                error  : function () {
                    alert('오류!')
                },
            }); // ajax
        } // else
    }); // memberIdCheck





    // 아이디 유효성 검사
    function validMemberIdCheck(memberId) {

        reg = /^[a-z]+[a-z0-9]{4,14}$/g;

        if (false === reg.test(memberId)) {
            console.log('유효하지 않은 아이디입니다. 영문과 숫자를 조합하여 4~12자 내로 입력해주세요.');
            return false;
        } else {
            console.log("통과");
            return true;
        }

    }


    // 이름 유효성 검사
    function validMemberNameCheck(memberName) {

         reg = /^[a-zA-Zㄱ-힣][a-zA-Zㄱ-힣 ]*$/;

        if (false === reg.test(memberName)) {
            console.log('이름은 한글과 영문으로만 입력해주세요.');
            return false;
        } else {
            console.log("통과");
            return true;
        }

    }

    function validMemberPwCheck(memberPw) {

        reg = /^(?=.*?[a-zA-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;

        if (false === reg.test(memberPw)) {
            console.log('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
            return false;
        } else {
            console.log("통과");
            return true;
        }

    }

}); // document.ready


