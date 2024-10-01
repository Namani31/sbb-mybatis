// 폼이 submit 될 때 실행될 함수 정의함
document.getElementById('messageForm').addEventListener('submit', function(e) {
	// 페이지 새로고침을 막고 js로 이벤트 처리함
	e.preventDefault();
	
	const message = {
		// message_id 라는 input 요소의 값 가져와서 message 객체 생성
		// 만약 사용자가 Hello 르 입력했다면 message 객체는 {message: "Hello"} 가 됨
		message: document.getElementById('message_id').value,
	};
	
	// /message 경로로 POST 요청을 보내서 새로운 메시지를 서버에 저장
	fetch('/messages', {
		// 이 요청의 메서드는 POST
		method: 'POST',
		// 서버에 보내는 데이터가 JSON 형식
		headers: {
			'Content-Type': 'application/json',
		},
		// message 객체를 JSON 문자열로 변환 (stringify())
		// {message: "Hello"}는 JSON으로 변환되어 {"message": "Hello"} 가 되고 서버에 전송 됨
		body: JSON.stringify(message)
	})
	.then(response => {
		// 코드가 200번대인지 확인
		if (response.ok) {
			// 성공적이면 true 반환
			alert('메시지가 성공적으로 생성되었습니다.');
			// 폼을 리셋하여 사용자가 입력한 내용 지움
			document.getElementById('messageForm').reset();
		} else {
			// 실패하면 false 반환하며 알림창 표시
			alert('메시지 생성에 실패했습니다. Docker 또는 MySQL 환경을 확인해주세요.');
		}
	})
	// 예외 발생
	.catch(error => {
		console.error('Error: ' + error);
		alert('오류가 발생했습니다.');
	});
});