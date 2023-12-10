package com.issuemanagementservice.issuemanagementservice.repository;

import com.issuemanagementservice.issuemanagementservice.model.GitHubIssue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GitHubIssueRepository extends MongoRepository<GitHubIssue, String> {

}
