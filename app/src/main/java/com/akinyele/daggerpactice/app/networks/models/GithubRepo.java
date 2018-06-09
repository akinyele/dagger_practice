package com.akinyele.daggerpactice.app.networks.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * @author akiny.
 * Created 2/27/2018.
 */

public class GithubRepo implements Parcelable {


    /**
     * id : 1
     * name : grit
     * full_name : mojombo/grit
     * owner : {"login":"mojombo","id":1,"avatar_url":"https://avatars0.githubusercontent.com/u/1?v=4","gravatar_id":"","url":"https://api.github.com/users/mojombo","html_url":"https://github.com/mojombo","followers_url":"https://api.github.com/users/mojombo/followers","following_url":"https://api.github.com/users/mojombo/following{/other_user}","gists_url":"https://api.github.com/users/mojombo/gists{/gist_id}","starred_url":"https://api.github.com/users/mojombo/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/mojombo/subscriptions","organizations_url":"https://api.github.com/users/mojombo/orgs","repos_url":"https://api.github.com/users/mojombo/repos","events_url":"https://api.github.com/users/mojombo/events{/privacy}","received_events_url":"https://api.github.com/users/mojombo/received_events","type":"User","site_admin":false}
     * private : false
     * html_url : https://github.com/mojombo/grit
     * description : **Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby.
     * fork : false
     * url : https://api.github.com/repos/mojombo/grit
     * forks_url : https://api.github.com/repos/mojombo/grit/forks
     * keys_url : https://api.github.com/repos/mojombo/grit/keys{/key_id}
     * collaborators_url : https://api.github.com/repos/mojombo/grit/collaborators{/collaborator}
     * teams_url : https://api.github.com/repos/mojombo/grit/teams
     * hooks_url : https://api.github.com/repos/mojombo/grit/hooks
     * issue_events_url : https://api.github.com/repos/mojombo/grit/issues/events{/number}
     * events_url : https://api.github.com/repos/mojombo/grit/events
     * assignees_url : https://api.github.com/repos/mojombo/grit/assignees{/user}
     * branches_url : https://api.github.com/repos/mojombo/grit/branches{/branch}
     * tags_url : https://api.github.com/repos/mojombo/grit/tags
     * blobs_url : https://api.github.com/repos/mojombo/grit/git/blobs{/sha}
     * git_tags_url : https://api.github.com/repos/mojombo/grit/git/tags{/sha}
     * git_refs_url : https://api.github.com/repos/mojombo/grit/git/refs{/sha}
     * trees_url : https://api.github.com/repos/mojombo/grit/git/trees{/sha}
     * statuses_url : https://api.github.com/repos/mojombo/grit/statuses/{sha}
     * languages_url : https://api.github.com/repos/mojombo/grit/languages
     * stargazers_url : https://api.github.com/repos/mojombo/grit/stargazers
     * contributors_url : https://api.github.com/repos/mojombo/grit/contributors
     * subscribers_url : https://api.github.com/repos/mojombo/grit/subscribers
     * subscription_url : https://api.github.com/repos/mojombo/grit/subscription
     * commits_url : https://api.github.com/repos/mojombo/grit/commits{/sha}
     * git_commits_url : https://api.github.com/repos/mojombo/grit/git/commits{/sha}
     * comments_url : https://api.github.com/repos/mojombo/grit/comments{/number}
     * issue_comment_url : https://api.github.com/repos/mojombo/grit/issues/comments{/number}
     * contents_url : https://api.github.com/repos/mojombo/grit/contents/{+path}
     * compare_url : https://api.github.com/repos/mojombo/grit/compare/{base}...{head}
     * merges_url : https://api.github.com/repos/mojombo/grit/merges
     * archive_url : https://api.github.com/repos/mojombo/grit/{archive_format}{/ref}
     * downloads_url : https://api.github.com/repos/mojombo/grit/downloads
     * issues_url : https://api.github.com/repos/mojombo/grit/issues{/number}
     * pulls_url : https://api.github.com/repos/mojombo/grit/pulls{/number}
     * milestones_url : https://api.github.com/repos/mojombo/grit/milestones{/number}
     * notifications_url : https://api.github.com/repos/mojombo/grit/notifications{?since,all,participating}
     * labels_url : https://api.github.com/repos/mojombo/grit/labels{/name}
     * releases_url : https://api.github.com/repos/mojombo/grit/releases{/id}
     * deployments_url : https://api.github.com/repos/mojombo/grit/deployments
     */

    private int id;
    private String name;
    private String full_name;
    private OwnerBean owner;
    @SerializedName("private")
    private boolean privateX;
    private String html_url;
    private String description;
    private boolean fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;

    protected GithubRepo(Parcel in) {
        id = in.readInt();
        name = in.readString();
        full_name = in.readString();
        owner = in.readParcelable(OwnerBean.class.getClassLoader());
        privateX = in.readByte() != 0;
        html_url = in.readString();
        description = in.readString();
        fork = in.readByte() != 0;
        url = in.readString();
        forks_url = in.readString();
        keys_url = in.readString();
        collaborators_url = in.readString();
        teams_url = in.readString();
        hooks_url = in.readString();
        issue_events_url = in.readString();
        events_url = in.readString();
        assignees_url = in.readString();
        branches_url = in.readString();
        tags_url = in.readString();
        blobs_url = in.readString();
        git_tags_url = in.readString();
        git_refs_url = in.readString();
        trees_url = in.readString();
        statuses_url = in.readString();
        languages_url = in.readString();
        stargazers_url = in.readString();
        contributors_url = in.readString();
        subscribers_url = in.readString();
        subscription_url = in.readString();
        commits_url = in.readString();
        git_commits_url = in.readString();
        comments_url = in.readString();
        issue_comment_url = in.readString();
        contents_url = in.readString();
        compare_url = in.readString();
        merges_url = in.readString();
        archive_url = in.readString();
        downloads_url = in.readString();
        issues_url = in.readString();
        pulls_url = in.readString();
        milestones_url = in.readString();
        notifications_url = in.readString();
        labels_url = in.readString();
        releases_url = in.readString();
        deployments_url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(full_name);
        dest.writeParcelable(owner, flags);
        dest.writeByte((byte) (privateX ? 1 : 0));
        dest.writeString(html_url);
        dest.writeString(description);
        dest.writeByte((byte) (fork ? 1 : 0));
        dest.writeString(url);
        dest.writeString(forks_url);
        dest.writeString(keys_url);
        dest.writeString(collaborators_url);
        dest.writeString(teams_url);
        dest.writeString(hooks_url);
        dest.writeString(issue_events_url);
        dest.writeString(events_url);
        dest.writeString(assignees_url);
        dest.writeString(branches_url);
        dest.writeString(tags_url);
        dest.writeString(blobs_url);
        dest.writeString(git_tags_url);
        dest.writeString(git_refs_url);
        dest.writeString(trees_url);
        dest.writeString(statuses_url);
        dest.writeString(languages_url);
        dest.writeString(stargazers_url);
        dest.writeString(contributors_url);
        dest.writeString(subscribers_url);
        dest.writeString(subscription_url);
        dest.writeString(commits_url);
        dest.writeString(git_commits_url);
        dest.writeString(comments_url);
        dest.writeString(issue_comment_url);
        dest.writeString(contents_url);
        dest.writeString(compare_url);
        dest.writeString(merges_url);
        dest.writeString(archive_url);
        dest.writeString(downloads_url);
        dest.writeString(issues_url);
        dest.writeString(pulls_url);
        dest.writeString(milestones_url);
        dest.writeString(notifications_url);
        dest.writeString(labels_url);
        dest.writeString(releases_url);
        dest.writeString(deployments_url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GithubRepo> CREATOR = new Creator<GithubRepo>() {
        @Override
        public GithubRepo createFromParcel(Parcel in) {
            return new GithubRepo(in);
        }

        @Override
        public GithubRepo[] newArray(int size) {
            return new GithubRepo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public boolean isPrivateX() {
        return privateX;
    }

    public void setPrivateX(boolean privateX) {
        this.privateX = privateX;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForks_url() {
        return forks_url;
    }

    public void setForks_url(String forks_url) {
        this.forks_url = forks_url;
    }

    public String getKeys_url() {
        return keys_url;
    }

    public void setKeys_url(String keys_url) {
        this.keys_url = keys_url;
    }

    public String getCollaborators_url() {
        return collaborators_url;
    }

    public void setCollaborators_url(String collaborators_url) {
        this.collaborators_url = collaborators_url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    public String getHooks_url() {
        return hooks_url;
    }

    public void setHooks_url(String hooks_url) {
        this.hooks_url = hooks_url;
    }

    public String getIssue_events_url() {
        return issue_events_url;
    }

    public void setIssue_events_url(String issue_events_url) {
        this.issue_events_url = issue_events_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getAssignees_url() {
        return assignees_url;
    }

    public void setAssignees_url(String assignees_url) {
        this.assignees_url = assignees_url;
    }

    public String getBranches_url() {
        return branches_url;
    }

    public void setBranches_url(String branches_url) {
        this.branches_url = branches_url;
    }

    public String getTags_url() {
        return tags_url;
    }

    public void setTags_url(String tags_url) {
        this.tags_url = tags_url;
    }

    public String getBlobs_url() {
        return blobs_url;
    }

    public void setBlobs_url(String blobs_url) {
        this.blobs_url = blobs_url;
    }

    public String getGit_tags_url() {
        return git_tags_url;
    }

    public void setGit_tags_url(String git_tags_url) {
        this.git_tags_url = git_tags_url;
    }

    public String getGit_refs_url() {
        return git_refs_url;
    }

    public void setGit_refs_url(String git_refs_url) {
        this.git_refs_url = git_refs_url;
    }

    public String getTrees_url() {
        return trees_url;
    }

    public void setTrees_url(String trees_url) {
        this.trees_url = trees_url;
    }

    public String getStatuses_url() {
        return statuses_url;
    }

    public void setStatuses_url(String statuses_url) {
        this.statuses_url = statuses_url;
    }

    public String getLanguages_url() {
        return languages_url;
    }

    public void setLanguages_url(String languages_url) {
        this.languages_url = languages_url;
    }

    public String getStargazers_url() {
        return stargazers_url;
    }

    public void setStargazers_url(String stargazers_url) {
        this.stargazers_url = stargazers_url;
    }

    public String getContributors_url() {
        return contributors_url;
    }

    public void setContributors_url(String contributors_url) {
        this.contributors_url = contributors_url;
    }

    public String getSubscribers_url() {
        return subscribers_url;
    }

    public void setSubscribers_url(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

    public String getSubscription_url() {
        return subscription_url;
    }

    public void setSubscription_url(String subscription_url) {
        this.subscription_url = subscription_url;
    }

    public String getCommits_url() {
        return commits_url;
    }

    public void setCommits_url(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getGit_commits_url() {
        return git_commits_url;
    }

    public void setGit_commits_url(String git_commits_url) {
        this.git_commits_url = git_commits_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getIssue_comment_url() {
        return issue_comment_url;
    }

    public void setIssue_comment_url(String issue_comment_url) {
        this.issue_comment_url = issue_comment_url;
    }

    public String getContents_url() {
        return contents_url;
    }

    public void setContents_url(String contents_url) {
        this.contents_url = contents_url;
    }

    public String getCompare_url() {
        return compare_url;
    }

    public void setCompare_url(String compare_url) {
        this.compare_url = compare_url;
    }

    public String getMerges_url() {
        return merges_url;
    }

    public void setMerges_url(String merges_url) {
        this.merges_url = merges_url;
    }

    public String getArchive_url() {
        return archive_url;
    }

    public void setArchive_url(String archive_url) {
        this.archive_url = archive_url;
    }

    public String getDownloads_url() {
        return downloads_url;
    }

    public void setDownloads_url(String downloads_url) {
        this.downloads_url = downloads_url;
    }

    public String getIssues_url() {
        return issues_url;
    }

    public void setIssues_url(String issues_url) {
        this.issues_url = issues_url;
    }

    public String getPulls_url() {
        return pulls_url;
    }

    public void setPulls_url(String pulls_url) {
        this.pulls_url = pulls_url;
    }

    public String getMilestones_url() {
        return milestones_url;
    }

    public void setMilestones_url(String milestones_url) {
        this.milestones_url = milestones_url;
    }

    public String getNotifications_url() {
        return notifications_url;
    }

    public void setNotifications_url(String notifications_url) {
        this.notifications_url = notifications_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public void setLabels_url(String labels_url) {
        this.labels_url = labels_url;
    }

    public String getReleases_url() {
        return releases_url;
    }

    public void setReleases_url(String releases_url) {
        this.releases_url = releases_url;
    }

    public String getDeployments_url() {
        return deployments_url;
    }

    public void setDeployments_url(String deployments_url) {
        this.deployments_url = deployments_url;
    }


    public static class OwnerBean implements Parcelable {
        /**
         * login : mojombo
         * id : 1
         * avatar_url : https://avatars0.githubusercontent.com/u/1?v=4
         * gravatar_id :
         * url : https://api.github.com/users/mojombo
         * html_url : https://github.com/mojombo
         * followers_url : https://api.github.com/users/mojombo/followers
         * following_url : https://api.github.com/users/mojombo/following{/other_user}
         * gists_url : https://api.github.com/users/mojombo/gists{/gist_id}
         * starred_url : https://api.github.com/users/mojombo/starred{/owner}{/repo}
         * subscriptions_url : https://api.github.com/users/mojombo/subscriptions
         * organizations_url : https://api.github.com/users/mojombo/orgs
         * repos_url : https://api.github.com/users/mojombo/repos
         * events_url : https://api.github.com/users/mojombo/events{/privacy}
         * received_events_url : https://api.github.com/users/mojombo/received_events
         * type : User
         * site_admin : false
         */

        private String login;
        private int id;
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
        private boolean site_admin;

        protected OwnerBean(Parcel in) {
            login = in.readString();
            id = in.readInt();
            avatar_url = in.readString();
            gravatar_id = in.readString();
            url = in.readString();
            html_url = in.readString();
            followers_url = in.readString();
            following_url = in.readString();
            gists_url = in.readString();
            starred_url = in.readString();
            subscriptions_url = in.readString();
            organizations_url = in.readString();
            repos_url = in.readString();
            events_url = in.readString();
            received_events_url = in.readString();
            type = in.readString();
            site_admin = in.readByte() != 0;
        }

        public static final Creator<OwnerBean> CREATOR = new Creator<OwnerBean>() {
            @Override
            public OwnerBean createFromParcel(Parcel in) {
                return new OwnerBean(in);
            }

            @Override
            public OwnerBean[] newArray(int size) {
                return new OwnerBean[size];
            }
        };

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public String getGravatar_id() {
            return gravatar_id;
        }

        public void setGravatar_id(String gravatar_id) {
            this.gravatar_id = gravatar_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getFollowers_url() {
            return followers_url;
        }

        public void setFollowers_url(String followers_url) {
            this.followers_url = followers_url;
        }

        public String getFollowing_url() {
            return following_url;
        }

        public void setFollowing_url(String following_url) {
            this.following_url = following_url;
        }

        public String getGists_url() {
            return gists_url;
        }

        public void setGists_url(String gists_url) {
            this.gists_url = gists_url;
        }

        public String getStarred_url() {
            return starred_url;
        }

        public void setStarred_url(String starred_url) {
            this.starred_url = starred_url;
        }

        public String getSubscriptions_url() {
            return subscriptions_url;
        }

        public void setSubscriptions_url(String subscriptions_url) {
            this.subscriptions_url = subscriptions_url;
        }

        public String getOrganizations_url() {
            return organizations_url;
        }

        public void setOrganizations_url(String organizations_url) {
            this.organizations_url = organizations_url;
        }

        public String getRepos_url() {
            return repos_url;
        }

        public void setRepos_url(String repos_url) {
            this.repos_url = repos_url;
        }

        public String getEvents_url() {
            return events_url;
        }

        public void setEvents_url(String events_url) {
            this.events_url = events_url;
        }

        public String getReceived_events_url() {
            return received_events_url;
        }

        public void setReceived_events_url(String received_events_url) {
            this.received_events_url = received_events_url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isSite_admin() {
            return site_admin;
        }

        public void setSite_admin(boolean site_admin) {
            this.site_admin = site_admin;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(login);
            dest.writeInt(id);
            dest.writeString(avatar_url);
            dest.writeString(gravatar_id);
            dest.writeString(url);
            dest.writeString(html_url);
            dest.writeString(followers_url);
            dest.writeString(following_url);
            dest.writeString(gists_url);
            dest.writeString(starred_url);
            dest.writeString(subscriptions_url);
            dest.writeString(organizations_url);
            dest.writeString(repos_url);
            dest.writeString(events_url);
            dest.writeString(received_events_url);
            dest.writeString(type);
            dest.writeByte((byte) (site_admin ? 1 : 0));
        }
    }
}
