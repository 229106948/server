package com.bus.tool;

import com.bus.model.Leave;
import com.bus.model.Parent;
import com.bus.model.Student;
import com.google.gson.Gson;

public class GsonUtil {

  

    public static Boolean changeJsonToResult(String json) {
        Gson gson = new Gson();
        boolean result = gson.fromJson(json, Boolean.class);
        return result;
    }
    public static Parent changeJsonToParent(String json) {
        Gson gson = new Gson();
        Parent parent = gson.fromJson(json, Parent.class);
        return parent;
    }
    public static Student changeJsonToStudent(String json) {
        Gson gson = new Gson();
        Student student = gson.fromJson(json, Student.class);
        return student;
    }
    public static Leave changeJsonToLeave(String json) {
        Gson gson = new Gson();
        Leave leave = gson.fromJson(json, Leave.class);
        return leave;
    }
}
