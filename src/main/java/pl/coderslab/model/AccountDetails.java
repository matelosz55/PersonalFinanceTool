package pl.coderslab.model;

import javax.persistence.*;

@Entity
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double accountValue;


    public AccountDetails(double accountValue) {
        this.accountValue = accountValue;

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


    @Override
    public String toString() {
        return "AccountDetails{" +
                "id=" + id +
                ", accountValue=" + accountValue +
                '}';
    }
}
