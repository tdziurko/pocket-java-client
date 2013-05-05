package pl.tomaszdziurko.pocket_java_client.authorization;

import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;

import static pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus.OK;

public abstract class AbstractAuthorizationResponse {

    private ResponseStatus responseStatus = OK; // default value for valid responses

    protected AbstractAuthorizationResponse() {
    }

    public AbstractAuthorizationResponse(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public boolean isOk() {
        return OK == responseStatus;
    }
}
