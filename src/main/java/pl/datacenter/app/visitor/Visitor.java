package pl.datacenter.app.visitor;

import org.hibernate.annotations.SortNatural;
import org.hibernate.validator.constraints.NotBlank;
import pl.datacenter.app.area.Area;
import pl.datacenter.app.company.Company;
import pl.datacenter.app.event.Event;
import pl.datacenter.app.visit.Visit;

import javax.persistence.*;
import java.util.List;

@Entity(name = "visitor")
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "visitor")
    private List<Visit> visits;

    @OneToMany(mappedBy = "visitor")
    private List<Event> events;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
