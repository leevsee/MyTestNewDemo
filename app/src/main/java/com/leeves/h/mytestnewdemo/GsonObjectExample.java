package com.leeves.h.mytestnewdemo;

import java.util.List;

/**
 * Function：
 * Created by h on 2016/9/26.
 *
 * @author Leeves
 */
public class GsonObjectExample {

    /**
     * total_count : 11
     * incomplete_results : false
     * items : [{"login":"retrofit","id":7904376,"avatar_url":"https://avatars.githubusercontent.com/u/7904376?v=3","gravatar_id":"","url":"https://api.github.com/users/retrofit","html_url":"https://github.com/retrofit","followers_url":"https://api.github.com/users/retrofit/followers","following_url":"https://api.github.com/users/retrofit/following{/other_user}","gists_url":"https://api.github.com/users/retrofit/gists{/gist_id}","starred_url":"https://api.github.com/users/retrofit/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/retrofit/subscriptions","organizations_url":"https://api.github.com/users/retrofit/orgs","repos_url":"https://api.github.com/users/retrofit/repos","events_url":"https://api.github.com/users/retrofit/events{/privacy}","received_events_url":"https://api.github.com/users/retrofit/received_events","type":"User","site_admin":false,"score":16.394825},{"login":"RetrofitCoder","id":251752,"avatar_url":"https://avatars.githubusercontent.com/u/251752?v=3","gravatar_id":"","url":"https://api.github.com/users/RetrofitCoder","html_url":"https://github.com/RetrofitCoder","followers_url":"https://api.github.com/users/RetrofitCoder/followers","following_url":"https://api.github.com/users/RetrofitCoder/following{/other_user}","gists_url":"https://api.github.com/users/RetrofitCoder/gists{/gist_id}","starred_url":"https://api.github.com/users/RetrofitCoder/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/RetrofitCoder/subscriptions","organizations_url":"https://api.github.com/users/RetrofitCoder/orgs","repos_url":"https://api.github.com/users/RetrofitCoder/repos","events_url":"https://api.github.com/users/RetrofitCoder/events{/privacy}","received_events_url":"https://api.github.com/users/RetrofitCoder/received_events","type":"User","site_admin":false,"score":13.520343},{"login":"RetrofitProductions","id":6674724,"avatar_url":"https://avatars.githubusercontent.com/u/6674724?v=3","gravatar_id":"","url":"https://api.github.com/users/RetrofitProductions","html_url":"https://github.com/RetrofitProductions","followers_url":"https://api.github.com/users/RetrofitProductions/followers","following_url":"https://api.github.com/users/RetrofitProductions/following{/other_user}","gists_url":"https://api.github.com/users/RetrofitProductions/gists{/gist_id}","starred_url":"https://api.github.com/users/RetrofitProductions/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/RetrofitProductions/subscriptions","organizations_url":"https://api.github.com/users/RetrofitProductions/orgs","repos_url":"https://api.github.com/users/RetrofitProductions/repos","events_url":"https://api.github.com/users/RetrofitProductions/events{/privacy}","received_events_url":"https://api.github.com/users/RetrofitProductions/received_events","type":"User","site_admin":false,"score":11.36429},{"login":"retrofitter","id":13805912,"avatar_url":"https://avatars.githubusercontent.com/u/13805912?v=3","gravatar_id":"","url":"https://api.github.com/users/retrofitter","html_url":"https://github.com/retrofitter","followers_url":"https://api.github.com/users/retrofitter/followers","following_url":"https://api.github.com/users/retrofitter/following{/other_user}","gists_url":"https://api.github.com/users/retrofitter/gists{/gist_id}","starred_url":"https://api.github.com/users/retrofitter/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/retrofitter/subscriptions","organizations_url":"https://api.github.com/users/retrofitter/orgs","repos_url":"https://api.github.com/users/retrofitter/repos","events_url":"https://api.github.com/users/retrofitter/events{/privacy}","received_events_url":"https://api.github.com/users/retrofitter/received_events","type":"User","site_admin":false,"score":9.53357},{"login":"retrofitweb","id":7776794,"avatar_url":"https://avatars.githubusercontent.com/u/7776794?v=3","gravatar_id":"","url":"https://api.github.com/users/retrofitweb","html_url":"https://github.com/retrofitweb","followers_url":"https://api.github.com/users/retrofitweb/followers","following_url":"https://api.github.com/users/retrofitweb/following{/other_user}","gists_url":"https://api.github.com/users/retrofitweb/gists{/gist_id}","starred_url":"https://api.github.com/users/retrofitweb/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/retrofitweb/subscriptions","organizations_url":"https://api.github.com/users/retrofitweb/orgs","repos_url":"https://api.github.com/users/retrofitweb/repos","events_url":"https://api.github.com/users/retrofitweb/events{/privacy}","received_events_url":"https://api.github.com/users/retrofitweb/received_events","type":"User","site_admin":false,"score":7.693539},{"login":"Retrofitterdk","id":9422676,"avatar_url":"https://avatars.githubusercontent.com/u/9422676?v=3","gravatar_id":"","url":"https://api.github.com/users/Retrofitterdk","html_url":"https://github.com/Retrofitterdk","followers_url":"https://api.github.com/users/Retrofitterdk/followers","following_url":"https://api.github.com/users/Retrofitterdk/following{/other_user}","gists_url":"https://api.github.com/users/Retrofitterdk/gists{/gist_id}","starred_url":"https://api.github.com/users/Retrofitterdk/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/Retrofitterdk/subscriptions","organizations_url":"https://api.github.com/users/Retrofitterdk/orgs","repos_url":"https://api.github.com/users/Retrofitterdk/repos","events_url":"https://api.github.com/users/Retrofitterdk/events{/privacy}","received_events_url":"https://api.github.com/users/Retrofitterdk/received_events","type":"User","site_admin":false,"score":7.693539},{"login":"RetroFit2Grbl","id":6045376,"avatar_url":"https://avatars.githubusercontent.com/u/6045376?v=3","gravatar_id":"","url":"https://api.github.com/users/RetroFit2Grbl","html_url":"https://github.com/RetroFit2Grbl","followers_url":"https://api.github.com/users/RetroFit2Grbl/followers","following_url":"https://api.github.com/users/RetroFit2Grbl/following{/other_user}","gists_url":"https://api.github.com/users/RetroFit2Grbl/gists{/gist_id}","starred_url":"https://api.github.com/users/RetroFit2Grbl/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/RetroFit2Grbl/subscriptions","organizations_url":"https://api.github.com/users/RetroFit2Grbl/orgs","repos_url":"https://api.github.com/users/RetroFit2Grbl/repos","events_url":"https://api.github.com/users/RetroFit2Grbl/events{/privacy}","received_events_url":"https://api.github.com/users/RetroFit2Grbl/received_events","type":"User","site_admin":false,"score":7.3277097},{"login":"retrofitandrelampwithleds","id":6506151,"avatar_url":"https://avatars.githubusercontent.com/u/6506151?v=3","gravatar_id":"","url":"https://api.github.com/users/retrofitandrelampwithleds","html_url":"https://github.com/retrofitandrelampwithleds","followers_url":"https://api.github.com/users/retrofitandrelampwithleds/followers","following_url":"https://api.github.com/users/retrofitandrelampwithleds/following{/other_user}","gists_url":"https://api.github.com/users/retrofitandrelampwithleds/gists{/gist_id}","starred_url":"https://api.github.com/users/retrofitandrelampwithleds/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/retrofitandrelampwithleds/subscriptions","organizations_url":"https://api.github.com/users/retrofitandrelampwithleds/orgs","repos_url":"https://api.github.com/users/retrofitandrelampwithleds/repos","events_url":"https://api.github.com/users/retrofitandrelampwithleds/events{/privacy}","received_events_url":"https://api.github.com/users/retrofitandrelampwithleds/received_events","type":"Organization","site_admin":false,"score":7.3277097},{"login":"RetrofitNY","id":11965565,"avatar_url":"https://avatars.githubusercontent.com/u/11965565?v=3","gravatar_id":"","url":"https://api.github.com/users/RetrofitNY","html_url":"https://github.com/RetrofitNY","followers_url":"https://api.github.com/users/RetrofitNY/followers","following_url":"https://api.github.com/users/RetrofitNY/following{/other_user}","gists_url":"https://api.github.com/users/RetrofitNY/gists{/gist_id}","starred_url":"https://api.github.com/users/RetrofitNY/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/RetrofitNY/subscriptions","organizations_url":"https://api.github.com/users/RetrofitNY/orgs","repos_url":"https://api.github.com/users/RetrofitNY/repos","events_url":"https://api.github.com/users/RetrofitNY/events{/privacy}","received_events_url":"https://api.github.com/users/RetrofitNY/received_events","type":"User","site_admin":false,"score":7.3277097},{"login":"RetroFitRPG","id":18335522,"avatar_url":"https://avatars.githubusercontent.com/u/18335522?v=3","gravatar_id":"","url":"https://api.github.com/users/RetroFitRPG","html_url":"https://github.com/RetroFitRPG","followers_url":"https://api.github.com/users/RetroFitRPG/followers","following_url":"https://api.github.com/users/RetroFitRPG/following{/other_user}","gists_url":"https://api.github.com/users/RetroFitRPG/gists{/gist_id}","starred_url":"https://api.github.com/users/RetroFitRPG/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/RetroFitRPG/subscriptions","organizations_url":"https://api.github.com/users/RetroFitRPG/orgs","repos_url":"https://api.github.com/users/RetroFitRPG/repos","events_url":"https://api.github.com/users/RetroFitRPG/events{/privacy}","received_events_url":"https://api.github.com/users/RetroFitRPG/received_events","type":"Organization","site_admin":false,"score":7.3277097},{"login":"alkurop","id":5940685,"avatar_url":"https://avatars.githubusercontent.com/u/5940685?v=3","gravatar_id":"","url":"https://api.github.com/users/alkurop","html_url":"https://github.com/alkurop","followers_url":"https://api.github.com/users/alkurop/followers","following_url":"https://api.github.com/users/alkurop/following{/other_user}","gists_url":"https://api.github.com/users/alkurop/gists{/gist_id}","starred_url":"https://api.github.com/users/alkurop/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/alkurop/subscriptions","organizations_url":"https://api.github.com/users/alkurop/orgs","repos_url":"https://api.github.com/users/alkurop/repos","events_url":"https://api.github.com/users/alkurop/events{/privacy}","received_events_url":"https://api.github.com/users/alkurop/received_events","type":"User","site_admin":false,"score":3.9789026}]
     */

    private int total_count;
    private boolean incomplete_results;
    /**
     * login : retrofit
     * id : 7904376
     * avatar_url : https://avatars.githubusercontent.com/u/7904376?v=3
     * gravatar_id :
     * url : https://api.github.com/users/retrofit
     * html_url : https://github.com/retrofit
     * followers_url : https://api.github.com/users/retrofit/followers
     * following_url : https://api.github.com/users/retrofit/following{/other_user}
     * gists_url : https://api.github.com/users/retrofit/gists{/gist_id}
     * starred_url : https://api.github.com/users/retrofit/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/retrofit/subscriptions
     * organizations_url : https://api.github.com/users/retrofit/orgs
     * repos_url : https://api.github.com/users/retrofit/repos
     * events_url : https://api.github.com/users/retrofit/events{/privacy}
     * received_events_url : https://api.github.com/users/retrofit/received_events
     * type : User
     * site_admin : false
     * score : 16.394825
     */

    private List<ItemsBean> items;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
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
        private double score;

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

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
    }
}
