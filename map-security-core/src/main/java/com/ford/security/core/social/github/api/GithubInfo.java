package com.ford.security.core.social.github.api;

import lombok.Data;

import java.util.Date;

/**
 * @author : tom fang
 * @date : 2019/8/5 14:47
 * Description:
 */
@Data
public class GithubInfo {
    private String login;
    private String id;
    private String node_id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private String site_admin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    private String public_repos;
    private String public_gists;
    private String followers;
    private String created_at;
    private Date updated_at;
}
