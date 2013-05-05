package pl.tomaszdziurko.pocket_java_client.communication.dataobjects.add;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.tomaszdziurko.pocket_java_client.communication.ResponseStatus;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.AbstractPocketResponse;

public class AddItemResponse extends AbstractPocketResponse {

    private AddedItem item;

    public AddItemResponse(ResponseStatus status) {
        super(status);
    }

    public AddedItem getItem() {
        return item;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
