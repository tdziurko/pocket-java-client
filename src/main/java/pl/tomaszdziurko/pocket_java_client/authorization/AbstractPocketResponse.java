package pl.tomaszdziurko.pocket_java_client.authorization;

import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;

public abstract class AbstractPocketResponse {

    private ResponseStatus responseStatus = ResponseStatus.OK; // default value for valid responses

    protected AbstractPocketResponse() {
    }

    public AbstractPocketResponse(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }
}
