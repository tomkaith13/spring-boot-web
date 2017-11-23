package com.vip.springbootweb.course;

import com.vip.springbootweb.topic.Topic;
import com.vip.springbootweb.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository cRepo;

    @Autowired
    private TopicRepository tRepo;

    public List<Course> getCourseList(Integer tId) {
        List<Course> cList = new ArrayList<>();

        cRepo.findByTopicId(tId).forEach(cList::add);

        return cList;
    }

    public Course getCourse(Integer tId, Integer id) {

        Course course = cRepo.findOne(id);
        Topic topic = course.getTopic();

        if (topic != null && course != null && topic.getId() == tId)
            return course;
        else {
            if(course == null)
                System.out.println("Invalid Course id:" + id);
            else if (topic == null)
                System.out.println("Invalid Topic id:" + tId);
            else
                System.out.println("Course doesnt belong to this topic");
        }
        return null;

    }

    public void addCourse(Integer tId, Course course) {

        Topic t = tRepo.findOne(tId);

        if (t != null) {
            course.setTopic(t);
            cRepo.save(course);
        } else {
            System.out.println("Topic id:"+ tId + " doesnt exist");
        }
    }


    public void updateCourse(Course course,Integer tId, Integer id) {

        Topic t = tRepo.findOne(tId);

        if (t!= null && t.getId() == tId && course.getId() == id)
            cRepo.save(course);
        else {
            System.out.println("Given tid:" + tId + " does not match with one in request:"+ id);
        }
    }

    public void deleteCourse(int id) {
        try {
            cRepo.delete(id);
        } catch (Exception e) {
            System.out.println("Delete Course exception for id:"+id);
        }
    }
}
