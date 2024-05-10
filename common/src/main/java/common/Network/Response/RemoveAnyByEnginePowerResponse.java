package common.Network.Response;

import common.Utility.Commands;

public class RemoveAnyByEnginePowerResponse extends Response{
    public RemoveAnyByEnginePowerResponse(String error) {
        super(Commands.REMOVE_ANY_BY_ENGINE_POWER.getName(), error);
    }
}
