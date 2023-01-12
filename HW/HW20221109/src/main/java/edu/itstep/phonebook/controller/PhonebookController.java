package edu.itstep.phonebook.controller;

import edu.itstep.phonebook.entity.Contact;
import edu.itstep.phonebook.entity.Phone;
import edu.itstep.phonebook.service.ContactService;
import edu.itstep.phonebook.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // спеціальний контроллер, використовуваний у веб-сервисах RESTFul, и еквівалентний @Controller + @ResponseBody
public class PhonebookController {

    @Autowired // на сетер/конструктор/поле, вказує на створення залежності (зависимости) за допомогою даного сетера/конструктора/поля
    public PhoneService phoneService;

    @Autowired
    public ContactService contactService;

    /**
     * Отримання усіх об'єктів з таблиці phones
     * @return
     */
    @GetMapping("/phones") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public List<Phone> getAllPhones() {
        List<Phone> phones = phoneService.getAllPhones();
        return phones;
    }

    /**
     * Отримання телефону за id
     * @param phoneId
     * @return
     */
    @GetMapping("/phones/{phoneId}") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public Phone getPhoneById(@PathVariable int phoneId){
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах PATH у запиті
        Phone phone = phoneService.getPhoneById(phoneId);
        return phone;
    }

    /**
     * Додавання телефону
     * @param phone
     * @return
     */
    @PostMapping("/phones") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу POST
    public Phone addPhone(@RequestBody Phone phone){
        // @RequestBody – анотація, що дозволяє отримати дані з ТІЛА запиту (при POST запиті)
        phoneService.saveOrUpdatePhone(phone);
        return phone; // оскільки зберагіється екземпляр ссилочного типу даних та збереження відбуватиметься за посиланням, Hibernate додасть за цим посиланням id - повернений об'єкт вже матиме id за яким він збережений до БД
    }

    /**
     * Оновлення телефону
     * @param phone
     * @return
     */
    @PutMapping("/phones") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу PUT
    public Phone updatePhone(@RequestBody Phone phone){
        // @RequestBody – анотація, що дозволяє отримати дані з ТІЛА запиту (при POST запиті)
        phoneService.saveOrUpdatePhone(phone);
        return phone; // оскільки зберагіється екземпляр ссилочного типу даних та збереження відбуватиметься за посиланням, Hibernate додасть за цим посиланням id - повернений об'єкт вже матиме id за яким він збережений до БД
    }

    /**
     * Видалення телефону за id
     * @param phoneId
     */
    @DeleteMapping("phones/{phoneId}") // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу DELETE
    public void deletePhoneById(@PathVariable int phoneId){
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах path у запиті
        phoneService.deletePhoneById(phoneId);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return contacts;
    }

    @GetMapping("/contacts/{id}")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу GET
    public Contact getContactById(@PathVariable int id) {
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах  path у запиті
        Contact contact = contactService.getContactById(id);
        return contact;
    }

    @PostMapping("/contacts")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу POST
    public Contact addContact(@RequestBody Contact contact) {
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при POST запиті)
        contactService.saveOrUpdateContact(contact);
        return contact; // оскільки зберагіється екземпляр ссилочного типу даних та збереження відбуватиметься за посиланням, Hibernate додасть за цим посиланням id - повернений об'єкт вже матиме id за яким він збережений до БД
    }

    @PutMapping("/contacts")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу PUT
    public Contact updateContact(@RequestBody Contact contact) {
        // @RequestBody – анотація, що дозволяє отримати дані з тіла запиту (при PUT запиті)
        contactService.saveOrUpdateContact(contact); // метод saveOrUpdateEmployee працює відповідно  до наявності/відсутності параметра id - у разі наявності -оновлює дані, у разі відсутності - зберігає новий об'єкт
        return contact; // повертається об'єкт після внесення змін
    }

    @DeleteMapping("/contacts/{id}")
    // спеціалізований варіант анотації @RequestMapping - забезпечує спрацювання методу при відправленні на вказану у атрибутах URL-адресу запиту типу DELETE
    public void deleteContactById(@PathVariable int id) {
        // @PathVariable int id – анотація дозволяє отримати дані, що передаються у параметрах path у запиті
        contactService.deleteContactById(id);
    }

}
