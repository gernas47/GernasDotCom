package core.concretes;

import entities.concretes.User;
import googleAuthenticationModule.GoogleUserDetails;

public class GoogleUserAdapter{
    GoogleUserDetails googleUser = new GoogleUserDetails();
    User user = new User();

    public void adaptUser(User user, GoogleUserDetails googleUser){
        user.setId(googleUser.getId());
        user.setEmail(googleUser.getEmail());
        user.setFirstName(googleUser.getFirstName());
        user.setLastName(googleUser.getLastName());
        user.setPassword(googleUser.getPassword());

    }

}
