package com.issuemanagementservice.issuemanagementservice.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitHubIssueDto {

    @JsonProperty("node_id")
    private String node_id;

    @JsonProperty("number")
    private int number;

    @JsonProperty("title")
    private String title;

    @JsonProperty("state")
    private String state;

    @JsonProperty("author_association")
    private String author_association;

    @JsonProperty("user")
    private UserDto userDto;


}
