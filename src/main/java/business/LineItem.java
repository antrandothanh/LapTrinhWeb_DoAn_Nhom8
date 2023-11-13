package business;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LineItem implements Serializable {
    @Id
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private Product item;
    private int quantity;
    public Product getItem() {
        return item;
    }
    public void setItem(Product item) {
        this.item = item;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
