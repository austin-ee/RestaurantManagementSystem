/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steve
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{
    @Query(value="Select * from employee", nativeQuery=true)
    List<Employee> findEmployees();
    
    @Query(value="SELECT * FROM employee WHERE onLeave=?1)",nativeQuery=true)
    List<Employee> leaveStatus(boolean b);
    
}
