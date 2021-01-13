package com.chat.Dao;

import java.util.List;

import com.chat.entity.ChatUsers;

public interface UserDao {

	 long save(ChatUsers chatUsers);

	   ChatUsers get(long id);

	   List<ChatUsers> list();

	   void update(long id, ChatUsers book);

	   void delete(long id);

}
