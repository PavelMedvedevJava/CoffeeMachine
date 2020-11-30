package company.model;

import company.service.impl.CoffeeServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
public class BoshM11 implements CoffeeMachine {

    private BoshM11() {
    }

    private static BoshM11 instance;

    private List<CoffeeType> coffeeTypesToMake;

    private StatusCoffeeMachine statusCoffeeMachines;

    private Coffee coffee;

@Autowired
    private CoffeeServiceImpl coffeeService;

    public void setStatusCoffeeMachines(StatusCoffeeMachine statusCoffeeMachines) {
        this.statusCoffeeMachines = statusCoffeeMachines;
    }

    private BoshM11(List<CoffeeType> typeList, StatusCoffeeMachine statusCoffeeMachines) {
    }

    public static synchronized BoshM11 getInstance() {
        if (instance == null) {
            instance = new BoshM11(Arrays.asList(CoffeeType.Mocha, CoffeeType.Americano), StatusCoffeeMachine.READY);
        }

        return instance;
    }

    @Override
    public Coffee doCoffee(String typeCoffee) throws InterruptedException {
        if (coffeeTypesToMake.stream().filter(coffeeType -> typeCoffee.equals(coffeeType.toString())).findAny().orElse(null)==null) {
        }
        if (coffee.equals(CoffeeType.Americano.toString())) {
            coffee = new Coffee();

            instance.setStatusCoffeeMachines(StatusCoffeeMachine.shredding);
            Thread.sleep(5000);
            coffee.setTypeCoffee("Americano");
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.Warming_up);
            Thread.sleep(5000);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.pouring_coffee);
            Thread.sleep(5000);
            coffee.setSize(200);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.adding_sugar);
            Thread.sleep(5000);
            coffee.setSugar(10);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.adding_milk);
            Thread.sleep(5000);
            coffee.setMilk(true);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.READY);
            coffee.setDateCreateCoffee(new Date());
            coffeeService.create(coffee);

        } else if (coffee.equals(CoffeeType.Mocha.toString())) {
            coffee = new Coffee();

            instance.setStatusCoffeeMachines(StatusCoffeeMachine.shredding);
            Thread.sleep(5000);
            coffee.setTypeCoffee("Mocha");
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.Warming_up);
            Thread.sleep(5000);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.pouring_coffee);
            Thread.sleep(5000);
            coffee.setSize(250);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.adding_sugar);
            Thread.sleep(5000);
            coffee.setSugar(5);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.adding_milk);
            Thread.sleep(5000);
            coffee.setMilk(false);
            instance.setStatusCoffeeMachines(StatusCoffeeMachine.READY);
            coffee.setDateCreateCoffee(new Date());
            coffeeService.create(coffee);
        }
        return coffee;
    }


}
