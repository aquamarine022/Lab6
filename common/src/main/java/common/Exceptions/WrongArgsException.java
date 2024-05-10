package common.Exceptions;

public class WrongArgsException extends IllegalArgumentException{
    private final int expectedArgs;

    private final int givenArgs;

    String message;

    public WrongArgsException(String message, int expectedArgs, int givenArgs){
        super(message);
        this.expectedArgs = expectedArgs;
        this.givenArgs = givenArgs;
        this.message = message;
    }

    @Override
    public String getMessage(){
        return  String.format("%s Expected %d, got %d", message, expectedArgs, givenArgs);
    }
}
