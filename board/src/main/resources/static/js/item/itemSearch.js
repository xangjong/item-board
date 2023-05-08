function performSearch(page, type, keyword) {
    location.href = "boardList?page=" + encodeURIComponent(page) + "&type=" + encodeURIComponent(type) + "&keyword=" + encodeURIComponent(keyword);
}

$(document).ready(function () {
    $('#searchForm').on('submit', function (event) {
        event.preventDefault();

        let currentPage = 1;
        let searchType = $('#type').val();
        let searchKeyword = $('#keyword').val();

        performSearch(currentPage, searchType, searchKeyword);
    });
});