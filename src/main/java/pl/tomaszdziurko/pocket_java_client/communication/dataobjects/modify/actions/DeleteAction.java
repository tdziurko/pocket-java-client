package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.actions;

import org.joda.time.DateTime;

public class DeleteAction extends Action {

    public DeleteAction(Long itemId, DateTime time) {
        super(ActionType.DELETE, itemId, time);
    }

}
