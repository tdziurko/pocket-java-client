package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify;

import com.google.common.collect.Lists;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketRequest;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.actions.Action;

import java.util.List;

public class ModifyRequest extends AbstractPocketRequest {

    private List<Action> actions = Lists.newArrayList();

    public ModifyRequest(String consumerKey, String accessToken, Action action) {
        super(consumerKey, accessToken);
        actions.add(action);
    }

    public ModifyRequest withAction(Action action) {
        actions.add(action);
        return this;
    }
}
