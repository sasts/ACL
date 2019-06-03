package pl.datacenter.app.company;

import org.hibernate.validator.constraints.NotBlank;
import pl.datacenter.app.file.DBFile;
import pl.datacenter.app.visitor.Visitor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Visitor> visitors;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<DBFile> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public List<DBFile> getFiles() {
        return files;
    }

    public void setFiles(List<DBFile> files) {
        this.files = files;
    }
}