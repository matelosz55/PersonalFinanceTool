package pl.coderslab.model;

import javax.persistence.*;

@Entity
@Table(name = "account details")
public class AccountDetails {
    // id
    // user id
    // account value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double accountValue;
    @OneToOne(optional = false)
    @JoinColumn(name = "users_id")
    private long userId;

    public AccountDetails(double accountValue, long userId) {
        this.accountValue = accountValue;
        this.userId = userId;
    }

    public AccountDetails() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(double accountValue) {
        this.accountValue = accountValue;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
