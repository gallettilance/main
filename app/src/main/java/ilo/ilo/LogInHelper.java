package ilo.ilo;



public class LogInHelper {
    private String mUsername;
    private String mPassword;
    private boolean mAuthenticated;

    public LogInHelper(String user, String password){
        this.mUsername = user;
        this.mPassword = password;
    }

    public boolean isValidUser(){
        // Check if user input is a valid email
        // Source:
        // https://stackoverflow.com/questions/8204680/java-regex-email

        String pattern = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
        boolean validUser = mUsername.matches(pattern);

        // Check if email in DB

        boolean inDatabase = false;

        if(validUser){
            //TODO - call to make sure it is in database
            return inDatabase;
        }
        return false;
    }

    public boolean isValidPassword(){
        /*
            TODO:
            1) Check password length
            2) if length >8 and < 40:
                Check to make sure hashed version of the
                password matches the value stored in DB
        */
        return false;
    }

    public void authenticate(){

    }
}
