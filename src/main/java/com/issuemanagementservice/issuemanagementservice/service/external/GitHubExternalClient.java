package com.issuemanagementservice.issuemanagementservice.service.external;

import com.issuemanagementservice.issuemanagementservice.dto.GitHubIssueDto;
import com.issuemanagementservice.issuemanagementservice.model.GitHubIssue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class GitHubExternalClient {
    private final RestTemplate restTemplate;

    @Value("${github.issue-detail-url}")
    private String gitHubIssueDetailsUrl;

    public GitHubExternalClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public List<GitHubIssueDto> getIssueDetails() {
        ResponseEntity<List<GitHubIssueDto>> response = restTemplate.exchange(gitHubIssueDetailsUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        return response.getBody();
    }
}
