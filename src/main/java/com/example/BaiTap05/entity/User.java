package com.example.BaiTap05.entity;

import lombok.Data;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullname;
    private String phone;
    private String imagePath;
    @Column(name = "role")
    private String role;
	public void setImagePath(String string) {

	}
	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}
}