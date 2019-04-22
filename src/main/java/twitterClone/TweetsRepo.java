package main.java.twitterClone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetsRepo extends CrudRepository<Tweets, Integer>{
	@Query(value = "select name, tweet, time from tweets order by time desc", nativeQuery = true)
	ArrayList<TweetService> recentTweets();
	
	@Query(value = "select name, tweet, time from tweets where tweet like %:search%", nativeQuery = true)
	ArrayList<TweetService> recentSearch(String search);
	
	@Query(value = "select name, tweet, time from tweets where name= ?1 order by time desc", nativeQuery = true)
	ArrayList<TweetService> userSearch(String search);
	
}
