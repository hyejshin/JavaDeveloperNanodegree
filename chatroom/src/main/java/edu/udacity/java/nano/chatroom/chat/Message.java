package edu.udacity.java.nano.chatroom.chat;

import com.alibaba.fastjson.JSON;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.
    private String type;
    private String username;
    private String content;
    private int onlineCount;

    public Message() {

    }

    public Message(String type, String username, String content, int onlineCount) {

        this.type = type;
        this.username = username;
        this.content = content;
        this.onlineCount = onlineCount;
    }

    public static String jsonConverter(String type, String username, String content, int onlineCount) {
        return JSON.toJSONString(new Message(type, username, content, onlineCount));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }
}