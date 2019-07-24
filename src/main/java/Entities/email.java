package Entities;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "email")
@XmlRootElement
public class email implements Serializable {

    @Id
    @Column(name = "EMAILIDُ")

    private int emailid;
    @OneToOne
    @JoinColumn (name = "EMPID")
    private employee e;
    @Column(name = "EMAILADDRESS")
    private String address;

    @Column(name = "EMAILTYPE")
    private String type;

    public int getEmailid() {
        return emailid;
    }

    public void setEmailid(int deptcode) {
        this.emailid = deptcode;
    }

    public employee getE() {
        return e;
    }

    public void setE(employee e) {
        this.e = e;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
