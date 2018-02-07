package ilo.ilo;


public class SignUpHelper {

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mUserName;
    private String mPassword;
    private String mPasswordConfirm;
    private String mDob;

    public SignUpHelper(String email, String user, String pass, String confirmPassword, String dob, String first, String last){
        this.mFirstName = first;
        this.mLastName = last;
        this.mEmail = email;
        this.mPassword = pass;
        this.mUserName = user;
        this.mPasswordConfirm = confirmPassword;
        this.mDob = dob;
    }
    private boolean isValidEmail(){
        //check for valid email address
        return mEmail.matches("/^([A-Za-z0-9_\\-\\.\\'\\+])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,6})$/");
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

    private boolean isValidDob(){
        return false;
    }

    public  boolean validateForm(){
        return isValidEmail() && isValidPassword() && isValidUserName() && isConfirmed();
    }

    public String hashPassword(){
        //TODO Complete hashing of password
        return "";
    }


}
