package com.ayoub.model;

import jakarta.persistence.*;

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
    @Column(nullable = false)
    private String FirstName;
    @Column(nullable = false)
    private String LastName;
    @Column(nullable = false)

    private String PhoneNumber;
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

