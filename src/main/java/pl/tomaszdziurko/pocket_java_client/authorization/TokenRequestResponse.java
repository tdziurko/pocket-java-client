package pl.tomaszdziurko.pocket_java_client.authorization;

import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;

public class TokenRequestResponse extends AbstractPocketResponse {

    private String code;
    private String state;

    public TokenRequestResponse() {
    }

    public TokenRequestResponse(ResponseStatus status) {
        super(status);
    }

    public String getCode() {
        return code;
    }

    public String getState() {
        return state;
    }
}
