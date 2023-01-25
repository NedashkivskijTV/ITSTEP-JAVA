package edu.itstep.fullstackclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EmployeeApi {

    /**
     * Retrofit використовується тип даних Call<> («виклик»), типізується колекцією
     *     // елементів, що потрібно отримати(List<Employee>),
     *     // є інстументом Retrofit – при використанні потрібно підключити простір імен
     *     // import retrofit2.Call
     *     // – після виклику методу getAllEmployees() буде отримано спеціальний об’єкт Call,
     *     // за допомогою якого можна буде отримати потрібні дані
     * @return
     */
    @GET("/employees") // вказує який саме запит викликатиме даний метод, URL отримується з документації сервера
    Call<List<Employee>>getAllEmployees();

    @GET("/employees/{id}") // вказує який саме запит викликатиме даний метод, URL отримується з документації сервера
    Call<Employee>getEmployeeById(@Path("id") int id);

    @POST("/employees") // вказує який саме запит викликатиме даний метод, URL отримується з документації сервера
    Call<Employee>saveEmployee(@Body Employee employee);

    @PUT("/employees") // вказує який саме запит викликатиме даний метод, URL отримується з документації сервера
    Call<Employee>updateEmployee(@Body Employee employee);

    @DELETE("/employees/{id}") // вказує який саме запит викликатиме даний метод, URL отримується з документації сервера
    Call<Employee> deleteEmployeeById(@Path("id") int id);
    // Метод повертає об'єкт Employee, оскільки у іншому випадку можливе
    // генерування помилки, пов'язаної з тим, що повертається не об'єкт JSON, а HTML (рядок)
    // (MalformedJsonException: Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 1 path $)
}
