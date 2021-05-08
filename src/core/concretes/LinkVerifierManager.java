package core.concretes;

import core.abstracts.LinkVerifierService;
import entities.concretes.User;

public class LinkVerifierManager implements LinkVerifierService {
    @Override
    public boolean clickToVerify(User user) {
        return true;
    }
}
