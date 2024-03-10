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

        function success(response) {
            // alert("등록 완료");
            location.replace('/');
        }

        function fail(error) {
            console.error('등록 실패', error);
            alert("빈칸");
        }


        // httpRequest('POST', '/save', body, success, fail);
        // 요청 헤더에 CSRF 토큰을 포함합니다.
        httpRequest('POST', '/save', body, {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken  // 헤더에 CSRF 토큰을 추가
        }, success, fail);
    });
}


// 삭제

//삭제
const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        event.preventDefault();
        const promptId = document.getElementById('data-id');
        let id = document.getElementById('prompt-id').value;
        console.log('id 값 : ' + id);
        const csrfToken = document.querySelector('meta[name="_csrf"]').content; // Assuming the meta tag exists\

        function success(success) {
            // alert('삭제 성공했습니다.' + success);
            console.log('success ' + success);
            location.replace('/');
        }

        function fail(error) {
            // alert('삭제가 실패되었습니다.' + error);
            console.log('error ' + error)
            location.replace('/');
        }


        httpRequest('DELETE', `/delete/` + id, null, { // No body needed for DELETE
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }, success, fail);
    })
}

//수정
const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        event.preventDefault();
        console.log(' event.preventDefault();')

        let id = document.getElementById('prompt-id').value;
        console.log('value 되나.....?')
        console.log('MODIFY id 값 : ' + id);
        const csrfToken = document.querySelector('meta[name="_csrf"]').content; // Assuming the meta tag exists\

        const body = JSON.stringify({
            title: document.getElementById('title').value,
            subTitle: document.getElementById('subTitle').value,
            content: document.getElementById('content').value
        });

        function success(success) {
            alert('삭제 성공했습니다.' + success);
            // console.log('success ' + success);
            location.replace('/');
        }

        function fail(error) {
            alert('삭제가 실패되었습니다.' + error);
            // console.log('error ' + error)
            location.replace('/');
        }


        httpRequest('PUT', `/modify/` + id, body, { // No body needed for DELETE
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }, success, fail);
    })
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
                console.log('true')
                successCallback();
                return response.json(); // or .text() if the response is not in JSON format
            } else {
                console.log('false')
                failCallback();
                throw new Error('Something went wrong');
            }
        })
        .then(data => successCallback(data))
        .catch(error => failCallback(error));
}