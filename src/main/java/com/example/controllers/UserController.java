package com.example.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Services.UserService;
import com.example.domain.User;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "Userform";
	}
	
	 @RequestMapping("/list")
	 public String listUsers(Model model){
	    model.addAttribute("users", userService.findAllByOrderByDateOfBirthAsc());
	    
	    List<User> users =  userService.findAllByOrderByDateOfBirthAsc();
	    
	    String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		for (User u: users) {
			simpleDateFormat.format(u.getDateOfBirth());
		}
			   
	    return "Userlist";
	}
	
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult bindingResult) {
		
		User savedUser = userService.findByPps(user.getPps());
		
		String num = user.getMobilePhoneNumber();
		if (num.trim().length() > 0) {
			
			if (!num.startsWith("08")) {
				bindingResult.rejectValue("mobilePhoneNumber", "error.user", "Phone Number must start with '08'");
				return "Userform";
			}
		}

		if (getAge(user.getDateOfBirth()) <= 16){
			bindingResult.rejectValue("dateOfBirth", "error.user", "Must be over 16 years of age");
			return "Userform";
		}

		
		if (savedUser != null) {
			
			bindingResult.rejectValue("pps", "error.user", "PPS number already exists.");
			return "Userform";
		}
		
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		simpleDateFormat.format(user.getDateOfBirth());
		
		if(bindingResult.hasErrors()){
            return "Userform";
		}
	
		userService.save(user);
		
		return "Index";
	}
	
	
	public static int getAge(Date dateOfBirth) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();

        int yearDifference = today.get(Calendar.YEAR)
                - birth.get(Calendar.YEAR);

        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
            yearDifference--;
        } else {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)
                    && today.get(Calendar.DAY_OF_MONTH) < birth
                            .get(Calendar.DAY_OF_MONTH)) {
                yearDifference--;
            }

        }

        return yearDifference;
    }


}
