package com.dohatec.sharethoughts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apiUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username")
    @NotBlank
    private String userName;

    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;

    @Column(name = "phoneNo")
    private String phoneNo;

    @Column(name="password")
    private String password;

    @Column(name="active")
    private boolean active;

    @Column(name="roles")
    private String roles;
}