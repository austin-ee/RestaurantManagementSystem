/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.employee;

import com.aust.RestaurantMS.schedule.Schedule;
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
    
    //@Query(value="Select e from employee e WHERE e.user_id IN (SELECT s.user_id FROM schedule s WHERE s.onLeave=?1)")
   // List<Employee> leaveStatus(boolean b);
    
    //@Query("SELECT e.shedules FROM employee WHERE e.user_id=?1")
    //List<Schedule> employeeSchedule(String id);
}
