package exercice.payment.exception;

public class NegativeValueException extends Exception{
    public NegativeValueException(){
        super("The number is negative");
    }
}
