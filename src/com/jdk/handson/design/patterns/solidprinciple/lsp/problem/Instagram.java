package com.jdk.handson.design.patterns.solidprinciple.lsp.problem;

public class Instagram implements SocialMedia {

    /*
    As per Loskev substitution principle , a subclass should be substituted of its parent without making any change.
    but here if you see , Instagram is having the feature of  publishPost ,sendPhotoAndVideos and chatWithFriends.
     But whatsApp does not have any feature of groupVideoCall . so that means Instagram is not the substitute of its parent
     called SocialMedia. so to overcome this issue , we have to create/break an interface / abstract class in such a way
     that its can follow Loskev subs. principle. Please refer org.solid.principle.lsp.solution package.
     */
    @Override
    public void groupVideoCall(String... friends) {
     // don't support this functionality as of now
    }

    @Override
    public void sendPhotoAndVideos(String friends) {

    }

    @Override
    public void chatWithFriends(String friend) {

    }

    @Override
    public void publishPost(Object obj) {

    }
}
