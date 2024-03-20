package com.springPrograms.restAPI.controller;

import com.springPrograms.restAPI.model.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("js", "Javascript", "Js is for "),
            new Topic("java", "Java Fundamentals", "Basic of java programming"),
            new Topic("python", "Advanced Python", "GUI programming with Python")
        ));

    public List<Topic> getTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for(Topic updateTopic: topics){
            if(updateTopic.getId().equals(id)){
                updateTopic.setName(topic.getName());
                updateTopic.setDescription(topic.getDescription());
            }
        }
    }

    public void deleteTopic(String id){
        topics.removeIf(deleteTopic -> deleteTopic.getId().equals(id));
    }
}
