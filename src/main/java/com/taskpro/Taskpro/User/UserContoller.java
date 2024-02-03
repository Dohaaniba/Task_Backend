package com.taskpro.Taskpro.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.taskpro.Taskpro.Dto.LoginDto;
import com.taskpro.Taskpro.Dto.UserDto;
import com.taskpro.Taskpro.Service.UserService;
import com.taskpro.Taskpro.response.LoginResponse;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")


public class UserContoller {
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/save")
	public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
		
		 try {
		        String id = userService.addUser(userDto);
		        return ResponseEntity.ok("Utilisateur ajouté avec succès. ID: " + id);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
		    }
	}
	
	
	@PostMapping(path="/login")
	public ResponseEntity<?> LoginUser (@RequestBody LoginDto loginDto){
		LoginResponse loginResponse = userService.loginUser(loginDto);
		return ResponseEntity.ok(loginResponse);
	}

}
