package common.Network.Request;

import common.Utility.Commands;

public class FilterStartsWithNameCommandRequest extends Request {
    private final String filterByName;

    public FilterStartsWithNameCommandRequest(String filterByName) {
        super(Commands.FILTER_STARTS_WITH_NAME.getName());
        this.filterByName = filterByName;
    }

    public String getFilterByName() {
        return filterByName;
    }
}
