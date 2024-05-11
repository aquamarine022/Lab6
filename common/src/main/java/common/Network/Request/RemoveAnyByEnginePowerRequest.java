package common.Network.Request;

import common.Utility.Commands;

public class RemoveAnyByEnginePowerRequest extends Request {
    private final int enginePower;
    public RemoveAnyByEnginePowerRequest(int enginePower) {
        super(Commands.REMOVE_ANY_BY_ENGINE_POWER.getName());
        this.enginePower = enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }
}
