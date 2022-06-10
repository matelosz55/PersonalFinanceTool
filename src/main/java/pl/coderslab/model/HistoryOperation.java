package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @ManyToOne
    @JoinColumn
    @NotNull
    private Categories category;
    @ManyToOne
    @JoinColumn
    @NotNull
    private Subcategories subcategory;
    private String operationDate;
    private double cashValue;
    @ManyToOne
    @JoinColumn(name = "accountId")
    @NotNull
    private AccountDetails account;

    public HistoryOperation(long id, String operationType, @NotNull Categories category, Subcategories subcategory, String operationDate, double cashValue, AccountDetails account) {
        this.id = id;
        this.operationType = operationType;
        this.category = category;
        this.subcategory = subcategory;
        this.operationDate = operationDate;
        this.cashValue = cashValue;
        this.account = account;
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

    public @NotNull Categories getCategory() {
        return category;
    }

    public void setCategory(@NotNull Categories category) {
        this.category = category;
    }

    public Subcategories getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategories subcategory) {
        this.subcategory = subcategory;
    }

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public double getCashValue() {
        return cashValue;
    }

    public void setCashValue(double cashValue) {
        this.cashValue = cashValue;
    }

    public AccountDetails getAccount() {
        return account;
    }

    public void setAccount(AccountDetails account) {
        this.account = account;
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
                ", account=" + account +
                '}';
    }
}
