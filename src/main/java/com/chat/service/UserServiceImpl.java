package com.chat.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.Dao.UserDao;
import com.chat.entity.ChatUsers;


@Service
public class UserServiceImpl implements UserService {

	
	  @Autowired
	   private UserDao userDao;
	 
	  @Transactional
	public long save(ChatUsers chatUsers) {
		return userDao.save(chatUsers);
	}

	  @Transactional
	public ChatUsers get(long id) {
		return userDao.get(id);
	}
	
	 @Transactional
	public List<ChatUsers> list() {
		  return userDao.list();
	}

	  @Transactional
	public void update(long id, ChatUsers chatUsers) {
		userDao.update(id, chatUsers);
		
	}

	  @Transactional
	  public void delete(long id) {
		 userDao.delete(id);
		
	}


}
