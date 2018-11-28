package com.sdg.spark.model;

import java.util.List;

public interface CourseIdeaDAO {

    boolean add(CourseIdea idea);

    List<CourseIdea> findALL();
}
