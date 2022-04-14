package com.example.inf1030_tp1.Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Entity
public class Message {
    @NonNull
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String conversationId;
    private String content;
    private String senderId;


    public Message(String content, String senderId, String conversationId) {
        this.content = content;
        this.senderId = senderId;
        this.conversationId = conversationId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
