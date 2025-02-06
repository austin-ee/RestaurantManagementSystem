/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS;

import com.aust.RestaurantMS.customer.Customer;
import com.aust.RestaurantMS.customer.CustomerRepository;
import com.aust.RestaurantMS.employee.Employee;
import com.aust.RestaurantMS.employee.EmployeeRepository;
import com.aust.RestaurantMS.user.User;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class CustormUserDetailsService implements UserDetailsService{
    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    
    public CustormUserDetailsService(EmployeeRepository employeeRepository,CustomerRepository customerRepository){
        this.employeeRepository=employeeRepository;
        this.customerRepository=customerRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=null;
       if(username.contains("@")){
           Optional<Customer> opt=customerRepository.findById(username);
           if(opt.isPresent()){user=opt.get();}
       }
       else{
           Optional<Employee> opt=employeeRepository.findById(username);
           if(opt.isPresent()){user=opt.get();}
       }
       if(user==null){throw new UsernameNotFoundException("Usename \""+username+"\" does not exist");}
       return new org.springframework.security.core.userdetails.User(
                    user.getUserId(),
                    user.getPassword(),
                    getAuthoritiesForUser(user)
            );
    }
    
    private Collection<? extends GrantedAuthority> getAuthoritiesForUser(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if(user instanceof Employee){authorities.add(new SimpleGrantedAuthority("EMPLOYEE"));}
        if(user instanceof Customer){authorities.add(new SimpleGrantedAuthority("Customer"));}
        return authorities;
    }
    
}
