package com.jdk.handson.design.patterns.solidprinciple.lsp.problem;

public class WhatAppService implements SocialMedia {

    /*
    As per Loskev substitution principle , a subclass should be substituted of its parent without making any change.
    but here if you see , whatsApp is having the feature of groupVideoCall , sendPhotoAndVideos and chatWithFriends.
     But whatsApp does not have any feature of publishPost . so that means whatApp is not the substitute of its parent
     called SocialMedia.so to overcome this issue , we have to create/break an interface / abstract class in such a way
     that its can follow Loskev subs. principle. Please refer org.solid.principle.lsp.solution package.

     */

    @Override
    public void groupVideoCall(String... friends) {

    }

    @Override
    public void sendPhotoAndVideos(String friends) {

    }

    @Override
    public void chatWithFriends(String friend) {

    }

    @Override
    public void publishPost(Object obj) {
  // not supported by whatApp as of now.
    }
}
