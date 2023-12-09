package com.issuemanagementservice.issuemanagementservice.controller;

import com.issuemanagementservice.issuemanagementservice.model.GitHubIssue;
import com.issuemanagementservice.issuemanagementservice.service.GitHubIssueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")
public class IssueController {
    private GitHubIssueService gitHubIssueService;

    @GetMapping("/issues")
    public ResponseEntity<List<GitHubIssue>> getGitHubIssues() {
        return ResponseEntity.ok(this.gitHubIssueService.getGitHubIssues());
    }

    @GetMapping("/issues/get-all")
    public ResponseEntity<List<GitHubIssue>> getAllCommits() {
        return ResponseEntity.ok(this.gitHubIssueService.getAllIssues());
    }
}
