package com.taskpro.Taskpro.Service.impl;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import com.taskpro.Taskpro.Dto.LoginDto;
import com.taskpro.Taskpro.Dto.UserDto;
import com.taskpro.Taskpro.Entity.User;
import com.taskpro.Taskpro.Repo.UserRepo;
import com.taskpro.Taskpro.response.LoginResponse;
import com.taskpro.Taskpro.Service.UserService;

@Service

public class UserImpl implements UserService {
	
	
	@Autowired 
	private UserRepo userRepo;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser(UserDto userDto) {
	    try {
	        // Créer une instance User
	        User user = new User(
	                userDto.getId(),
	                userDto.getLastName(),
	                userDto.getFirstName(),
	                userDto.getEmail(),
	                this.passwordEncoder.encode(userDto.getPassword())
	        );

	        // Enregistrer l'utilisateur dans la base de données
	        userRepo.save(user);

	        // Retourner un message de succès avec l'ID de l'utilisateur nouvellement créé
	        return "Utilisateur ajouté avec succès. ID: " + user.getEmail();
	    } catch (Exception e) {
	        // En cas d'erreur, retourner un message d'erreur
	        return "Erreur lors de l'ajout de l'utilisateur : " + e.getMessage();
	    }
	}
	@Override
	public LoginResponse loginUser(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);

            if (isPwdRight) {
            	java.util.Optional<User> user = userRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);

                if (user.isPresent()) {
                    return new LoginResponse("login succes", true);
                } else {
                    return new LoginResponse("Login failed", false);
                }
            } else {
                return new LoginResponse("Password not match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }
	

}
