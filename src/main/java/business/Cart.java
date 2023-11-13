package business;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Cart implements Serializable{
    @Id
    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;
    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<LineItem> items;
    public List<LineItem> getItems() {
        return items;
    }

    public void setItems(List<LineItem> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
