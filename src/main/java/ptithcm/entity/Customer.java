package ptithcm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @NotEmpty
    @Size(min = 5, max = 30)
    @Column(columnDefinition = "varchar(255)")
    private String customerName;

    @NotEmpty
    @Email
    @Column(unique = true)
    private String customerEmailAddress;

    @NotEmpty
    @Pattern(regexp = "^0[0-9]{9,10}$", message="Invalid phone number format!")
    private String customerPhoneNumber;

    @NotEmpty
    @Size(min = 5, max = 30)
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9][a-zA-Z0-9_-]{3,30}")
    private String username;

    @NotEmpty
    @Size(min=6,max=30)
    private String password;

    private boolean enabled;

    @Valid
    @OneToOne(orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @Valid
    @OneToOne(orphanRemoval = true, cascade = {CascadeType.ALL})
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "cartId")
    private Cart cart;

//    @JsonBackReference
//    @OneToMany(mappedBy = "Customer", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    private Set<Message> messages;


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }

    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
