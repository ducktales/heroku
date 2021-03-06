package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.OffsetDateTime;
import java.util.Iterator;


import hello.User;
import hello.UserRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestBody  UserMapper body) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(body.getName());
        n.setCategory(body.getCategory());
        n.setAmount(body.getAmount());
        n.setComment(body.getComment());
        n.setCreated_at(OffsetDateTime.now());
        n.setUpdated_at(OffsetDateTime.now());
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/expenses") // Map ONLY GET Requests
    public @ResponseBody Iterable<User>  getExpense () {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request


        return userRepository.findAll();
    }

    @GetMapping(path="/all")
    public @ResponseBody User getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findById(Integer.parseInt("1")).get();
    }
}
