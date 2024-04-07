package post.parthmistry.memoryefficient.demoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import post.parthmistry.memoryefficient.demoweb.domain.User;
import post.parthmistry.memoryefficient.demoweb.repository.UserRepository;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

}
