package com.chat.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chat.entity.ChatUsers;

@Repository
public class UserDaoImp implements UserDao{

	  @Autowired
	   private SessionFactory sessionFactory;
	  
	  
	public long save(ChatUsers chatUsers) {
		sessionFactory.getCurrentSession().save(chatUsers);
	      return chatUsers.getId();
	}

	public ChatUsers get(long id) {
		 return sessionFactory.getCurrentSession().get(ChatUsers.class, id);
	}

	public List<ChatUsers> list() {
		 List<ChatUsers> list = sessionFactory.getCurrentSession().createQuery("from chatuser").list();
	      return list;
	}

	public void update(long id, ChatUsers chatUsers) {
		  Session session = sessionFactory.getCurrentSession();
	      ChatUsers chatUsers2 = session.byId(ChatUsers.class).load(id);
	      chatUsers2.setCity(chatUsers.getCity());
	      chatUsers2.setUsername(chatUsers.getUsername());
	      chatUsers2.setEmail(chatUsers.getEmail());
	      chatUsers2.setPassword(chatUsers.getPassword());
	      session.flush();
	}

	public void delete(long id) {
	ChatUsers chatUsers = sessionFactory.getCurrentSession().byId(ChatUsers.class).load(id);
	      sessionFactory.getCurrentSession().delete(chatUsers);
		
	}
	

	



}
