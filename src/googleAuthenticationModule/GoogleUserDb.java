package googleAuthenticationModule;

public class GoogleUserDb {
    public GoogleUserDetails[] getUsers(){
        GoogleUserDetails user1 = new GoogleUserDetails(1, "Gernas", "Kilic", "g@gernas.com", "123456");
        GoogleUserDetails user2 = new GoogleUserDetails(2, "Ali", "Demir", "a@ali.com", "abcdef");
        GoogleUserDetails user3 = new GoogleUserDetails(2, "Yasir", "Akkuş", "y@yasir.com", "qwerty");
        GoogleUserDetails[] googleUsers = {user1,user2, user3};
        return googleUsers;
    }

}