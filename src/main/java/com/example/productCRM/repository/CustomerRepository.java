package com.example.productCRM.repository;

import com.example.productCRM.model.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;




//
@Repository
public interface CustomerRepository
        extends CrudRepository<Customer,Long> {
    List<Customer> findByName(String name);
    //select * from customer where name='Can' or surname="Duman"
    List<Customer> findByNameOrSurname(String name,String surname);
    //aynı isim varsa sadece birisini döndürün
    List<Customer> findDistinctByName(String name);
    // age 40 dan büyük olan müşterileri döndürün
    List<Customer> findByAgeGreaterThan(Integer age);
    // yaşı 40 dan eşit küçük ve ismi can(ignorecase) olan kayıtları bulun.
    List<Customer> findByAgeLessThanEqualAndNameIgnoreCase(Integer age,String name);
    // tüm müşterileri dönün fakat isme göre alfabetik olsun. Küçük büyüğe doğru
    List<Customer> findAllByAgeGreaterThanOrderByName(Integer age);
    // yaşı 30 ile 50 arasında olan müşteleri veya isminde bur geçenleri getirin.
    List<Customer> findByAgeBetweenAndNameContainingIgnoreCase(Integer startAge,
                                                              Integer endAge,String name);
    @Query(value = "Select c.name from Customer c order by c.name")
    List<Customer> customFindAll();

    @Query(value = "Select c from Customer c" +
            " where c.name=:name or c.surname=:surname order by c.name")
    List<Customer> customByNameOrSurname
            (@Param("name") String name,@Param("surname") String surname);
}
