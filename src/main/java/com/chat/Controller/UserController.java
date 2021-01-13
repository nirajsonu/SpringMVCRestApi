package com.chat.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.entity.ChatUsers;
import com.chat.service.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping("/alluser")
	public ResponseEntity<List<ChatUsers>> list()
	{
		List<ChatUsers> list=userService.list();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/alluser")
	public ResponseEntity<?> save(@RequestBody ChatUsers chatUsers )
	{
		long id=userService.save(chatUsers);
		return ResponseEntity.ok().body("User created with id:"+id);
	}
	
	@GetMapping("/alluser/{id}")
	public ResponseEntity<ChatUsers> get(@PathVariable("id") Long id)
	{
		ChatUsers chatUsers=userService.get(id);
		return ResponseEntity.ok().body(chatUsers);
	}
	
	 @PutMapping("/alluser/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody ChatUsers chatUsers) {
	      userService.update(id, chatUsers);
	      return ResponseEntity.ok().body("user has been updated successfully.");
	   }

	   
	   @DeleteMapping("/alluser/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      userService.delete(id);
	      return ResponseEntity.ok().body("user has been deleted successfully.");
	
	   }
} 
