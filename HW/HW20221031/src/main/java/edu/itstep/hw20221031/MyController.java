package edu.itstep.hw20221031;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
public class MyController {

    @RequestMapping("/")
    public String showFirstView(){
        return "first-view";
    }

    @RequestMapping("/showForm")
    public String showForm(){
        return "form-view";
    }

    @RequestMapping("/showUserInfo")
    public String showUserInfo(@RequestParam("surname") String surname,
                               @RequestParam("name") String name,
                               @RequestParam("birthday") String birthday,
                               Model model){
        surname = surname.toUpperCase();
        model.addAttribute("lName", surname);

        name = name.toUpperCase();
        model.addAttribute("fName", name);

        String[] dateWords = birthday.split("-");
        String userBirthday = dateWords[2] + "." + dateWords[1] + "." + dateWords[0];
        model.addAttribute("userBd", userBirthday);

        return "user-info-view";
    }

}
