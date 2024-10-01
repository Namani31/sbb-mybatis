package com.mysite.sbbmybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
	@GetMapping("/message/{id}")
	@ResponseBody
	// PathVariable을 이용해 URL 경로에 변수를 넣어 사용함
	public Integer message(@PathVariable("id") Integer id) {
		return id;
	}
}
