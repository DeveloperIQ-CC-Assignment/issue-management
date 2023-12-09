package com.issuemanagementservice.issuemanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "github_issues")
public class GitHubIssue {
    @Id
    private int id;

    private String node_id;

    private int number;

    private String title;

    private String state;

    private String author_association;

}

