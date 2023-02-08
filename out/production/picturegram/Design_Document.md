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

U1. The "Home" tab will display a feed of images and videos from users that the current user is following.

U2. The "Explore" tab will allow users to browse and discover new content by hashtags, location, and user.

U3. The "Upload" tab will allow users to take a photo or video or select one from their camera roll and add various filters, tags, and captions before sharing it.

U4. The "Profile" tab will display the user's own profile, including their posts, followers, and following.

U5. Users will be able to create an account. (Sign up)

U6. Users will be able to upload images.

U7. Users will be able to add captions to the images.

U8. Users will be able to like other users post.

U8. Users will be able to commenting on other users post.

U9. Users will be able to delete comments on their posting.

U10. Users will be able to delete their images.

## 4. Project Scope
## 4.1. In Scope
* Users can signup.
* Upload images.
* Adding captions.
* Like on other users posts.
* Commenting on other users posts.
* Delete images.

## 4.2. Out of Scope
* Users can follow other users.
* Users can edit their images. (cropping, adjusting contrast, brightness, etc.)
* Users can receive notifications for new followers, likes and comments on their post.
* Manage settings.

## 5. Architecture Overview
Pages:
* Home: Login/Create account, refresh page.
* Explore: See other users postings, refresh page.
* Upload: Allows users to upload images to the application.
* Profile: Allows users to see their uploads, profile picture, bio, etc.

Tables: 
```
  User Table
  --------------------------------
  userId:String, partition key 
  userName:String
  password:String
```

```
  Upload Table
  --------------------------------
  uploadId:String, partition key
  date:LocalDate, sort key
  comments:String
  captions:String
```
## 6. API
## 6.1. Public Models
```
// Image Model
String uploadId; HashKey
String comments;
String captions;
LocalDate date; SortKey
```
``` 
// User Model
String userId; HashKey
String userName; SortKey
String passWord;
```
## 6.1.1 CreateUser
* Accepts `POST` requests to `/user`.
* Creates a new User with a uniqueID.
* Returns the corresponding user with the uniqueID.
## 6.2. GetUser
* Accepts `GET` requests to `/user/ID`.
* Returns the corresponding userID.
## 6.3. CreateUpload
* Accepts `POST` requests to `/upload`.
* Creates a uniqueID for that upload.
* Returns the corresponding upload with that uniqueID.
## 6.4. GetUpload
* Accepts `GET` requests to `/upload/ID`.
* Returns upload with that uniqueID.
## 6.5. DeleteUpload
* Accepts `DELETE` requests to `/upload/ID`.
* Deletes the upload by the uniqueID.
## 6.6. CreateComments
* Accepts `POST` requests to `/upload/ID/Comments`.
* Creates a comment for that upload.
* Returns the comment for that uploadID.
## 6.7. GetComments
* Accepts `GET` requests to `/upload/ID/Comments`.
* Return comments for that upload
## 6.8. UpdateComments
* Accepts `PUT` requests to `/upload/ID/Comments`.
* Update comments for that upload.
* Returns the updated comments.
## 6.9. DeleteComments
* Accepts `DELETE` requests to `/upload/ID/Comments`.
* Delete comments for that upload.
## 6.10. CreateCaption
* Accepts `POST` requests to `/upload/ID/Caption`.
* Create a caption for that uploadID.
* Return captions for that uploadID.

