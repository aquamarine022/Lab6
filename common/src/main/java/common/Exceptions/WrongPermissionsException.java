package common.Exceptions;

import java.io.FileNotFoundException;

/**
 * signals that file has wrong permissions
 */
public class WrongPermissionsException extends FileNotFoundException {

    public WrongPermissionsException(String message){
        super(message);
    }
}
