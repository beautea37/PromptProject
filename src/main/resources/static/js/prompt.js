const createButton = document.getElementById('create-btn');

// 글 등록
if (createButton) {
    createButton.addEventListener('click', event => {
        // const body = JSON.stringify({
        //     title: document.getElementById('title').value,
        //     subTitle: document.getElementById('subTitle').value,
        //     content: document.getElementById('content').value
        alert("Click Test");
    });


    // httpRequest('POST', '/save', body, success, fail);
}



function success(response) {
    alert("등록 완료");
    location.replace('/');
}

function fail(error) {
    console.error('등록 실패', error);
    alert("등록 실패");
}




//삭제
const deleteButton = document.getElementById('delete-btn');

if(deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('prompt.id').value;

        function success() {
            alert('삭제가 완료되었습니다.');
            location.replace('/');
        }

        function fail() {
            alert('삭제 실패했습니다.');
            location.replace('/');
        }

        httpRequest('DELETE', `/delete/${id}`, null, success, fail)
    })
}













function httpRequest(method, url, body, successCallback, failCallback) {
    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json',
        },
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
