package com.nashss.se.picturegram.Activity.Results;

import com.nashss.se.picturegram.Models.ImageModel;

public class GetImageResult {
     private final ImageModel imageModel;

     private GetImageResult(ImageModel imageModel) {
         this.imageModel = imageModel;
     }

     public ImageModel getImageModel() {
         return imageModel;
     }

    @Override
    public String toString() {
        return "GetImageResult{" +
                "imageModel=" + imageModel +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
         return new Builder();
    }

    public static class Builder {
         private ImageModel imageModel;

         public Builder withImage(ImageModel imageModel) {
             this.imageModel = imageModel;
             return this;
         }

         public GetImageResult build() {
             return new GetImageResult(imageModel);
         }
    }
}
