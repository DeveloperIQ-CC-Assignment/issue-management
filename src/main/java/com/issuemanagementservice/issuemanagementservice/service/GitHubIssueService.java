package com.issuemanagementservice.issuemanagementservice.service;

import com.issuemanagementservice.issuemanagementservice.model.GitHubIssue;

import java.util.List;

public interface GitHubIssueService {
    List<GitHubIssue> getGitHubIssues();
    List<GitHubIssue> getAllIssues();
}


