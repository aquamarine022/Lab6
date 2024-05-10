package common;

import common.Exceptions.WrongPermissionsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Loader {
    /**
     * method to load file by its path
     */

    public File loadFile(String filePath, String extension, String permissions, String fileName) throws FileNotFoundException {
        Path path = Paths.get(filePath);
        if(!Files.exists(path)){
            throw new FileNotFoundException(String.format("%s does not exist!", fileName));
        }
        if(Files.isDirectory(path)){
            throw new FileNotFoundException("It is a directory!");
        }
        if(!filePath.endsWith(String.format(".%s", extension))){
            throw new FileNotFoundException(String.format("%s must be .%s!", fileName, extension));
        }
        if(permissions.contains("r") && !Files.isReadable(path)){
            throw new WrongPermissionsException(String.format("Wrong permissions! %s is not readable!", fileName));
        }
        if(permissions.contains("w") && !Files.isWritable(path)){
            throw new WrongPermissionsException(String.format("Wrong permissions! %s is not writeable!", fileName));
        }
        return new File(filePath);
    }
}
