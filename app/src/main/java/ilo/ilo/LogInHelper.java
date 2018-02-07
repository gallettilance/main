package ilo.ilo;



public class LogInHelper {
    private String mEmail;
    private String mPassword;
    private boolean mAutheticated;

    public LogInHelper(String email, String password){
        this.mEmail = email;
        this.mPassword = password;
    }

    public boolean isValidEmail(){
        /*
            Check to make sure the email exist and is a valid email
         */
        boolean inDatabase = false;
        boolean validEmail = mEmail.matches("/^([A-Za-z0-9_\\-\\.\\'\\+])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,6})$/");

        if(validEmail){
            //TODO - call to make sure it is in database
            return inDatabase;
        }
        return false;
    }

    public boolean isValidPassword(){
        /*
            Check to make sure hashed version of the
         */
        return false;
    }

    public void authenticate(){

    }
}
