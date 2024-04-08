package codesquad.springcafe.service;

import codesquad.springcafe.domain.User;
import codesquad.springcafe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void join(User user) {
        userRepository.save(user);
    }

    public Map<Long, User> getUsers() {
        return userRepository.getUsers();
    }
}
