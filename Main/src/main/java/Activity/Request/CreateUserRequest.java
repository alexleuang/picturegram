package Activity.Request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateUserRequest.Builder.class)
public class CreateUserRequest {
    private final String userName;
    private final String passWord;
    private final String userId;
    
    public CreateUserRequest(String userName, String passWord, String userId) {
        this.userName = userName;
        this.passWord = passWord;
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassWord() {
        return passWord;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                "userName=" + userName +
                "password =" + passWord +
                "userId =" + userId;
    }
    
    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String userName;
        private String passWord;
        private String userId;

        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder withPassWord(String passWord) {
            this.passWord = passWord;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }
    }
}
