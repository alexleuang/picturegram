package com.nashss.se.picturegram.lambda;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.amazonaws.services.lambda.runtime.RequestHandler;
//import com.nashss.se.picturegram.activity.Request.DeleteImageRequest;
//import com.nashss.se.picturegram.activity.Results.DeleteImageResult;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class DeleteImageLambda extends LambdaActivityRunner<DeleteImageRequest, DeleteImageResult>
//    implements RequestHandler<LambdaRequest<DeleteImageRequest>, LambdaResponse> {
//
//    private final Logger log = LogManager.getLogger();
//
//    @Override
//    public LambdaResponse handleRequest(LambdaRequest<DeleteImageRequest> input, Context context) {
//        log.info("handleRequest");
//
//        return super.runActivity(
//                () -> input.fromPath(path ->
//                        DeleteImageRequest.builder()
//                                .withImageUrl(path.get("Image"))
//                                .build()),
//                (request, serviceComponent) ->
//                        serviceComponent.provideDeleteImage().handleRequest(request)
//        );
//    }
//}
