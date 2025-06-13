package com.jdk.handson.design.patterns.solidprinciple.lsp.problem;

public interface SocialMedia {

    // @Supported by WhatsAPP, Facebook
    public void groupVideoCall(String ... friends);


    // @Supported by WhatsAPP, Facebook, Instagram
    public void sendPhotoAndVideos(String friends);

    // @Supported by WhatsAPP, Facebook, Instagram
    public void chatWithFriends(String friend);

    // @Supported by Facebook, Instagram
    public void publishPost(Object obj);

}
