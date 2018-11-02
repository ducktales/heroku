package hello;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {
    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository systemRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
