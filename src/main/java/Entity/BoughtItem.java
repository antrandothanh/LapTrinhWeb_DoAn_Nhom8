package Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BoughtItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
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

    public long getId () { return id; }
    public void setId(long id) { this.id = id; }

    public BoughtItem(){

    }
    public BoughtItem(Product p, int quantity){
        this.item = p;
        this.quantity = quantity;
    }
}
