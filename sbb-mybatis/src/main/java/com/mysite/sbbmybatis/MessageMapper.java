package com.mysite.sbbmybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

// 매핑 xml에 기재 된 sql을 호출하기 위한 인터페이스
@Mapper
public interface MessageMapper {
	Message getMessageById(Integer id);
	void insertMessage(Message message);
	List<Message> getMessagesLimit10();
}
