package Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
@NamedQuery(name="project.findAll", query="SELECT e FROM Project e")
public class Project implements Serializable {

    @Id
    @Column(name = "PROJID")
    private String projid;
    @Column(name = "PROJNAME")
    private String projname;

    @Temporal(value=TemporalType.DATE)
    @Column(name="STARTDATE")
    private Date startdate;

    @Temporal(value=TemporalType.DATE)
    @Column(name="TARGETDATE")
    private Date targetdate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DESCRIPTION")
    private String desc;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "projectmember",
            joinColumns = @JoinColumn(name = "PROJID"),
            inverseJoinColumns = @JoinColumn(name = "EMPID"))
    List<employee> employees;

    public Project(){

    }

    public List<employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<employee> employees) {
        this.employees = employees;
    }

    public Date getStartdate() {
        return startdate;
    }

    public Date getTargetdate() {
        return targetdate;
    }

    public String getDesc() {
        return desc;
    }

    public String getProjid() {
        return projid;
    }

    public String getProjname() {
        return projname;
    }

    public String getStatus() {
        return status;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setProjid(String projid) {
        this.projid = projid;

    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setTargetdate(Date targetdate) {
        this.targetdate = targetdate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

