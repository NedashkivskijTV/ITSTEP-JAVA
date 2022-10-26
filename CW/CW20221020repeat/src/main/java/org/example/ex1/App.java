package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        // ствррюється об'єкт - фабрика по створенню сесій - має бути створений конфігураційний файл (підготовлений раніше)
        // SessionFactory - фабрика по створенню сесій (Session), а
        // сесія Session - це обгортка над підключенням до БД за допомогою JDBC
        // Session - саме за її допомогою здійснюватимуться операції зі спілкування з БД
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity) - в даному разі 1 - Employee
                //.addAnnotatedClass(Employee.class) // передаються сутності - у разі наявності декількох сутностей - вказуються в окремих рядках
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // життєвий цикл сесії невеликий - створюється для здійснення запиту, після вдповіді - закривається

        // Отримання даних для роботи з сесією перед відкриттям сесії
        //Employee employee = new Employee("Ivan", "Ivanenko", "DEVELOPER", 70000);
        Employee employee = new Employee("Oleg", "Olegov", "DEVELOPER", 40000);

        // сесію потрібно відкривати та закривати
        // директива на відкриття сесії
        session.beginTransaction();

        // Додавання даних до БД
        //session.save("777"); // приймає у параметрах Object, який є сутністю (Entity) - в даному разі це Employee, якщо передається неіснуюча сетність - генерується ПОМИЛКА
        session.save(employee); // приймає у параметрах Object, який є сутністю (Entity) - в даному разі це Employee, якщо передається неіснуюча сетність - генерується ПОМИЛКА


        // директива на закриття сесії - є декілька варіантів
        //session.getTransaction().rollback(); // відкат - теж робить commit, але відповідає за збереження в БД інф, що містилась до виникнення помилки
        session.getTransaction().commit(); // знімок - збереження в БД раніше зроблених змін ,   навіть у разі виникнення помилки

        // після відпрацювання .commit() - сесія припиняє існування та для здійснення іншого запиту потрібно буде створити іншу сесію


    }
}
