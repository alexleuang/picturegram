# Design Document

## Pictogram

## 1. Problem Statement
Pictogram is an app that will allow the user to create, edit and post images of there work. Allowing other photographers to 
rate the posting. 

## 2. Top Questions to Resolve in Review
1. Who will being using this?
2. What's the purpose of this app being made?
3. What makes this different from Instagram?
4. How will users interact with other posting?
5. How will this benefit photographers/users?

## 3. Use Cases
The main navigation will be a bottom tab bar, with tabs for "Home," "Explore," "Upload," "Profile."

U1. The "Home" tab will display a feed of images.

U3. The "Upload" tab will allow users to take a photo from their camera roll and  captions before sharing it.

U4. The "Profile" tab will display the user's own profile, which will show the images that the user uploaded.

U5. Users will be able to create an account. (Sign up)

U6. Users will be able to upload images.

U7. Users of the image will be able to delete their images.

U8. Users of the image will be able to sort images by Date and time.

U9. Users of the image will be able to add captions to the images.

U10. Users of the image and other users will be able to comment on each other post.

U11. Both users will be able to edit their own comments on the image/post.

U12. Users of the image will be able to delete comments on their posting and so will other users.

## 3.1 Stretch Goals
1. The "Explore" tab will allow users to browse and discover new content by hashtags, location, and user.
2. The "Home" tab will display a feed of videos from users that the current user is following.
3. The "Upload" tab will allow users to take a video or select one from their camera roll and add various filters, tags, and captions before sharing it.
4. The "Profile" tab will display the user's own profile which will display followers and following.

## 4. Project Scope
## 4.1. In Scope
* Users can signup.
* Upload images.
* Delete images.
* Adding captions.
* Commenting on other users posts.
* Deleting comments.


## 4.2. Out of Scope
* Users can follow other users.
* Users can edit their images. (cropping, adjusting contrast, brightness, etc.)
* Users can receive notifications for new followers, likes and comments on their post.
* Manage settings.
* Like on other users posts.

## 5. Architecture Overview
Pages:
* Home: Login/Create account, refresh page.
* Explore: See other users postings, refresh page.
* Upload: Allows users to upload images to the application.
* Profile: Allows users to see their uploads, profile picture, bio, etc.

Tables:
```
  Image Table
  --------------------------------
  ownerEmail:String, partition key
  ownerName:String
  imageUrl:String
  dateTime:LocalDateTime, sort Key
  caption:String
```
```
  Comments Table
  --------------------------------
  imageUrl:String, partition key
  commenterEmail:String
  commenterName:String
  dateTime:LocalDateTime, sort key
  comment:String
```
## 6. API
## 6.1. Public Models
```
// Image Model
String imageId; HashKey
String imageUrl;
LocalDateTime dateTime; SortKey
String caption;
```
``` 
// Comments Model
String commentId; HashKey
String userEmail; 
String userId;
LocalDateTime dateTime; SortKey
String comment;
```
## 6.1. CreateImage
* Accepts `POST` requests to `/image`.
* Creates a uniqueID for that upload.
* Returns the corresponding upload with that uniqueID.
## 6.2. GetImage
* Accepts `GET` requests to `/image/ID`.
* Returns upload with that uniqueID.
## 6.3. DeleteImage
* Accepts `DELETE` requests to `/image/ID`.
* Deletes the upload by the uniqueID.
## 6.4. CreateComments
* Accepts `POST` requests to `/userImage/ID/Comments`.
* Creates a comment for that upload.
* Returns the comment for that uploadID.
## 6.5. GetComments
* Accepts `GET` requests to `/userImage/ID/Comments`.
* Return comments for that upload
## 6.6. DeleteComments
* Accepts `DELETE` requests to `/userImage/ID/Comments`.
* Delete comments for that upload.

