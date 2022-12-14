package edu.itstep.employee.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration // вказує, що даний клас містить конфігурації, виконує роль файлу applicationContext.xml – унаслідується від @Component (SpringContainer створить відповідний бін)
@ComponentScan(basePackages = "edu.itstep.employee") // вказує пекедж, який потрібно сканувати на предмет наявності сутностей, придатних для створення бінів – аналог рядка у файлі applicationContext.xml <context:component-scan base-package="com.google.accounting"/>
@EnableWebMvc // активує функціонал MVC, без нього не функціонує валідація та інші інструменти MVC – аналог рядка у файлі applicationContext.xml <mvc:annotation-driven/>
@EnableTransactionManagement // налаштування, що активує функціонал, який використовується для відкривання а закривання сесій – аналог рядка у файлі applicationContext.xml - <tx:annotation-driven transaction-manager="transactionManager"/>
public class MyConfig {

    /**
     * Бін, що потрібен для відображення підготовлених представлень (додаватиме до вказуваних у коді імен файлів
     * відповідний префікс (шлях до файлу) та суфікс – розширення файлу)
     * @return
     */
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    /**
     * Бін (id=«dataSource») від класу ComboPooledDataSource – відповідає за з’єднання з БД
     * -	Драйвер для роботи з БД –  com.mysql.cj.jdbc.Driver
     * -	Назва БД - jdbc:mysql://localhost:3306/it_company
     * -	Логін – root
     * -	Пароль – 7777
     * @return
     */
    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/it_company");
            dataSource.setUser("root");
            dataSource.setPassword("7777");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    /**
     * Бін (id=«sessionFactory») від класу LocalSessionFactoryBean – Забезпечення роботи sessionFactory,
     * де, зокрема вказується який пекедж потрібно сканувати на предмет наявності сутностей, з якими працюватиме сесія
     * @return
     */
    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("edu.itstep.employee.entity");

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql", "true");

        localSessionFactoryBean.setHibernateProperties(properties);

        return localSessionFactoryBean;
    }

    /**
     * Бін (id=«transactionManager») від класу HibernateTransactionManager
     * – Активування функціоналу щодо забезпечення роботи з транзакціями – відкриття та закриття – sessionFactory
     * @return
     */
    @Bean
    public HibernateTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());

        return hibernateTransactionManager;
    }

}
