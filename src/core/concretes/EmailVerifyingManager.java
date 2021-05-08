package core.concretes;

import core.abstracts.LinkVerifierService;
import core.abstracts.VerifyingService;
import entities.concretes.User;

public class EmailVerifyingManager implements VerifyingService {

    LinkVerifierService verifier;

    public EmailVerifyingManager(LinkVerifierService verifier){
        this.verifier = verifier;
    }

    @Override
    public void sendVerifyingLink(User user) {
        System.out.println("Doğrulama linki gönderildi");
    }

    @Override
    public boolean CheckIfVerified(User user) {
        if(!verifier.clickToVerify(user)){
            return false;
        }
        return true;
    }


}
