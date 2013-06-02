package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.actions;

import org.joda.time.DateTime;

public abstract class Action {

    private ActionType action;
    private Long itemId;
    private String time;

    protected Action(ActionType action, Long itemId, DateTime time) {
        this.action = action;
        this.itemId = itemId;
        this.time = String.valueOf(time.getMillis()/100L);
    }

    public ActionType getAction() {
        return action;
    }
}
