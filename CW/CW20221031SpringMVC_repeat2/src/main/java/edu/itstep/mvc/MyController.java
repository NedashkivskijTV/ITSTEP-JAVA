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
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askName")
    public String askName() {
        return "ask-name-view";
    }

    @RequestMapping("/showName")
    public String showName(@RequestParam("firstName") String firstName, Model model) {
        if (firstName.trim().length() == 0){
            return "attention-view";
        }
        firstName = firstName.toUpperCase() + " !!!";
        model.addAttribute("fName", firstName);
        return "show-name-view";
    }

    //-------------------------------- form:form -----------------------------------------------------------------------
    @RequestMapping("/askInfo")
    public String askInfo(Model model) { // параметр model - для підключення моделі потрібного типу
        //model.addAttribute("user", new User()); // підключення у якості моделі класу User - зберігатиме усі дані при передачі інф між формою та іншими представленнями

        // створення через оператор new в параметрах методу додавання моделі
//        model.addAttribute("user", new User("Ivan", "Ivanenko", 18)); // приклад - таким чином можна передати тестові або дані за замовчуванням ...

        // створення екземпляра User окремо та його наповнення з БД - передача даних до представлення з використанням в моделі класу User при наявності відповідного поля-колекції (надмірність (избыточность))
        User user = new User("Petro", "Petrenko", 25);
//        user.setCities(DataBase.getCities()); // наповнення поля-колекції даними з БД
//        user.setGenders(DataBase.getGenders());
//        user.setLanguagesList(DataBase.getLanguages());
        model.addAttribute("user", user); // приклад - передача

        // додавання до моделі списку міст для вибору з випадаючого списку
        model.addAttribute("citiesList", DataBase.getCities());

        // додавання до моделі колекції джля відображення радіобатонів та вибору гендера
        model.addAttribute("gendersList", DataBase.getGenders());

        // додавання до моделі колекції для відображення чекбоксів та вибору мови (множинний вибір)
        model.addAttribute("languagesList", DataBase.getLanguages());

        return "ask-info-view";
    }

    @RequestMapping("/showInfo")
    //public String showInfo(@ModelAttribute("userWasSent")User user) { // параметр User - для підключення моделі до представлень, що модифікують/відображають дані
    public String showInfo(@Valid @ModelAttribute("user")User user, BindingResult bindingResult, Model model) {
        // @Valid - команда на валідацію даних, отриманих у моделі;
        // @ModelAttribute("user")User user - після натиснення кнопки SEND під формою на в’юшці ask-info-view, SpringMVC візьме усі відправлені дані (в даному разі пересилаються GET-запитом в URL) та упакує у вказаний у параметрах методу контроллера об’єкт User user (для отримання доступу до даного об’єкта використовуватиметься КЛЮЧ, наведений у параметрах анотації @ModelAttribute("user"))
        // параметр User - для підключення моделі до представлень, що модифікують/відображають дані;
        // BindingResult bindingResult - для здійснення валідації - для аналізу отриманих з форми даних
        // Model model - для підключення моделі стандартного типу - для передачі у форму динамічних колекцій, що використовуються для формування селектів, радіобатонів, чекбоксів
        if(bindingResult.hasErrors()){
            //System.err.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"); // маркер спрацювання блоку
            // додавання до моделі колекцій для відображення селектів, радіобатонів, чекбоксів
            model.addAttribute("citiesList", DataBase.getCities());
            model.addAttribute("gendersList", DataBase.getGenders());
            model.addAttribute("languagesList", DataBase.getLanguages());
            return "ask-info-view";
        }
        return "show-info-view";
    }

}
