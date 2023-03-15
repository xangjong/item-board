/**
 * itemSearch.js
 */


$(document).ready(function(){

    $('#itemSearchFrm').on('submit', function(){

        let formData = $(this).serialize();

        $.ajax({
            type:"post",
            url:"/itemSearch",
            data:formData,
            success: function(data){ // 컨트롤러에서 반환한 itemList result가 받음
                // 반환된 결과를 <div>으로 삽입
                // alert(result);
            },
            error: function(){
                // 오류있을 경우 수행되는 함수
                alert("전송 실패");
            }
        }); // ajax 끝
    }); // submit 끝
});  // ready 끝