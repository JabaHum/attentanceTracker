package com.example.attentancetracker.Model;

public class Students {
    private int id;
    private String studentsName;
    private String studentsSex;
    private String studentsRegno;
    private String studentsProgram;


    public Students(int id, String studentsName, String studentsSex, String studentsRegno, String studentsProgram) {
        this.id = id;
        this.studentsName = studentsName;
        this.studentsSex = studentsSex;
        this.studentsRegno = studentsRegno;
        this.studentsProgram = studentsProgram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public String getStudentsSex() {
        return studentsSex;
    }

    public void setStudentsSex(String studentsSex) {
        this.studentsSex = studentsSex;
    }

    public String getStudentsRegno() {
        return studentsRegno;
    }

    public void setStudentsRegno(String studentsRegno) {
        this.studentsRegno = studentsRegno;
    }

    public String getStudentsProgram() {
        return studentsProgram;
    }

    public void setStudentsProgram(String studentsProgram) {
        this.studentsProgram = studentsProgram;
    }
}
