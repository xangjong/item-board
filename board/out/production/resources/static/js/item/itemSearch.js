/**
 * itemSearch.js
 */

$/*(document).ready(function(){

    $('#itemSearchFrm').on('submit', function(){

        let formData = $(this).serialize();

        console.log("formData : " + formData);

        $.ajax({
            type:"POST",
            url:"/itemSearch",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            dataType:'html',
            data:formData,
            success: function(data){ // 컨트롤러에서 반환한 itemList result가 받음
                // 반환된 결과를 <div>으로 삽입
                console.log("result : " + data);
            },
            error: function(){
                // 오류있을 경우 수행되는 함수
                console.log("fail data : " + this.data);
                alert("전송 실패");
            }
        }); // ajax 끝
    }); // submit 끝
});  // ready 끝*/



$(document).on('click', '#btnSearch', function(e){

    e.preventDefault();

    let url = "${pageContext.request.contextPath}/boardList";

    url = url + "?type=" + $('#type').val();

    url = url + "&keyword=" + $('#keyword').val();

    location.href = url;

    console.log(url);

});

