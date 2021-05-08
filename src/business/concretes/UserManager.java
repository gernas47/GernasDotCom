package business.concretes;

import business.abstracts.UserService;
import core.abstracts.EmailValidatorService;
import core.abstracts.VerifyingService;
import core.concretes.EmailValidator;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

import java.util.ArrayList;


public class UserManager implements UserService {

    EmailValidatorService emailValidator;
    HibernateUserDao userDao;
    VerifyingService verifyingService;
    ArrayList<User> users = new ArrayList<>();

    public UserManager(HibernateUserDao userDao, EmailValidator emailValidator, VerifyingService verifyingService, ArrayList<User> users) {
        this.userDao = userDao;
        this.emailValidator = emailValidator;
        this.verifyingService = verifyingService;
        this.users = users;
    }

    @Override
    public void add(User user) {
        if (checkIfValidFirstAndLastName(user) && checkIfValidPassword(user) && checkIfValidEmail(user) && checkIfEmailExists(user)){
            verifyingService.sendVerifyingLink(user);
            if(verifyingService.CheckIfVerified(user)){
                userDao.add(user);
            }
            System.out.println("Kullanıcı eklendi: " + user.getFirstName());

        }else {
            System.out.println("Kayıt başarısız: " + user.getFirstName());
        }
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    private boolean checkIfValidFirstAndLastName(User user){
        if(user.getFirstName().length()<2||user.getLastName().length()<2){
            System.out.println("Kullanıcı ad ve soyadınız en az 2 karakterden oluşmalıdır");
            return false;
        }
        return true;
    }

    private boolean checkIfValidPassword(User user){
        if(user.getPassword().length()<6){
            System.out.println("Kullanıcı parolanız en az 6 karakterden oluşmalıdır");
            return false;
        }
        return true;
    }

    private boolean checkIfValidEmail(User user){
        if(!emailValidator.isEmailValid(user.getEmail())){
            System.out.println("Geçersiz bir email adresi girdiniz");
            return false;
        }
        return true;
    }



    private boolean checkIfEmailExists(User user){
        for (User u:users) {
            if(u.getEmail() == user.getEmail()){
                System.out.println("Kullanıcı mevcut");
                return false;
            }
        }
        return true;
    }

}
