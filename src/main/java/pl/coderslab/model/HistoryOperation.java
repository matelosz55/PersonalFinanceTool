package pl.coderslab.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HistoryOperation {
    //id
    //operation type (wydatek, przelew wychodzacy, przelew wchodzacy)
    //category(jedzenie, alkohol, utrzymanie mieszkania, utrzymanie samochodu i paliwo,
    //  wakacje, kultura i sztuka, gadzety, ubrania, elektronika
    // gadzety, chemia, kosmetyki, zdrowie i leki, transport publiczny + taxi, podatki)
    //subcategory
    //date
    //account id
    //cash value
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String operationType;
    private String category;
    private String subcategory;
    private LocalDateTime operationDate;
    private double cashValue;
    @OneToOne
    @JoinColumn(name = "accountId")
    private AccountDetails accountId;

    public HistoryOperation(long id, String operationType, String category, String subcategory, LocalDateTime operationDate, double cashValue, AccountDetails accountId) {
        this.id = id;
        this.operationType = operationType;
        this.category = category;
        this.subcategory = subcategory;
        this.operationDate = operationDate;
        this.cashValue = cashValue;
        this.accountId = accountId;
    }

    public HistoryOperation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }

    public double getCashValue() {
        return cashValue;
    }

    public void setCashValue(double cashValue) {
        this.cashValue = cashValue;
    }

    public AccountDetails getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountDetails accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "HistoryOperation{" +
                "id=" + id +
                ", operationType='" + operationType + '\'' +
                ", category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", operationDate=" + operationDate +
                ", cashValue=" + cashValue +
                ", accountId=" + accountId +
                '}';
    }
}
