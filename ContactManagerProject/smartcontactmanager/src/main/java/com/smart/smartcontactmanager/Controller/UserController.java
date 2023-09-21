package com.smart.smartcontactmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.smartcontactmanager.Entities.User;
import com.smart.smartcontactmanager.Helper.Message;
import com.smart.smartcontactmanager.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


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
        public String resisterUser(@Valid @ModelAttribute("user") User user,@RequestParam(value = "agreement" , defaultValue = "false") boolean agreement,Model model,HttpSession session,BindingResult result1){

        try {
            if (!agreement) {
                System.out.println("Youre are not agreed to term and condition");
                throw new Exception("Youre are not agreed to term and condition");
            }

            if (result1.hasErrors()) {
                System.out.println("Error " + result1.toString());
                model.addAttribute("user",user);
                return "signup";
            }

            user.setRole("ROLE_USER");
            user.setEnable(true);
            user.setImageUrl("default.png");
            System.out.println("Agreement "+ agreement);
            System.out.println("User "+ user);

            
            Urepo.save(user);
            model.addAttribute("user", new User());


            session.setAttribute("message", new Message("Successfully Resistered!!", "alert-success"));
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong!!" + e.getMessage(), "alert-danger"));
            return "signup";
        }
            return "signup";
        }
}
