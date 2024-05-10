package server.Commands;

import common.Network.Request.Request;
import common.Network.Response.Response;

public interface ICommand {
   Response execute(Request request);

}
