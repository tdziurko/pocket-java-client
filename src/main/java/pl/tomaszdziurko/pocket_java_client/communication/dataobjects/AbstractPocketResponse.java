package pl.tomaszdziurko.pocket_java_client.communication.dataobjects;

import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;

public class AbstractPocketResponse {

    private int status;

    public AbstractPocketResponse() {
    }

    public AbstractPocketResponse(ResponseStatus status) {
        this.status = status.getCode();
    }

    public ResponseStatus getStatus() {
        return ResponseStatus.findByCode(status);
    }
}
