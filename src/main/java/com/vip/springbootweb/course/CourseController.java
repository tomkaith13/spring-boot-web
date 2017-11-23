package com.vip.springbootweb.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {


    @Autowired
    private CourseService cService;

    @RequestMapping("/topics/{tId}/courses")
    public List<Course> getAllCourses(@PathVariable Integer tId) {
        return cService.getCourseList(tId);
    }

    @RequestMapping("/topics/{tId}/courses/{cId}")
    public Course getCourse(@PathVariable Integer tId, @PathVariable Integer cId) {
        return cService.getCourse(tId, cId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{tId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable Integer tId) {
        cService.addCourse(tId, course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{tId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable Integer tId, @PathVariable Integer id) {
        cService.updateCourse(course, tId, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        cService.deleteCourse(id);
    }


}
