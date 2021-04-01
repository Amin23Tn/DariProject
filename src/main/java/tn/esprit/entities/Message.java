package tn.esprit.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long MessageId;
    String content;
    @ManyToOne
    User userSender;
    @ManyToOne
    User userReceiver;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public long getMessageId() {
        return MessageId;
    }

    public void setMessageId(long messageId) {
        MessageId = messageId;
    }

    public User getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(User userReceiver) {
        this.userReceiver = userReceiver;
    }
    public Message(){}
    public Message(String content, User userSender, User userReceiver) {
        this.content = content;
        this.userSender = userSender;
        this.userReceiver = userReceiver;
    }
}
