package business;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Categories implements Serializable {
    private String code;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
