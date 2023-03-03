package com.poolstore.quickclean.bootstrap;


import com.poolstore.quickclean.models.Product;
import com.poolstore.quickclean.repository.ProductRepository;
import com.poolstore.quickclean.repository.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoad implements ApplicationListener<ContextRefreshedEvent> {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public DataLoad(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        getProducts();
    }


    @Transactional
    private void getProducts(){
        Product shock = new Product();
        shock.setName("Clear Again Shock");
        shock.setPrice(29.99d);
        shock.setQuantity(99);
        shock.setStock(true);
        shock.setId(1L);

        productRepository.save(shock);


        Product vacuum = new Product();
        vacuum.setId(2L);
        vacuum.setName("Sling-Vac");
        vacuum.setPrice(199.99d);
        vacuum.setStock(true);
        vacuum.setQuantity(25);

        productRepository.save(vacuum);

        Product filter = new Product();
        filter.setName("Hayward C4030 Cartridge Filter");
        filter.setId(3L);
        filter.setStock(true);
        filter.setPrice(999.99d);
        filter.setQuantity(15);

        productRepository.save(filter);

        Product pump = new Product();
        pump.setId(1l);
        pump.setName("Hayward Super-pump 1.5HP");
        pump.setPrice(599.99d);
        pump.setQuantity(10);
        pump.setStock(true);

        productRepository.save(pump);

    }
}
