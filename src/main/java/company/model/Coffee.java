package company.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name ="coffee",schema = "coffeeDB")
public  class Coffee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String typeCoffee;
    private Date dateCreateCoffee;
    private boolean milk;
    private int sugar;
    private int size;

    public void setTypeCoffee(String typeCoffee) {
        this.typeCoffee = typeCoffee;
    }

    public void setDateCreateCoffee(Date dateCreateCoffee) {
        this.dateCreateCoffee = dateCreateCoffee;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
