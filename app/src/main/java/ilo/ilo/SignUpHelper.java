package ilo.ilo;


import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class SignUpHelper {

    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mUserName;
    private String mPassword;
    private String mPasswordConfirm;
    private String mDob;
    private SimpleDateFormat mSdf = new SimpleDateFormat("dd/MM/yyyy");

    public SignUpHelper(String email, String user, String pass, String confirmPassword, String dob, String first, String last){
        this.mFirstName = first;
        this.mLastName = last;
        this.mEmail = email;
        this.mPassword = pass;
        this.mUserName = user;
        this.mPasswordConfirm = confirmPassword;
        this.mDob = dob;
    }

    private boolean isValidFirstName(){
        // simple check to make sure username is valid
        boolean validLength = mFirstName.length()  >= 2 && mFirstName.length() <= 40;

        return validLength;
    }

    private boolean isValidLastName() {
        // simple check to make sure username is valid
        boolean validLength = mLastName.length() >= 2 && mLastName.length() <= 40;

        return validLength;
    }

    private boolean isValidEmail(){
        //check for valid email address
        String pattern = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
        boolean validEmail = mEmail.matches(pattern);
        boolean validLength = mEmail.length() > 6 && mEmail.length() <= 40;

        return validEmail && validLength;
    }


    private boolean isValidUserName(){
        // simple check to make sure username is valid
        boolean validLength = mUserName.length()  > 5 && mUserName.length() <= 40;

        return validLength;
    }

    private  boolean isValidPassword(){
        // simple check for password length
        boolean validLength = mPassword.length() > 8 && mPassword.length() <= 40;

        return validLength;
    }

    private boolean isConfirmed(){
        //Checking the password entered, and confirmation pass are equal
        return mPassword.equals(mPasswordConfirm);
    }

    private boolean isValidDob(){

        //attempts to create a Date object representing the date of birth
        Date after = new Date(1900, 1, 1);
        try {
            //if the input is a valid date, make sure it comes before current time
            Date dateOfBirth = mSdf.parse(mDob);
            boolean beforeDob = dateOfBirth.before(Calendar.getInstance().getTime());
            boolean afterDob = dateOfBirth.after(after);
            return beforeDob && afterDob;
        }catch(ParseException e){
            //else say it's invalid
            return false;
        }
    }

    public  boolean isValidateForm(){
        // TODO: figure out an efficient ordering of these checks
        // TODO: see if can execute checks in parallel
        return isValidFirstName() && isValidLastName() && isValidEmail()
                && isValidPassword() && isValidUserName()
                && isConfirmed();
    }

    //
    // below are functions to be called
    // after isValidForm() returns true

    public String hashPassword(){
        //TODO Learn more about hashing
        String hashedPass = ""+mPassword.hashCode();
        return hashedPass;
    }

    public boolean register(){
        if(true){
            try {
                new HttpPOSTRequest().execute("https://gai-database.herokuapp.com/users/", mFirstName, mLastName, mEmail, mPassword, mDob).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return true;
        }

        return false;
    }

    public boolean userExists(){
        //TODO: Using GET request to see if a certain email address returns a valid query
        return false;
    }

    public String getFirstName(){
        return  mFirstName;
    }

    public String getLastName(){
        return  mLastName;
    }

    public String getEmail(){
        return  mEmail;
    }

    public String getDob(){
        return mDob;
    }

    public String getPassword(){
        return mPassword;
    }

    public String getPasswordConfirm(){
        return mPasswordConfirm;
    }

}
