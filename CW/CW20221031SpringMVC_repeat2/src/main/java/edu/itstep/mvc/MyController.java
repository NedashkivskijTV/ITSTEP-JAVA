package edu.itstep.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askName")
    public String askName() {
        return "ask-name-view";
    }

    @RequestMapping("/showName")
    public String showName(@RequestParam("firstName") String firstName, Model model) {
        firstName = firstName.toUpperCase() + " !!!";
        model.addAttribute("fName", firstName);
        return "show-name-view";
    }

}
