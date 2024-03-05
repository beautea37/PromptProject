document.querySelectorAll('.icon').forEach(function (icon) {
    icon.addEventListener('click', function () {
        // Toggle 'active' class
        icon.classList.toggle('active');
    });
});


document.querySelector('.btn-create').addEventListener('click', function() {
    // 여기에 클릭 시 실행할 로직을 추가합니다.
    // 예: 폼을 표시하거나, 작성 페이지로 이동합니다.
    // alert('작성하기 버튼이 클릭되었습니다!');
});
