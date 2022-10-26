package org.example.ex1;

import org.example.ex1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App1
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // конфігураційний файл
                .addAnnotatedClass(Employee.class) // передаються сутності (Entity) - в даному разі 1 - Employee
                .buildSessionFactory();

        Session session = factory.getCurrentSession(); // життєвий цикл сесії невеликий - створюється для здійснення запиту, після вдповіді - закривається

        session.beginTransaction();

        // отримання об'єкта Employee за id
        Employee employee = session.get(Employee.class, 2);
        System.out.println(employee);

        session.getTransaction().commit(); // знімок - збереження в БД раніше зроблених змін ,   навіть у разі виникнення помилки

        // після відпрацювання .commit() - сесія припиняє існування та для здійснення іншого запиту потрібно буде створити іншу сесію


    }
}
