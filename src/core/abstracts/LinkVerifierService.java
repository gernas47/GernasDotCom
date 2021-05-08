package core.abstracts;

import entities.concretes.User;

public interface LinkVerifierService {
    boolean clickToVerify(User user);
}
