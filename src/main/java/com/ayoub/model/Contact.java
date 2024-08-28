package com.ayoub.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

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


    @Size(min = 1 ,max = 10, message = "The name should not exceed ten characters")
    @Column(nullable = false)
    @NotBlank(message = "The name is mandatory")
    private String Name;

    @Email(message = "Email format should be valid")
    @NotBlank(message = "The email is mandatory")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "The message is mandatory")
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
