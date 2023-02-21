package com.nashss.se.picturegram.activity.Results;

import com.nashss.se.picturegram.Models.ImageModel;
import com.nashss.se.picturegram.dynamodb.models.Image;

public class GetImageResult {
     private final ImageModel image;

     private GetImageResult(Image image) {
         this.image = new ImageModel(image.getOwnerEmail(), image.getOwnerName(), image.getImageUrl(),
                 image.getCaption(), image.getDateTime());
     }

     public ImageModel getOwnerEmail() { return image; }

    @Override
    public String toString() {
        return "GetImageResult{" +
                "image=" + image +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
         return new Builder();
    }

    public static class Builder {
         private Image image;

         public Builder withOwnerEmail(Image image) {
             this.image = image;
             return this;
         }

         public GetImageResult build() {
             return new GetImageResult(image);
         }
    }
}
