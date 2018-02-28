package ilo.ilo;


import java.util.concurrent.ExecutionException;

public class LogInHelper {
    private String mUsername;
    private String mPassword;
    private boolean mAuthenticated;
    private String result;

    public LogInHelper(String user, String password){
        this.mUsername = user;
        this.mPassword = password;
        try {
            result = new HttpGETRequest().execute("").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public boolean isValidUser(){

        String pattern = "\"^[A-Z0-9._%+-]$\"";

        return mUsername.matches(pattern);
    }

    public boolean isValidPassword(){
        /*
            TODO:
            1) Check password length
            2) if length >8 and < 40:
                Check to make sure hashed version of the
                password matches the value stored in DB
        */

        return mPassword.length() > 8 && mPassword.length() < 40;
    }

    public boolean isAuthenticated(){
        //TODO: API to get password and compare

        return mAuthenticated && isValidPassword() && isValidUser();
    }
}
