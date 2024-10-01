package com.mysite.sbbmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesageService {
	@Autowired
	private MessageMapper messageMapper;
	
	// 데이터베이스에서 값을 가져오기
	public Message getMessage(Integer id) {
		return messageMapper.getMessageById(id);
	}
}
