/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS.table;

import com.aust.RestaurantMS.reservation.Reservation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;


/**
 *
 * @author steve
 */
@Entity
@Table(name="tableDetails")
public class TableDetails {
    @Id
    @Column(name="tableno")
    private Long Tableno;
    @Column(name="no_of_chairs")
    private int Chairs;
    @Column(name="status")
    private String Status;
    @OneToMany(mappedBy="tabledet", cascade=CascadeType.ALL)
    private List<Reservation> Reservation;
    
    public TableDetails() {
    }

    public TableDetails(Long Tableno) {
        this.Tableno = Tableno;
    }
    
    public TableDetails(Long Tableno, int Chairs, String status) {
        this.Tableno = Tableno;
        this.Chairs = Chairs;
        this.Status = status;
    }

    public Long getTableno() {
        return Tableno;
    }

    public void setTableno(Long Tableno) {
        this.Tableno = Tableno;
    }

    public int getChairs() {
        return Chairs;
    }

    public void setNo_Of_Chairs(int Chairs) {
        this.Chairs =Chairs;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public List<Reservation> getReservation() {
        return Reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.Reservation = reservation;
    }
    
    
}
