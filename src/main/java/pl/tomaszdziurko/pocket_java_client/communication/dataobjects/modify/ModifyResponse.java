package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify;

import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketResponse;

public class ModifyResponse extends AbstractPocketResponse {

    public ModifyResponse(ResponseStatus status) {
        super(status);
    }
}
