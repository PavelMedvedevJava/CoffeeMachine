package company.controller;

import company.model.BoshM11;
import company.model.Coffee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/coffee")
public class CoffeeMachineControllerV1 {

    private BoshM11 boshM11 =BoshM11.getInstance();

    private Coffee coffee;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Object> createCoffee(@PathVariable("name") String name) {
        try {
           coffee= boshM11.doCoffee(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (coffee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coffee,HttpStatus.OK);

    }

}
