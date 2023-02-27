package com.nashss.se.picturegram.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.picturegram.activity.Request.GetImageRequest;
import com.nashss.se.picturegram.activity.Results.GetImageResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetImageLambda  extends LambdaActivityRunner<GetImageRequest, GetImageResult>
    implements RequestHandler<LambdaRequest<GetImageRequest>, LambdaResponse> {

    private final Logger log = LogManager.getLogger();

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetImageRequest> input, Context context) {
        log.info("handleRequest");

        return super.runActivity(
                () -> input.fromPath(path ->
                        GetImageRequest.builder()
                                .withOwnerEmail(path.get("ownerEmail"))
                                .build()),
                (request, serviceComponent) ->
                        serviceComponent.provideGetImageActivity().handleRequest(request)
        );
    }
}
