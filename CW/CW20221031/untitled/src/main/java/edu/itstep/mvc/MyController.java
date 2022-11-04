package edu.itstep.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView(){
        return "first-view";
    }

    @RequestMapping("/askInfo")
    public String askName(Model model){
        model.addAttribute("user", new User("Ivan", "Ivanenko", 18));
        return "ask-info-view";
    }

    @RequestMapping("/showInfo")
    public String showName(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
//            System.err.println("ERROR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return "ask-info-view";
        }
        return "show-info-view";
    }

//    @RequestMapping("/showName")
//    public String showName(){
//        return "show-name-view";
//    }

//    @RequestMapping("/showName")
//    public String showName(HttpServletRequest request, Model model){
//        String firstName = request.getParameter("firstName");
//        firstName = firstName.toUpperCase() + "!!!";
//        model.addAttribute("fName", firstName);
//        return "show-name-view";
//    }

//    @RequestMapping("/showName")
//    public String showName(@RequestParam("firstName") String firstName, Model model){
//        firstName = firstName.toUpperCase() + "!!!";
//        model.addAttribute("fName", firstName);
//        return "show-name-view";
//    }


}
