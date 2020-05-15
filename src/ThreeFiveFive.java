

import javafx.util.Pair;

import java.util.*;

/**
 * Created by lideqing@xiaomi.com on 20-3-27
 */
public class ThreeFiveFive {

    class Twitter {
        private Map<Integer, List<Pair<Integer, Integer>>> feeds;
        private Map<Integer, Set<Integer>> relation;
        private int order;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            feeds = new HashMap<>();
            relation = new HashMap<>();
            order = 0;
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            if (feeds.containsKey(userId)) {
                feeds.get(userId).add(new Pair<>(tweetId, order++));
            } else {
                List<Pair<Integer, Integer>> list = new LinkedList<Pair<Integer, Integer>>();
                list.add(new Pair<>(tweetId, order++));
                feeds.put(userId, list);
            }
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            Set<Integer> relationUser = relation.get(userId);
            if (feeds.get(userId) != null) {
                queue.addAll(feeds.get(userId));
            }
            if (relationUser != null) {
                for (Integer i : relationUser) {
                    if (feeds.get(i) != null && i!= userId) {
                        queue.addAll(feeds.get(i));
                    }
                }
            }
            List<Integer> res = new LinkedList<>();
            int i = 0;
            while (queue.size() != 0 && i < 10) {
                res.add(queue.poll().getKey());
                ++i;
            }
            return res;

        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (relation.containsKey(followerId)) {
                relation.get(followerId).add(followeeId);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(followeeId);
                relation.put(followerId, set);
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (relation.containsKey(followerId)) {
                relation.get(followerId).remove(new Integer(followeeId));
            }
        }
    }

    /*
    * ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
    [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
    public static void main(String[] args) {
        ThreeFiveFive threeFiveFive = new ThreeFiveFive();
        Twitter twitter = threeFiveFive.new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }*/
}
