package ilo.ilo;



public class LogInHelper {
    private String mUsername;
    private String mPassword;
    private boolean mAutheticated;

    public LogInHelper(String user, String password){
        this.mUsername = user;
        this.mPassword = password;
    }

    public boolean isValidUser(){
        /*
            Check to make sure the email exist and is a valid email
         */
        boolean inDatabase = false;
        //TODO Come up with check for valid username
        boolean validUser = mUsername.matches("/^([A-Za-z0-9_\\-\\.\\'\\+])+([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,6})$/");

        if(validUser){
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
