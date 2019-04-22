package main.java.twitterClone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
@Entity 
public class Tweets {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    
    private String tweet;

    private Timestamp time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getTweet() {
		return tweet;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getEverything() {
		return name + " " + tweet + " " + time;
	}

}
