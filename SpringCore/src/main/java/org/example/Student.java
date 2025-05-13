package com.springcore;

public class Student {

    private int studentId;

    private String studentName;


    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(int studentId) {
        this.studentId = studentId;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}