package com.technova.joblisting.Repository;

import com.technova.joblisting.model.Job;

import java.util.List;

public interface SearchRepository {
    List<Job> findByText(String text);
}
