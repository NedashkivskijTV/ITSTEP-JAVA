package edu.itstep.mvc;


import javax.validation.constraints.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class User {
    @Size(min = 2, max = 50, message = "The field should contain from 2 to 50 characters")
    private String firstName;
    @Size(min = 2, max = 50, message = "The field should contain from 2 to 50 characters")
    private String lastName;
    private Calendar birthday;
    @NotBlank(message = "Field is required")
    private String gender;
    @NotBlank(message = "Field is required")
    @Pattern(regexp = "[a-zA-Z0-9_-]+@[a-zA-Z]+\\.[a-z]{2,6}", message = "exemple@domain.com")
    private String email;
    @NotBlank(message = "Field is required")
    @Pattern(regexp = "\\+\\d{12}", message = "Sign + and 12 digits")
    private String phone;
    @NotEmpty(message = "Field is required")
    private String[] languages;
    @NotBlank(message = "Field is required")
    private String informationSource;

    public User() {
    }

    public User(String firstName, String lastName, Calendar birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Calendar getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Calendar birthday) {
//        this.birthday = birthday;
//    }
    public String getBirthday() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dob = df.format(birthday.getTime());
        return dob;
    }

    public void setBirthday(String birthday) {
        String[] dateWords = birthday.split("-");
        int year = Integer.parseInt(dateWords[0]);
        int month = Integer.parseInt(dateWords[1]) - 1;
        int day = Integer.parseInt(dateWords[2]);
        Calendar dob = new GregorianCalendar(year, month, day);
        this.birthday = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String getInformationSource() {
        return informationSource;
    }

    public void setInformationSource(String informationSource) {
        this.informationSource = informationSource;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + getBirthday() +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
