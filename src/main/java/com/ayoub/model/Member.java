package com.ayoub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Member {
    @Id
    @SequenceGenerator(
            name = "member_id_sequence",
            sequenceName = "member_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_id_sequence"
    )
    private int Id;
    @Size(min = 1 ,max = 10, message = "The first name should not exceed ten characters")
    @Column(nullable = false)
    @NotBlank(message = "The first name is mandatory")
    private String FirstName;


    @Size(min = 1 ,max = 10, message = "The last name should not exceed ten characters")
    @Column(nullable = false)
    @NotBlank(message = "The last name is mandatory")
    private String LastName;


    @Column(nullable = false)
    @NotBlank(message = "The phone number is mandatory")
    @Pattern(regexp = "^(\\+212\\d{9}|06\\d{8})$",
            message = "Phone number should be valid Moroccan format")
    private String PhoneNumber;

    @Email(message = "Email format should be valid")
    @NotBlank(message = "The email is mandatory")
    @Column(nullable = false)
    private String email;

    public Member(String firstName, String lastName, String phoneNumber, int id, String email) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.PhoneNumber = phoneNumber;
        this.Id = id;
        this.email = email;
    }
  public Member(String firstName, String lastName, String phoneNumber, String email) {
        this.FirstName = firstName;
        this.LastName = lastName;
       this.PhoneNumber = phoneNumber;
        this.email = email;
    }

    public Member() {

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Id=" + Id +
                ", Email='" + email + '\'' +
                '}';
    }
}

