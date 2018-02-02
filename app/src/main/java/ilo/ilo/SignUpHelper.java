package ilo.ilo;


public class SignUpHelper {

    private String mEmail;
    private String mUserName;
    private String mPassword;

    public SignUpHelper(String email, String user, String pass){
        this.mEmail = email;
        this.mPassword = pass;
        this.mUserName = user;
    }
    private boolean isValidEmail(){
        //check for valid email address
        return mEmail.contains("@") && mEmail.length() > 8;
    }


    private boolean isValidUserName(){
        // simple check to make sure username is valid
        return mUserName.length()  > 5;
    }

    private  boolean isValidPassword(){
        // simple check for password length
        return mPassword.length() > 8;
    }

    public  boolean validateForm(){
        return isValidEmail() && isValidPassword() && isValidUserName();
    }

}
