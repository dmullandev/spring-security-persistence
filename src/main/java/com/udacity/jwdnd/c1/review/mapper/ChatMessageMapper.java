package com.udacity.jwdnd.c1.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.c1.review.model.ChatMessage;

@Mapper
public interface ChatMessageMapper {

	@Select("SELECT * FROM MESSAGES")
	List<ChatMessage> getAllMessages();

	@Insert("INSERT INTO MESSAGES (username, message)" + "VALUES(#{username}, #{message})")
	@Options(useGeneratedKeys = true, keyProperty = "messageId")
	int addMessage(ChatMessage chatMessage);

}
