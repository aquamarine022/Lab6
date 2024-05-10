package common.Utility;

public enum Commands {
    ADD("add"),
    ADD_IF_MAX("add_if_max"),
    ADD_IF_MIN("add_if_min"),
    CLEAR("clear"),
    EXECUTE_SCRIPT("execute_script"),
    EXIT("exit"),
    FILTER_STARTS_WITH_NAME("filter_starts_with_name"),
    HELP("help"),
    INFO("info"),
    MIN_BY_NAME("min_by_name"),
    REMOVE_ANY_BY_ENGINE_POWER("remove_any_by_engine_power"),
    REMOVE_BY_ID("remove_by_id"),
    REMOVE_HEAD("remove_head"),
    SAVE("save"),
    SHOW("show"),
    UPDATE_BY_ID("update_by_id");

    private String name;
    public String getName(){
        return name;
    }

    Commands(String name){
        this.name = name;
    }
}
