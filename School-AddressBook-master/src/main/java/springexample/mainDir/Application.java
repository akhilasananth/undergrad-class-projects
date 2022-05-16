package springexample.mainDir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



/**
 * Created by akhilaananth on 1/26/2017.
 */

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }

    /*
    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Jack", "135456"));
            repository.save(new BuddyInfo("Chloe", "12347856"));
            repository.save(new BuddyInfo("Kim", "186735"));
            repository.save(new BuddyInfo("David", "54354534"));
            repository.save(new BuddyInfo("Michelle", "48645354"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(BuddyInfo.class.getName());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo customer = repository.findOne("135456");
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

        };
    }
    */
}
