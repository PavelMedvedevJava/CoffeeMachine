package company.service.impl;

import company.model.Coffee;
import company.repository.CoffeeRepository;
import company.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Override
    public void create(Coffee coffee) {
        coffeeRepository.save(coffee);
    }
}
