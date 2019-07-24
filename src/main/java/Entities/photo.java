package Entities;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "photo")
@XmlRootElement
public class photo implements Serializable {

    @Id
    @Column(name = "PHOTOIDُ")

    private int photoid;
    @OneToOne
    @JoinColumn (name = "EMPID")
    private employee e;
    @Column(name = "IMAGENAME")
    private String image;

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }

    public employee getE() {
        return e;
    }

    public void setE(employee e) {
        this.e = e;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
