package com.jdk.handson.design.patterns.builder;

public class UserDetails {
    private int userId;
    private String userName;
    private String email;
    private String city;
    private String state;
    private String zip;
    private String phone;

    private UserDetails(UserBuilder userBuilder) {
        this.userId = userBuilder.userId;
        this.userName = userBuilder.userName;
        this.email = userBuilder.email;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "UserDetails{" + "userId=" + userId + ", userName='" + userName + '\'' + ", email='" + email + '\'' + '}';
    }

    static class UserBuilder {

        private int userId;
        private String userName;
        private String email;

        public UserBuilder() {
        }
  // return type of every seeter will be UserBuilder type (inner class type) for metod chaining
        public UserBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDetails build() {
            final UserDetails userDetails = new UserDetails(this);  // this is passed in outer class contrctor
              // here this is nothing but UserBuilder class object
            return userDetails;
        }

    }
}
