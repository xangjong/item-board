/**
 * itemSearch.js
 */

$(document).on('click', '#btnSearch', function(e){

    e.preventDefault();

    let url = "${pageContext.request.contextPath}/boardList";

    url = url + "?type=" + $('#type').val();

    url = url + "&keyword=" + $('#keyword').val();

    location.href = url;

    console.log(url);

});

