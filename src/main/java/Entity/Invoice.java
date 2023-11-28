package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;
    @OneToMany
    private List<BoughtItem> boughtItems;
    private Date createdDate;
    private String address;
    private String note;

    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<BoughtItem> getBoughtItems() {
        return boughtItems;
    }
    public void setBoughtItems(List<BoughtItem> boughtItems) {
        this.boughtItems = boughtItems;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    private int getTotalAmount(){
        return boughtItems.size();
    }

    public long getTotalPrice(){
        long totalPrice = 0;
        for (int i=0; i<getTotalAmount(); i++){
            totalPrice += boughtItems.get(i).getItem().getPrice() * boughtItems.get(i).getQuantity();
        }
        return totalPrice;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    public Invoice(){}

    public Invoice(User user, Date createdDate, String address, String note){
        this.user = user;
        this.boughtItems = new ArrayList<>();
        this.createdDate = createdDate;
        this.address = address;
        this.note = note;
    }

    public Invoice(User user) {
        this.user = user;
        this.boughtItems = new ArrayList<>();
    }
}
