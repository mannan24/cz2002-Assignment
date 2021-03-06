/**
 * Created by danielseetoh on 4/14/2015.
 */

/**
 * Exception class to handle invalid values
 */
public class InvalidValueException extends Exception {

    public InvalidValueException(){
        super("The input value is invalid");
    }

    public InvalidValueException(String object){
        super("The input value is invalid, please enter " + object);
    }
}
