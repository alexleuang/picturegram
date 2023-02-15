package com.nashss.se.picturegram.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.nashss.se.picturegram.activity.Request.CreateImageRequest;
import com.nashss.se.picturegram.activity.Results.CreateImageResult;

public class CreateImageLambda extends LambdaActivityRunner<CreateImageRequest, CreateImageResult>
    implements RequestHandler<AuthenticatedLambdaRequest<CreateImageRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(AuthenticatedLambdaRequest<CreateImageRequest> input, Context context) {
        return super.runActivity(
                () -> {
                    CreateImageRequest unauthenticatedRequest = input.fromBody(CreateImageRequest.class);
                    return input.fromUserClaims(claims ->
                            CreateImageRequest.builder()
                                    .withImageUrl(unauthenticatedRequest.getImageUrl())
                                    .withCaption(unauthenticatedRequest.getCaption())
                                    .withDateTime(unauthenticatedRequest.getDateTime())
                                    .withOwnerName(claims.get("owner_Name"))
                                    .withOwnerEmail(claims.get("owner_email"))
                                    .build());
                    },
                (request, serviceComponent) -> serviceComponent.provideCreateImageActivity().handleRequest(request));
    }
}
