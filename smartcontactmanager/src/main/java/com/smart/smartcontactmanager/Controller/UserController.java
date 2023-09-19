package com.smart.smartcontactmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smartcontactmanager.Entities.User;
import com.smart.smartcontactmanager.Repository.UserRepository;


@Controller
public class UserController {
    
    @Autowired
    private UserRepository Urepo;
    
        @RequestMapping("/")
        public String index(Model model){
            model.addAttribute("title", "Title - Smart Contact Manager");
            return "home";
        }

        @RequestMapping("/about")
        public String about(Model model){
            model.addAttribute("title", "About - Smart Contact Manager");
            return "about";
        } 


        @RequestMapping("/signup")
        public String signup(Model model){
            model.addAttribute("title", "Resister - Smart Contact Manager");
            // model.addAttribute("user", new User());
            return "signup";
        } 

        @PostMapping("/doResister")
        public String resisterUser(@ModelAttribute("user") User user,@RequestParam(value = "agreement" , defaultValue = "false") boolean agreement,Model model){


            if (!agreement) {
                System.out.println("Youre are not agreed to term and condition");
            }

            user.setRole("ROLE_USER");
            user.setEnable(true);
            System.out.println("Agreement "+ agreement);
            System.out.println("User "+ user);

            
            User result = Urepo.save(user);

            model.addAttribute("user", result);
            return "signup";
        }
}
