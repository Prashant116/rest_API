package com.springPrograms.restAPI.controller;

import com.springPrograms.restAPI.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class topicController {

    @Autowired
    private TopicService topicService;
    private Object RequestMethod;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

//    @RequestMapping(method = RequestMethod.POST, value="/topics")
    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){

        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
