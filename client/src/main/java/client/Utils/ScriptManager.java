package client.Utils;

import java.util.Stack;

public class ScriptManager {
    Stack<String> scriptStack;

    public ScriptManager() {
        this.scriptStack = new Stack<>();
    }

    public void addScript(String filePath) {
        scriptStack.push(filePath);
    }

    public void removeScript() {
        if (!scriptStack.isEmpty()) {
            scriptStack.pop();
        }
    }

    public boolean isScriptInStack(String fileName) {
        return scriptStack.contains(fileName);
    }

}
