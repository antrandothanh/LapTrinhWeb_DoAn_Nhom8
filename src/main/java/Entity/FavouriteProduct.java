package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
@Entity
public class FavouriteProduct implements Serializable{
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Product> products;

    @Id
    @OneToOne
    private User user;
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
