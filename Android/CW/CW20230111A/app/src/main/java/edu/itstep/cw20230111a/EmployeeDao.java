package edu.itstep.cw20230111a;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao // вказує на те, що даний інтерфейс містить описи методів для взаємодії з БД
public interface EmployeeDao {

    @Query("SELECT * FROM employee") // у параметрах анотації прописується запит (виконуватиме Room DB), котрий буде виконано при виклику методу getAll
    List<Employee> getAll();

    @Query("SELECT * FROM employee WHERE id = :id") // у параметрах анотації прописується запит (виконуватиме Room DB), котрий буде виконано при виклику методу getById, потребує предачі параметра при виклику даного методу
    Employee getById(long id);

    @Insert // вказує на виконання ппевної CRUD операції - вставка
    void insert(Employee employee);

    @Update // вказує на виконання ппевної CRUD операції - редагування
    void update(Employee employee);

    @Delete // вказує на виконання ппевної CRUD операції - видалення
    void delete(Employee employee);

}
