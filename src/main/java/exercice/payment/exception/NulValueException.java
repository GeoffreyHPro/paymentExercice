package exercice.payment.exception;

public class NulValueException extends Exception{
    public NulValueException(){
        super("The value is nul");
    }
}
