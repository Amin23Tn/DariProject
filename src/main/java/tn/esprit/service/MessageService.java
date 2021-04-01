package tn.esprit.service;

import org.springframework.stereotype.Service;
import tn.esprit.entities.Message;
import tn.esprit.entities.User;

import java.util.List;

@Service
public interface MessageService {
    List<Message> findMessagesByUserSenderAndUserReceiver(User user1, User user2);
    Message addMessage(Message message);
}
