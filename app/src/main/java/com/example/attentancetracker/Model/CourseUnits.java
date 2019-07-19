package com.example.attentancetracker.Model;

public class CourseUnits {
    private int id;
    private String courseNo;
    private String courseUnit;
    private String courseLecturer;
    private String courseSemester;

    public CourseUnits(int id, String courseNo, String courseUnit, String courseLecturer, String courseSemester) {
        this.id = id;
        this.courseNo = courseNo;
        this.courseUnit = courseUnit;
        this.courseLecturer = courseLecturer;
        this.courseSemester = courseSemester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(String courseUnit) {
        this.courseUnit = courseUnit;
    }

    public String getCourseLecturer() {
        return courseLecturer;
    }

    public void setCourseLecturer(String courseLecturer) {
        this.courseLecturer = courseLecturer;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }
}
