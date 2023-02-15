package com.nashss.se.picturegram.activity.Results;

import com.nashss.se.picturegram.Models.ImageModel;

public class GetImageResult {
     private final ImageModel image;

     private GetImageResult(ImageModel image) {
         this.image = image;
     }

     public ImageModel getImage() { return image; }

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
         private ImageModel image;

         public Builder withImage(ImageModel image) {
             this.image = image;
             return this;
         }

         public GetImageResult build() {
             return new GetImageResult(image);
         }
    }
}
