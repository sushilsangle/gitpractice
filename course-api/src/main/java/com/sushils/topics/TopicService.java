package com.sushils.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	
	/*private List<Topic> topics= new ArrayList<>(Arrays.asList(
			new Topic("spring","spring framework","Spring description updated"),
			new Topic("java","java core","Jav is basic concept"),
			new Topic("Android","Android is framework","Android is best framework from mobiles")
			));*/ 
	
	public List<Topic> getAllTopics()
	{
		//return topics;
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	public Optional<Topic> getTopic(String id)
	{
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findById(id);
	}
	public void addTopic(Topic topic) {
		//topics.add(topic); 
		
		topicRepository.save(topic);
	}
	public void updateTopic(String id, Topic topic) {
//		for(int i=0;i<topics.size();i++)
//		{
//			Topic t = topics.get(i);
//			if(t.getId().equals(id))
//			{
//				topics.set(i, topic);
//				return;
//			}
//		}
		
		topicRepository.save(topic);
	}
	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		
		topicRepository.deleteById(id);
	}
	
}
