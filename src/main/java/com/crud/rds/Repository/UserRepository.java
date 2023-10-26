package com.crud.rds.Repository;

import com.crud.rds.entity.user_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user_details, Integer> {
//    @Modifying
//    @Query("update user_details u set u.address = :address,u.city = :city where u.user_id = :id")
//    public int updateUser(@Param("address") String address, @Param("city") String city, @Param("id") int id);
}
