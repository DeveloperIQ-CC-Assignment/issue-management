package com.issuemanagementservice.issuemanagementservice.service;

import com.issuemanagementservice.issuemanagementservice.dto.GitHubIssueDto;
import com.issuemanagementservice.issuemanagementservice.model.GitHubIssue;
import com.issuemanagementservice.issuemanagementservice.model.User;
import com.issuemanagementservice.issuemanagementservice.repository.GitHubIssueRepository;
import com.issuemanagementservice.issuemanagementservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GitHubIssueImpl implements GitHubIssueService {

    private final GitHubExternalClient githubExternalClient;
    private final GitHubIssueRepository gitHubIssueRepository;

    @Override
    public List<GitHubIssue> getGitHubIssues() {

        List<GitHubIssue> gitHubIssues = new ArrayList<>();

        List<GitHubIssueDto> gitHubIssueDtoList = this.githubExternalClient.getIssueDetails();

        gitHubIssueDtoList.forEach(gitHubRequestDto -> {
            GitHubIssue gitHubRequest = this.generateGitHubIssueObject(gitHubRequestDto);
            gitHubIssues.add(gitHubRequest);
        });

        this.gitHubIssueRepository.saveAll(gitHubIssues);

        return gitHubIssues;
    }

    @Override
    public List<GitHubIssue> getAllIssues() {
        return this.gitHubIssueRepository.findAll();
    }

//    end

    private GitHubIssue generateGitHubIssueObject(GitHubIssueDto gitHubIssueDto) {
        return GitHubIssue.builder()
                .nodeId(gitHubIssueDto.getNode_id())
                .number(gitHubIssueDto.getNumber())
                .title(gitHubIssueDto.getTitle())
                .state(gitHubIssueDto.getState())
                .author_association(gitHubIssueDto.getAuthor_association())
                .user(User.builder().login(gitHubIssueDto.getUserDto().getLogin()).build())
                .build();
    }
}
