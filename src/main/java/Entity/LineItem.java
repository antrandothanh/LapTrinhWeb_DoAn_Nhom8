package Entity;

import javax.persistence.*;
import javax.sound.sampled.Line;
import java.io.Serializable;

import java.security.SecureRandom;
import java.util.List;

import DAO.*;

@Entity
public class LineItem implements Serializable {
    @Id
    private long id;
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
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
    public LineItem(){

    }
    public LineItem(Product p, int quantity){
        this.item = p;
        this.quantity = quantity;
        this.id = AutoGenerateId();
    }

    public long AutoGenerateId() {
        SecureRandom random = new SecureRandom();
        long idTemp = random.nextLong();
        List<LineItem> lineItems = LineItemDAO.selectLineItems();
        if (lineItems == null) {
            return idTemp;
        } else {
            for (int i = 0; i < lineItems.size(); i++) {
                if (idTemp == lineItems.get(i).getId()) {
                    idTemp = random.nextLong();
                    i = 0;
                }
            }
            return idTemp;
        }
    }

}
