package client.Commands;

import common.Exceptions.WrongArgsException;
import common.Utility.Console;

public class ExecuteScriptCommand extends Command{

    private final Console console;
    public ExecuteScriptCommand(Console console) {
        super("execute_script", "считать и исполнить скрипт из файла");
        this.console = console;
    }

    @Override
    public boolean validateArgs(String[] args) {
        return args.length == 1;
    }

    @Override
    public void execute(String[] args) {
        if(!validateArgs(args)){
            console.printError("У команды " + getName() + " не должно быть аргументов.");
            }
        }
    }



