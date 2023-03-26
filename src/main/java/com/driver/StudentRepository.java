package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb = new HashMap<>();

    HashMap<String,Teacher> teacherDb = new HashMap<>();

    HashMap<String,String> studentTeacherPair = new HashMap<>();

    public void addStudent(Student student){

        String key = student.getName();
        studentDb.put(key,student);
        return ;
    }

    public void addTeacher(Teacher teacher){

        String key = teacher.getName();
        teacherDb.put(key,teacher);
        return ;
    }

    public void addStudentTeacherPair(String student,String teacher){

        studentTeacherPair.put(student,teacher);
        return ;
    }

    public void removeTeacher(String teacher){

        teacherDb.remove(teacher);
        // Iterate the complete hashmap

        for(Map.Entry<String,String> Entry : studentTeacherPair.entrySet()){

            if(Entry.getValue().equals(teacher)){

                String student = Entry.getKey();
                studentDb.remove(teacher);
                studentTeacherPair.remove(teacher);              // key : Student ,value : Teachergit
            }
        }
        return ;
    }

    public void removeAllTeacher(){

        for(String teacher : teacherDb.keySet())
        {
            teacherDb.remove(teacher);
            // Iterate the complete hashmap

            for(Map.Entry<String,String> Entry : studentTeacherPair.entrySet()){

                if(Entry.getValue().equals(teacher)){

                    String student = Entry.getKey();
                    studentDb.remove(teacher);
                    studentTeacherPair.remove(teacher);
                }
            }
        }
        return ;
    }

    public Student getStudentByName(String name){

        return studentDb.get(name);
    }

    public Teacher getTeacherByName(String name){

        return teacherDb.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher){

        List<String> students = new ArrayList<>();

        for(Map.Entry<String,String> entry : studentTeacherPair.entrySet()){

            String student = entry.getKey();
            String teacher1 = entry.getValue();

            if(teacher1.equals(teacher)){
                students.add(student);
            }

        }
        return students;


    }

    public List<String> getAllStudents(){

        List<String> students = new ArrayList<>();

        for(String s : studentDb.keySet()){
            students.add(s);
        }
        return students;
    }

}