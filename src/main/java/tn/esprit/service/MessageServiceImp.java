package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Message;
import tn.esprit.entities.User;
import tn.esprit.repository.MessageRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageServiceImp implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    public List<Message> findMessagesByUserSenderAndUserReceiver(User user1, User user2) {
        List<Message> list1 = this.messageRepository.findAllByUserReceiverAndAndUserSender(user1, user2);
        List<Message> list2 = this.messageRepository.findAllByUserReceiverAndAndUserSender(user2, user1);
        List<Message> listofall = new ArrayList<Message>() {
            {
                addAll(list1);
                addAll(list2);
            }
        };
        Collections.sort(listofall, new Comparator<Message>() {
            @Override
            public int compare(Message a1, Message a2) {
                return (int) (a1.getMessageId() - a2.getMessageId());
            }
        });
        return listofall;
    }
    public Message addMessage(Message message){
        return  this.messageRepository.save(message);
    }

}
