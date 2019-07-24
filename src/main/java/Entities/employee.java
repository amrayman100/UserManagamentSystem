package Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sumerge.program.EmployeeListener;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "employee")
@EntityListeners(EmployeeListener.class)
@NamedQueries({
        @NamedQuery(name="employee.findAll", query="SELECT e FROM employee e"),
        @NamedQuery(name="employee.findByName",
                query="SELECT e FROM employee e WHERE e.commonname = :commonname"),
})

public class employee implements Serializable {
    @Id
    @Column(name = "EMPID")
    private String empid;
    @ManyToOne
    @JoinColumn (name = "DEPTCODE")
    private department dept;
    @Column(name = "JOBTITLE")
    private String jobtitle;
    @Column(name = "GIVENNAME")
    private String givenname;
    @Column(name = "FAMILYNAME")
    private String famillyname;
    @Column(name = "COMMONNAME")
    private String commonname;
    @Column(name = "NAMETITLE")
    private String nametitle;

    @Transient
    private String formatted;

    public String getFormatted() {
        return this.commonname+" Formated";
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    @ManyToMany
    @JoinTable(
            name = "projectmember",
            joinColumns = @JoinColumn(name = "EMPID"),
            inverseJoinColumns = @JoinColumn(name = "PROJID"))
    List<Project> projects;

    public employee(){

    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getCommonname() {
        return commonname;
    }

    public department getDeptcode() {
        return dept;
    }

    public String getEmpid() {
        return empid;
    }

    public String getFamillyname() {
        return famillyname;
    }

    public String getGivenname() {
        return givenname;
    }

    public String getJobchar() {
        return jobtitle;
    }

    public String getNametitle() {
        return nametitle;
    }

    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }

    public void setDept(department department) {
        this.dept = department;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public void setFamillyname(String famillyname) {
        this.famillyname = famillyname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public void setJobchar(String jobchar) {
        this.jobtitle = jobchar;
    }

    public void setNametitle(String nametitle) {
        this.nametitle = nametitle;
    }


}

