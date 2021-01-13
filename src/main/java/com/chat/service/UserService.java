package com.chat.service;

import java.util.List;

import com.chat.entity.ChatUsers;

public interface UserService {


	   long save(ChatUsers chatUsers);
	   
	   ChatUsers get(long id);
	   
	   List<ChatUsers> list();
	   
	   void update(long id, ChatUsers chatUsers);
	   
	   void delete(long id);
}
