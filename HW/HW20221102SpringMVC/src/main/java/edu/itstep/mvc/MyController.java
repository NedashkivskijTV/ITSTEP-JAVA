package edu.itstep.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class MyController {
    @RequestMapping("/")
    public String showFirstView(){
        return "first-view";
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        //model.addAttribute("user", new User());
        User user = new User("Ivan", "Ivanenko", new GregorianCalendar(1990, Calendar.MARCH, 7));
        model.addAttribute("user", user);

        model.addAttribute("genderList", DataBase.getGenders());
        model.addAttribute("languagesList", DataBase.getLanguages());
        model.addAttribute("infoSources", DataBase.getInfoSources());

        return "form-view";
    }

    @RequestMapping("/showInfo")
    public String showInfoFromForm(@Valid @ModelAttribute("user")User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("genderList", DataBase.getGenders());
            model.addAttribute("languagesList", DataBase.getLanguages());
            model.addAttribute("infoSources", DataBase.getInfoSources());
            return "form-view";
        }
        return "info-view";
    }
}
