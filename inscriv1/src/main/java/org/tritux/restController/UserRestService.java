package org.tritux.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tritux.dao.UserRepo;
import org.tritux.entites.User;

@CrossOrigin()
@RestController
public class UserRestService {

	@Autowired
	UserRepo userRepo;

	// authentificatino
	@RequestMapping(value = "/auth1", method = RequestMethod.POST)
	public User loginn(@RequestBody User ob) {

		User var = userRepo.findBylogin(ob.getLogin());
		if (var.getPassword().equals(ob.getPassword())) {
			return var;
		} else {
			return ob;
		}
	}

	// verifier si login existe
	@RequestMapping(value = "/verifLog/{log}", method = RequestMethod.GET)
	public String verif(@PathVariable String log) {

		User var = userRepo.findBylogin(log);
		if (var == null) {
			return "{\"exist\": \"" + "false" + "\"}" ;
		} else {
			return "{\"exist\": \"" + "true" + "\"}" ;
		}
	}

	@RequestMapping(value = "/listUser")
	public List<User> loginn() {
		return userRepo.findAll();
	}
}
