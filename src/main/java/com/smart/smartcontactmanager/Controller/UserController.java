package com.smart.smartcontactmanager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    
    // @Autowired
    // private UserRepository Urepo;


    

        @RequestMapping("/home")
        public String index(Model model){
            model.addAttribute("title", "this is attribue");
            return "home";
        }

        
}
