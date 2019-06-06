package pl.datacenter.app.visit;

import org.springframework.format.annotation.DateTimeFormat;
import pl.datacenter.app.area.Area;
import pl.datacenter.app.company.Company;
import pl.datacenter.app.visitor.Visitor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "log_in")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime logIn;

    @Column(name = "log_out")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime logOut;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Area area;

    public Visit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public LocalDateTime getLogIn() {
        return logIn;
    }

    public void setLogIn(LocalDateTime logIn) {
        this.logIn = logIn;
    }

    public LocalDateTime getLogOut() {
        return logOut;
    }

    public void setLogOut(LocalDateTime logOut) {
        this.logOut = logOut;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

}
