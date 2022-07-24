package ptithcm.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @Valid
    @NotEmpty
    @Column(columnDefinition = "varchar(30)")
    private String name;

    @NotEmpty
    @Lob
    @Size(min = 10)
    @Column(columnDefinition = "text")
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @DateTimeFormat(pattern = "HH:mm:ss dd/MM/yyyy")
    private Date sentTime;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Valid
    @NotEmpty
    @Email
    private String email;

    public Message() {
        this.sentTime = new Date(System.currentTimeMillis());
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date timestamps) {
        this.sentTime = timestamps;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
