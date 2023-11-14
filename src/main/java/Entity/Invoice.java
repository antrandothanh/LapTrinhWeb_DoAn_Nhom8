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
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<LineItem> lineItems;
    private Date createdDate;

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
        return 0;
        //
    }
    private long getTotalPrice(){
        return 0;
        //
    }
}
