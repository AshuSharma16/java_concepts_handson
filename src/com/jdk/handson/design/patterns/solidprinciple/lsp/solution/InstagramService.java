package com.jdk.handson.design.patterns.solidprinciple.lsp.solution;

public class InstagramService implements SocialMedia, PublishPostMediaManager {

    /*
    Here InstagramService is the replacement of SocialMedia and PublishPostMediaManager
     */

    public void groupVideoCall(String... friends) {

    }

    @Override
    public void chatWithFriend(String... friends) {

    }

    @Override
    public void sendPhotoAndVideos(String friends) {

    }


    public void chatWithFriends(String friend) {

    }

    @Override
    public void publishPost(Object obj) {

    }
}
