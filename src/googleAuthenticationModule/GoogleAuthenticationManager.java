package googleAuthenticationModule;

public class GoogleAuthenticationManager {
    public void register(GoogleUserDetails user){
        System.out.println("Kayıt olundu: " + user.getFirstName());
    }
    public void login(GoogleUserDetails user){System.out.println("Giriş yapıldı: " + user.getFirstName());}
}
