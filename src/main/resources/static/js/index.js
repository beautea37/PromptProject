document.querySelectorAll('.icon').forEach(function (icon) {
    icon.addEventListener('click', function () {
        // Toggle 'active' class
        icon.classList.toggle('active');
    });
});


// document.querySelector('.btn-create').addEventListener('click', function() {
//     // 여기에 클릭 시 실행할 로직을 추가합니다.
//     // 예: 폼을 표시하거나, 작성 페이지로 이동합니다.
//     // alert('작성하기 버튼이 클릭되었습니다!');
// });

const createButton = document.getElementById('create-btn');

// 글 등록
if (createButton) {
    createButton.addEventListener('click', event => {
        event.preventDefault();

        const csrfToken = document.getElementById('csrf').value;

        const body = JSON.stringify({
            title: document.getElementById('title').value,
            subTitle: document.getElementById('subTitle').value,
            content: document.getElementById('content').value
        });


        // httpRequest('POST', '/save', body, success, fail);
        // 요청 헤더에 CSRF 토큰을 포함합니다.
        httpRequest('POST', '/save', body, {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken  // 헤더에 CSRF 토큰을 추가
        }, success, fail);
    });
}


function success(response) {
    alert("등록 완료");
    location.replace('/');
}

function fail(error) {
    console.error('등록 실패', error);
    alert("등록 실패");
}

// 요청 헤더를 매개변수로 받도록 수정합니다.
function httpRequest(method, url, body, headers, successCallback, failCallback) {
    fetch(url, {
        method: method,
        headers: headers,
        body: body,
    })
        .then(response => {
            if (response.ok) {
                return response.json(); // or .text() if the response is not in JSON format
            } else {
                throw new Error('Something went wrong');
            }
        })
        .then(data => successCallback(data))
        .catch(error => failCallback(error));
}