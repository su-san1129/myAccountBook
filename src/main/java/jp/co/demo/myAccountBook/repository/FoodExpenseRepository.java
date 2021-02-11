package jp.co.demo.myAccountBook.repository;

import jp.co.demo.myAccountBook.entity.FoodExpense;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodExpenseRepository extends CrudRepository<FoodExpense, Integer> {

    @Query("SELECT * FROM food_expenses WHERE user_id = :userId")
    List<FoodExpense> findByUserId(@Param("userId") Integer userId);
}
