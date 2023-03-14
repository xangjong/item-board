
/**
 * insertItem.js
 */

$(document).ready(function(){

    // 전체 수정
    $("#insertItemFrm").on('submit', function() {

        var itemName = $('#itemName').val();
        var itemQuantity = $('#itemQuantity').val();
        var itemPrice = $('#itemPrice').val();

        if (!validItemNameCheck(itemName)) {
            alert('유효하지 않은 비품명입니다. 한글, 영문, 숫자만 가능하며 1~20자 내로 입력해주세요.');
            return false;
        }

        if (!validItemQuantityCheck(itemQuantity)) {
            alert("수량은 숫자로 입력해주세요.");
            return false;
        }

         if (!validItemPriceCheck(itemPrice)) {
            alert("가격은 숫자만 입력해주세요.");
             return false;
        }

    }) // insertItemFrm


    // 비품명 유효성 검사
    function validItemNameCheck(itemName) {
        var reg = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]{1,20}$/g;

        if (false === reg.test(itemName)) {
            console.log('유효하지 않은 이름입니다. 한글, 영문, 숫자만 가능하며 1~20자 내로 입력해주세요.');
            return false;
        } else {
            console.log("비품명 정규식 통과");
            return true;
        }
    }

    // 비품 수량 유효성 검사
    function validItemQuantityCheck(itemQuantity) {

        var reg = /^[0-9]+$/;

        if (false === reg.test(itemQuantity)) {
            console.log('숫자만 입력해주세요.');
            return false;
        } else {
            console.log("비품 수량 정규식 통과");
            return true;
        }
    }


    // 비품 가격 유효성 검사
    function validItemPriceCheck(itemPrice) {

        var reg = /^[0-9]+$/;

        if (false === reg.test(itemPrice)) {
            console.log('비품숫자만 입력해주세요.');
            return false;
        } else {
            console.log("비품 숫자 정규식 통과");
            return true;
        }
    }


}); // document.ready