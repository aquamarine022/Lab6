package common.Network.Request;

import common.Utility.Commands;

public class FilterStartsWithNameCommandRequest extends Request {
    private final String name;

    public FilterStartsWithNameCommandRequest(String name) {
        super(Commands.FILTER_STARTS_WITH_NAME.getName());
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
