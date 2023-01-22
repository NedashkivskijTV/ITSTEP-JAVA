package edu.itstep.fullstackserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * клас - точка входу у проект
 */
//@SpringBootApplication(scanBasePackages = "edu.itstep")
@SpringBootApplication // це збірна анотація, яка заміняє собою декілька інших,
// серед яких @ComponentScan, яка вказувала яку папку потрібно сканувати на
// предмет наявності сутнестей на основі яких створюватимуться біни –
// у SpringBoot такі анотацій (на сканування компонентів) вказувати не потрібно,
// корньовий пекедж вже буде скануватись –
// у разі виникнення потреби вказати інший пекедж – до анотації додається атрибут scanBasePackages,
// що приймає шлях до пекеджу у вигляді рядка - @SpringBootApplication(scanBasePackages = "edu.itstep")
public class FullstackServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackServerApplication.class, args);
    }

}
