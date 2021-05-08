package business.abstracts;

import entities.concretes.User;

public interface AuthenticationService {
    void register(User user);
    void login(User user);
}
