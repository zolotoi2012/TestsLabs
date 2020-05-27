package ua.phpguru.training.automationScenaries;

public class User {

     private String email;
     private String passwd;
     private String guestTitle;
     private String authorizedTitle;
     private String authorizedUsername;
     private String phone;


    public User() {
        this.email = "ghost.krut@gmail.com";
        this.passwd = "123456";
        this.guestTitle = "Login - My Store";
        this.authorizedTitle = "My account - My Store";
        this.authorizedUsername = "Vladyslav Smyrnov";
        this.phone = "0995468236";
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getGuestTitle() {
        return guestTitle;
    }

    public String getAuthorizedTitle() {
        return authorizedTitle;
    }

    public String getAuthorizedUsername() {
        return authorizedUsername;
    }

    public String getPhone() {
        return phone;
    }
}
