package Activity.Request;

import java.time.LocalDate;

@JsonDeserialize(builder = CreateUploadRequest.Builder.class)
public class CreateUploadRequest {
    private String uploadId;
    private String comments;
    private String captions;
    LocalDate date;

    public CreateUploadRequest(String uploadId, String comments, String captions, LocalDate date) {
        this.uploadId = uploadId;
        this.comments = comments;
        this.captions = captions;
        this.date = date;
    }

    public String getUploadId() {
        return uploadId;
    }

    public String getComments() {
        return comments;
    }

    public String getCaptions() {
        return captions;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CreateUploadRequest{" +
                "uploadId='" + uploadId + '\'' +
                ", comments='" + comments + '\'' +
                ", captions='" + captions + '\'' +
                ", date=" + date +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static CreateUploadRequest.Builder builder() {
        return new CreateUploadRequest.Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String uploadId;
        private String comments;
        private String captions;
        LocalDate date;
    }

    public CreateUploadRequest withUploadId(String uploadId) {
        this.uploadId = uploadId;
        return this;
    }

    public CreateUploadRequest withComments(String comments) {
        this.comments = comments;
        return this;
    }

    public CreateUploadRequest withCaptions(String captions) {
        this.captions = captions;
        return this;
    }
}
