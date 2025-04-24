package com.technova.joblisting.Repository;


import com.technova.joblisting.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String > {

}
