/**
 * exception handling when looking for invalid records
 */
public class RecordNotFoundException extends Exception{

    public RecordNotFoundException(String object){

        super("The " + object + " Record is not found!");
    }


}
