package Entities;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "phonenumber")
@XmlRootElement
public class phonenumber implements Serializable {

    @Id
    @Column(name = "PHONEID")

    private int phoneid;
    @OneToOne
    @JoinColumn (name = "EMPID")
    private employee e;
    @Column(name = "LOCALNUM")
    private String localnum;

    @Column(name = "INTLPEFIX")
    private String intl;

    @Column(name = "PHONETYPE")
    private String phonetype;

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

    public String getLocalnum() {
        return localnum;
    }

    public void setLocalnum(String localnum) {
        this.localnum = localnum;
    }

    public String getIntl() {
        return intl;
    }

    public void setIntl(String intl) {
        this.intl = intl;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }
}
