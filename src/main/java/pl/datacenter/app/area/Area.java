package pl.datacenter.app.area;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import pl.datacenter.app.unique.UniqueArea;
import pl.datacenter.app.visit.Visit;
import pl.datacenter.app.visitor.Visitor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nie może być puste")
    @Column(unique = true)
    @UniqueArea
    private String name;

    @ManyToMany
    private List<Visitor> visitors;

    @OneToMany(mappedBy = "area")
    @JsonIgnore
    private List<Visit> visits;

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

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }
}
