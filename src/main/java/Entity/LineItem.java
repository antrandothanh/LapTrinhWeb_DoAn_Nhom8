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
    public LineItem(){

    }
    public LineItem(Product p, int quantity){
        this.item = p;
        this.quantity = quantity;
    }
}
