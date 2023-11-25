package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Invoice implements Serializable{
    @Id
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;
    //-fetch=FetchType.EAGER nghĩa là khi một entity được load,
    // tất cả các entities liên quan cũng sẽ được load ngay lập tức
    //-cascade=CascadeType.ALL nghĩa là tất cả các thao tác
    // (bao gồm cả các thao tác cụ thể của Hibernate) sẽ được lan truyền
    // từ entity cha xuống entity con.
    //Ví dụ, nếu bạn xóa một entity, tất cả các entities liên quan cũng sẽ bị xóa
    @OneToMany
    private List<LineItem> lineItems;
    private Date createdDate;
    private String address;
    private String note;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    private int getTotalAmount(){
        return lineItems.size();
    }
    public long getTotalPrice(){
        long totalPrice = 0;
        for (int i=0; i<getTotalAmount(); i++){
            totalPrice += lineItems.get(i).getItem().getPrice() * lineItems.get(i).getQuantity();
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
    public Invoice(User user, List<LineItem> lineItems, Date createdDate, String address, String note){
        this.user = user;
        this.lineItems = lineItems;
        this.createdDate = createdDate;
        this.address = address;
        this.note = note;
    }
}
