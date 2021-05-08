package core.abstracts;

import entities.concretes.User;

public interface VerifyingService {
    void sendVerifyingLink(User user);
    boolean CheckIfVerified(User user);
}
