package com.birthright.repository;

import com.birthright.entity.OrdersProducts;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by birthright on 07.05.16.
 */
@Repository
public interface OrdersProductsRepository extends CrudRepository<OrdersProducts, Long> {
    @SQLInsert(sql = "SELECT ")
    @Query(value = "insert into commit_activity_link (commit_id, activity_id) VALUES (?1, ?2)", nativeQuery = true)
    void insertLinkToActivity(long commitId, long activityId);
}
