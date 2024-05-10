package common.Network.Response;

import common.Utility.Commands;

public class InfoResponse extends Response{
    private final String infoMessage;

    public InfoResponse(String infoMessage, String error) {
        super(Commands.INFO.getName(), error);
        this.infoMessage = infoMessage;
    }

    public String getInfoMessage() {
        return infoMessage;
    }
}
