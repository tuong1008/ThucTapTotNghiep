package ptithcm.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Pattern;

@Entity
public class BillingAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billingAddressId;

    @NotEmpty
    @Column(columnDefinition = "varchar(255)")
    private String city;

    @NotEmpty
    @Column(columnDefinition = "varchar(255)")
    private String country;

    @NotEmpty
    @Pattern(regexp="[\\d]{5,6}", message="This field should contain five or six digits!")
    private String zipCode;

    public long getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
