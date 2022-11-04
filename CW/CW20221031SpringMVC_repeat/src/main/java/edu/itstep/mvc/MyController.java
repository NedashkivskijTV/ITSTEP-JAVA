package edu.itstep.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView(){
        return "first-view";
    }

    @RequestMapping("/askName")
    public String askName(){
        return "ask-name-view";
    }


//    @RequestMapping("/showName")
//    public String showName(){
//        return "show-name-view";
//    }


//    @RequestMapping("/showName")
//    public String showName(HttpServletRequest request, Model model){
//        String firstName = request.getParameter("firstName");
//        firstName = firstName.toUpperCase() + " !!!";
//        model.addAttribute("fName", firstName);
//        return "show-name-view";
//    }

    @RequestMapping("/showName")
    public String showName(@RequestParam("firstName") String firstName, Model model){
        if(firstName.trim().length() == 0){
            return "error-view";
        }
        firstName = firstName.toUpperCase() + " !!!";
        model.addAttribute("fName", firstName);
        return "show-name-view";
    }


}
