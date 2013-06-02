package pl.tomaszdziurko.pocket_java_client;

import com.google.common.base.Preconditions;
import org.joda.time.DateTime;
import pl.tomaszdziurko.pocket_java_client.communication.RawJsonResponse;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.ModifyRequest;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.ModifyResponse;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.actions.Action;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.actions.ArchiveAction;
import pl.tomaszdziurko.pocket_java_client.communication.dataobjects.modify.actions.DeleteAction;

public class ModifyService extends AbstractService {

    public ModifyService(Pocket pocket) {
        super(pocket);
    }

    public ModifyResponse archiveArticle(Long articleId) {
        Preconditions.checkArgument(articleId != null, "ArticleId value can not be null");
        Action archive = new ArchiveAction(articleId, DateTime.now());
        return sendModifyRequest(archive);
    }

    public ModifyResponse deleteArticle(Long articleId) {
        Preconditions.checkArgument(articleId != null, "ArticleId value can not be null");
        Action archive = new DeleteAction(articleId, DateTime.now());
        return sendModifyRequest(archive);
    }

    private ModifyResponse sendModifyRequest(Action archive) {
        ModifyRequest request = new ModifyRequest(pocket.getConsumerKey(),pocket.getAccessToken(), archive);

        RawJsonResponse rawJsonResponse = requestSender.sendRequest(request, "https://getpocket.com/v3/send");

        if (rawJsonResponse.statusIsOk()) {
            String json = rawJsonResponse.getResponse().get();
            System.out.println("response = " + json);
            return new ModifyResponse(rawJsonResponse.getStatus());
        } else {
            return new ModifyResponse(rawJsonResponse.getStatus());
        }
    }

}
