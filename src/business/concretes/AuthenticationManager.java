package business.concretes;

import business.abstracts.AuthenticationService;
import business.abstracts.UserService;
import core.abstracts.EmailValidatorService;
import core.concretes.EmailValidator;
import core.concretes.GoogleAuthenticationManagerAdapter;
import entities.concretes.User;
import googleAuthenticationModule.GoogleUserDetails;

public class AuthenticationManager implements AuthenticationService {

    EmailValidatorService emailValidator;
    AuthenticationService authenticationService;
    UserService userService;

    public AuthenticationManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void register(User user) {
        userService.add(user);
    }

    @Override
    public void login(User user) {
        System.out.println("Giriş yapıldı: " + user.getFirstName());
    }


}
