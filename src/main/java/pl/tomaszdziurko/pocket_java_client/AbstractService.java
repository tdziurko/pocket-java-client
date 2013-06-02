package pl.tomaszdziurko.pocket_java_client;

import com.google.gson.Gson;
import pl.tomaszdziurko.pocket_java_client.communication.RequestSender;
import pl.tomaszdziurko.pocket_java_client.communication.gson.GsonProducer;

class AbstractService {
    protected Pocket pocket;
    protected Gson gson;
    protected RequestSender requestSender;

    public AbstractService(Pocket pocket) {
        gson = GsonProducer.create();
        this.pocket = pocket;
        requestSender = new RequestSender();
    }
}
