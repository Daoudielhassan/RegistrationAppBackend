package com.ayoub.model;

import jakarta.persistence.*;

@Entity

public class Contact {
    @Id
    @SequenceGenerator(
            name = "contact_id_sequence",
            sequenceName = "contact_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contact_id_sequence"
    )
    private Integer Id;
    @Column(nullable = false)
    private String Name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    @Lob
    private String Message;

    public Contact(Integer id, String name, String email, String message) {
        this.Id = id;
        this.Name = name;
        this.email = email;
        this.Message = message;
    }

    public Contact(String name, String email, String message) {
        this.Name = name;
        this.email = email;
        this.Message = message;
    }

    public Contact() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Contact.this.email = email;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
