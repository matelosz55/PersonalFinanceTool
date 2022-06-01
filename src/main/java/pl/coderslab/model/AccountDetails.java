package pl.coderslab.model;

import javax.persistence.*;

@Entity
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double accountValue;
    @OneToOne(optional = false)
    @JoinColumn(name = "userId")
    private User userId;

    public AccountDetails(double accountValue, User userId) {
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "id=" + id +
                ", accountValue=" + accountValue +
                ", userId=" + userId +
                '}';
    }
}
