package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Brand implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    private String name;

    public long getCode()
    {
        return code;
    }
    public void setCode(long code)
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
    public Brand(){}
    public Brand(String name){
        this.name = name;
    }
}

