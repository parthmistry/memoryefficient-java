package post.parthmistry.memoryefficient.demoweb.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import post.parthmistry.memoryefficient.demoweb.domain.User;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

}
