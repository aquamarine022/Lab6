package client.Utils;

import client.Commands.*;
import client.Network.ClientManager;
import common.Utility.Commands;
import common.Utility.Console;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
public class Runner {
    private final Console console;
    private final ClientManager clientManager;
    private final Map<String, Command> commands;
    private final ScriptManager scriptManager;
    private String scriptFilePath;

    public Runner(Console console, ClientManager clientManager, ScriptManager scriptManager) {
        this.console = console;
        this.clientManager = clientManager;
        this.scriptManager = scriptManager;
        this.commands = new HashMap<>(){{
            put(Commands.ADD.getName(), new AddCommand(console,clientManager));
            put(Commands.ADD_IF_MAX.getName(), new AddIfMaxCommand(console,clientManager));
            put(Commands.ADD_IF_MIN.getName(), new AddIfMinCommand(console,clientManager));
            put(Commands.CLEAR.getName(), new ClearCommand(console,clientManager));
            put(Commands.EXECUTE_SCRIPT.getName(), new ExecuteScriptCommand(console));
            put(Commands.HELP.getName(), new HelpCommand(console,clientManager));
            put(Commands.REMOVE_HEAD.getName(), new RemoveHeadCommand(console,clientManager));
            put(Commands.SHOW.getName(), new ShowCommand(console, clientManager));
            put(Commands.UPDATE_BY_ID.getName(), new UpdateByIdCommand(console,clientManager));
        }};
    }

    public Map<String, Command> getCommands(){
        return commands;
    }

    public Command getCommand(String commandName){
        return commands.get(commandName);
    }

    public void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        console.setScanner(scanner);
        Input.setUserScanner(scanner);
        String input;


        while (true) {
            input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                break;
            } else if (input.startsWith("execute_script")) {
                String fileName = null;
                String[] args;
                args = input.split(" ", 2);
                if (args.length !=2){
                    console.printError("Неверное кол-во аргументов");
                }else {
                    fileName = args[1];
                    File file = new File(fileName);
                    try {
                        fileName = file.getCanonicalPath();
                    } catch (IOException e) {
                        console.printError("Не удалось получить абсолютный путь к файлу.");
                        return;
                    }
                    scriptManager.addScript(fileName);
                    fileMode(fileName);
                    scriptManager.removeScript();
                }
            } else {
                executeCommand(input.split(" "));
            }
        }
    }


    public void fileMode(String fileName) {
        boolean previousFileMode = Input.isFileMode();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            Scanner previousScanner = Input.getUserScanner();
            Input.setUserScanner(fileScanner);
            Input.setFileMode(true);

            while (fileScanner.hasNextLine()) {
                String commandLine = fileScanner.nextLine().trim();
                String[] commandAndArgs = commandLine.split("\\s+", 2);
                String commandName = commandAndArgs[0];
                String[] commandArgs = commandAndArgs.length > 1 ? commandAndArgs[1].split("\\s+") : new String[0];
                if (commandName.equals("execute_script")) {
                    String scriptPath = commandArgs[0];
                    File file = new File(scriptPath);
                    try {
                        scriptPath = file.getCanonicalPath();
                    } catch (IOException e) {
                        console.printError("Не удалось получить абсолютный путь к файлу.");
                        return;
                    }
                    if (!scriptManager.isScriptInStack(scriptPath)) {
                        scriptManager.addScript(scriptPath);
                        fileMode(scriptPath);
                        scriptManager.removeScript();
                    } else {
                        console.printError("Обнаружено зацикливание. Файл скрипта \"" + scriptPath + "\" уже исполняется. Выполнение будет пропущено.");
                    }
                } else {
                    executeCommand(commandLine.split(" "));
                }
            }
            Input.setUserScanner(previousScanner);
        } catch (FileNotFoundException e) {
            console.printError("Файл не найден: " + fileName);
        } finally {
            Input.setFileMode(previousFileMode);
        }
    }

    public void executeCommand(String[] commandAndArgs) {
        String commandName = commandAndArgs[0];
        String[] commandArgs = commandAndArgs.length > 1 ? Arrays.copyOfRange(commandAndArgs, 1, commandAndArgs.length) : new String[0];

        Command command = getCommand(commandName);
        if (command != null) {
            command.execute(commandArgs);
        } else {
            console.printError("Неизвестная команда: " + commandName);
            console.printLn("");
        }
    }

}
