package ilo.ilo;


public class SignUpHelper {

    private String mEmail;
    private String mUserName;
    private String mPassword;
    private String mPasswordConfirm;

    public SignUpHelper(String email, String user, String pass, String confirmPassword){
        this.mEmail = email;
        this.mPassword = pass;
        this.mUserName = user;
        this.mPasswordConfirm = confirmPassword;
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

    private boolean isConfirmed(){
        //Checking the password entered, and confirmation pass are equal
        return mPassword.equals(mPasswordConfirm);
    }

    public  boolean validateForm(){
        return isValidEmail() && isValidPassword() && isValidUserName() && isConfirmed();
    }

    public String hashPassword(){
        //TODO Complete hashing of password
        return "";
    }

}
