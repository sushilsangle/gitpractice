package com.sushils.courses;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sushils.topics.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
		
	}
	@GetMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id)
	{
			return courseService.getCourse(id);      
	}
	@RequestMapping(method = RequestMethod.POST,  value = "/topics/{topicId}/courses")
	//@PostMapping(value="topics")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
    @RequestMapping(method=RequestMethod.PUT,value = "/topics/{topicId}/courses/{id}")
	//@PutMapping(value = "/topics/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String id,@PathVariable String topicId)
	{
    	course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course); 
	}

	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{topicId}/courses/{id}")
	//@DeleteMapping(value ="/topics/{id}")
	public void deleteCourse(@PathVariable String id)
	{
		 courseService.deleteCourse(id);
	}
	
}
