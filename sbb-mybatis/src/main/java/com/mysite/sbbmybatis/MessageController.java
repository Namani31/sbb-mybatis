package com.mysite.sbbmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 웹 요청을 처리하는 역할임을 알리는 애노테이션
@Controller
// /message url로부터 요청을 받으면 MessageController 에서 처리함
@RequestMapping("/message")
public class MessageController {
	// Autowired: MessageService의 인스턴스를 직접 생성하지 않고 Spring이 자동으로 주입함
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/message/{id}")
	// 메서드가 반환하는 값이 JSON 또는 XML 같은 형식으로 HTTP Response Body에 직접 쓰임
	@ResponseBody
	// PathVariable을 이용해 URL 경로에서 id 값을 추출해 해당 메서드이 파라미터로 넣음
	// 추출된 id 값을 사용해 messageService의 getMessage(id) 호출, id에 해당하는 메시지를 가져와서 반환함
	public Message GetMessage(@PathVariable("id") Integer id) {
		// Integer id = 1;
		return messageService.getMessage(id);
	}
}
