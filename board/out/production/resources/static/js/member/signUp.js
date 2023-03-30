
$(document).ready(function () {

    // 변수 초기화
    let reg = null; // 정규식
    let idx = false; // 아이디 중복 체크

    let memberId = null;
    let memberPw = null;
    let memberName = null;
    let memberPwCfm = null;


    // 아이디 중복 확인 버튼 클릭 시
    $('#idCheckBtn').on('click', function () {
        memberId = $('#memberId').val();
        if(!memberId){
            alert("아이디를 입력해주세요.");
            return false;
                } else {
                    if(!validMemberId(memberId) ) {
                        alert('유효하지 않은 아이디입니다. 영문과 숫자를 조합하여 4~12자 내로 입력해주세요.');
                        return false;
                    } else {
                        $.ajax({
                            type: "POST",
                            url: "/memberIdCheck",
                            data: {
                                "memberId" : memberId
                            },
                            success: function (result) {
                                if (result === 1) {
                                    alert("이미 사용중인 ID 입니다.");
                                    idx = false;
                                    return false;
                                } else if(result === 0) {
                                    alert("사용 가능한 ID 입니다.");
                                    idx = true;
                                }
                            },
                            error: function () {
                                alert('오류!')
                            },
                        }); // ajax
                    } // else
                }
    }); // memberIdCheck


    // 가입 완료 버튼 클릭 시
    $('#submitBtn').on('click', function () {

        memberId = $('#memberId').val();
        memberName = $('#memberName').val();
        memberPw = $('#memberPw').val();
        memberPwCfm = $('#memberPwCfm').val();

        if (!memberId || !memberName || !memberPw || !memberPwCfm) {
            alert("비어있는 항목이 있습니다. 항목을 입력해주세요.");
            return;
        } else if (!validMemberId(memberId) || !validMemberName(memberName) || !validMemberPw(memberPw)) {
            return;
        } else if (memberPw != memberPwCfm) {
            alert("비밀번호가 일치하지 않습니다.");
            return;
        }

        if (idx == false) {
            alert("아이디 중복 체크를 해주세요.")
            return;
        } else {
            $('#signFrm').submit(); // 데이터 전송
        }
    });

    // 아이디 유효성 검사
    function validMemberId(memberId) {

        reg = /^[a-z]+[a-z0-9]{4,14}$/g;

        if (false === reg.test(memberId)) {
            alert('유효하지 않은 아이디입니다. 영문과 숫자를 조합하여 4~12자 내로 입력해주세요.');
            return false;
        } else {
            return true;
        }

    }

    // 이름 유효성 검사
    function validMemberName(memberName) {

         reg = /^[a-zA-Zㄱ-힣][a-zA-Zㄱ-힣 ]*$/;

        if (false === reg.test(memberName)) {
            alert('이름은 한글과 영문으로만 입력해주세요.');
            return false;
        } else {
            return true;
        }

    }

    // 비밀번호 유효성 검사
    function validMemberPw(memberPw) {

    reg = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;

            if (false === reg.test(memberPw)) {
            alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
            return false;
        } else {
            return true;
        }
    }

}); // document.ready