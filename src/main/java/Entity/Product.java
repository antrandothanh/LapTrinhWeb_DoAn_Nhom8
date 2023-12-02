package Entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product implements Serializable{
    @Id
    private String code;
    private String name;
    private long price;
    @OneToOne
    private Brand brand;
    private String collection;
    private String type;
    private String color;
    private String imgURL;
    private String description;
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getCode()
    {
        return code;
    }
    public void setCode(String code)
    {
        this.code=code;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public long getPrice()
    {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    public Product(){}
    public Product(String code, String name, long price, Brand brand, String collection,
                   String type, String color, String imgURL, String description){
        this.code = code;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.collection = collection;
        this.type = type;
        this.color = color;
        this.imgURL = imgURL;
        this.description = description;
    }
}
