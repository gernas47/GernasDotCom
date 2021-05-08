package core.concretes;

import core.abstracts.EmailValidatorService;

import java.util.regex.Pattern;

public class EmailValidator implements EmailValidatorService {

    private static final String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    public boolean isEmailValid(String emailInput) {
        Pattern pattern = Pattern.compile(emailPattern,
                Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }
}
//bu kod http://www.bahadirakin.com/regex-ile-email-kontrolu/ web sayfasından alınmıştır.