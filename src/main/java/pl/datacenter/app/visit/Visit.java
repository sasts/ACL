package pl.datacenter.app.visit;

import pl.datacenter.app.visitor.Visitor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visitor visitor;

    @Column(name = "log_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logIn;

    @Column(name = "log_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logOut;

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

    public Date getLogIn() {
        return logIn;
    }

    public void setLogIn(Date logIn) {
        this.logIn = logIn;
    }

    public Date getLogOut() {
        return logOut;
    }

    public void setLogOut(Date logOut) {
        this.logOut = logOut;
    }
}
