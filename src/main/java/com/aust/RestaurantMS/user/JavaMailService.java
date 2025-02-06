/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author steve
 */
@Service
public class JavaMailService {
    @Autowired
    private JavaMailSender javamailSender;
    
    public void sendMail(String to,String txt,String subject){
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(txt);
        javamailSender.send(msg);
    }
}
///@Value to retrieve values from  from db