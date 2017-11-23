package com.vip.springbootweb.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topicList;

    @Autowired
    private TopicRepository tRepo;

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    /*@PostConstruct
    private void initializeTopics() {

        topicList = new ArrayList<>();

        topicList.add(new Topic("Spring Framework",
                "Basic course explaining Spring Framework",
                1));

        topicList.add(new Topic("Spring Web",
                "Basic course explaining Spring Web",
                2));

        topicList.add(new Topic("Spring MVC",
                "Basic course explaining Spring MVC",
                3));

        topicList.add(new Topic("Spring Hibernate",
                "Basic course explaining Spring Hibernate",
                4));


    }*/

    public List<Topic> getTopicList() {
//        return topicList;

        List<Topic> tList = new ArrayList<>();

        tRepo.findAll().forEach(tList::add);

        return tList;
    }

    public Topic getTopic(int id) {
        /*return topicList.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .get();*/
        return tRepo.findOne(id);

    }

    public void addTopic(Topic topic) {

//        topicList.add(topic);
        tRepo.save(topic);
    }


    public void updateTopic(Topic topic) {

       /* for(int i = 0; i < topicList.size(); i++) {
            if (topicList.get(i).getId() == id) {
                topicList.set(i, topic);
            }
        }*/
//       update uses topic sent to figure out the id from it
       tRepo.save(topic);
    }

    public void deleteTopic(int id) {
//        topicList.removeIf(t -> t.getId() == id);

        try {
            tRepo.delete(id);
        } catch (Exception e) {
            System.out.println("Delete exception for id:"+id);
//            e.printStackTrace();
        }
    }
}
