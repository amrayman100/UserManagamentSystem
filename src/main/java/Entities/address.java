package Entities;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "address")
@NamedQuery(name="address.findAll", query="SELECT e FROM address e")
public class address implements Serializable {

    @Id
   @Column(name = "ADDRESSID")

    private int phoneid;
    @ManyToOne
    @JoinColumn (name = "EMPID")
    private employee e;
    @Column(name = "ADDLINE1")
    private String add1;

    @Column(name = "ADDLINE2")
    private String add2;

    @Column(name = "CITY")
    private String city;
    @Column(name = "REGION")
    private String region;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "POSTCODE")
    private String POSTCODE;


    public int getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(int phoneid) {
        this.phoneid = phoneid;
    }

    public employee getE() {
        return e;
    }

    public void setE(employee e) {
        this.e = e;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPOSTCODE() {
        return POSTCODE;
    }

    public void setPOSTCODE(String POSTCODE) {
        this.POSTCODE = POSTCODE;
    }
}
