import business.concretes.AuthenticationManager;
import business.concretes.UserManager;
import core.concretes.EmailValidator;
import core.concretes.EmailVerifyingManager;
import core.concretes.GoogleAuthenticationManagerAdapter;
import core.concretes.LinkVerifierManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;
import googleAuthenticationModule.GoogleUserDb;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        User user = new User(1, "Gernas", "Kilic", "g@gernas.com", "123456");
        User user2 = new User(2, "Ali", "Demir", "g@gernas.com", "123456");
        User user3 = new User(3, "Ömer", "Akkuş", "g@gernas.com", "123456");
        User user4 = new User(4, "Gernas", "Kilic", "gernas@gernas.com", "123456");

        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        users.add(user3);

        GoogleUserDb googleUserDb = new GoogleUserDb();
        googleUserDb.getUsers();

        AuthenticationManager authenticationManager = new AuthenticationManager(new UserManager(new HibernateUserDao(),new EmailValidator(), new EmailVerifyingManager(new LinkVerifierManager()), users));
        GoogleAuthenticationManagerAdapter googleAuthenticationManagerAdapter  = new GoogleAuthenticationManagerAdapter(googleUserDb.getUsers()[2]);
        System.out.println("-----------------------");
        googleAuthenticationManagerAdapter.register();
        System.out.println("-----------------------");
        googleAuthenticationManagerAdapter.login();
        System.out.println("-----------------------");
        authenticationManager.register(user4);
        System.out.println("-----------------------");
        authenticationManager.login(user);


}
}
