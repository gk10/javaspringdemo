package main.java.twitterClone;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;


@RestController
public class Controller {

	@Autowired
	private TweetsRepo tweetsRepo;
	
	@Autowired
	private UsersRepo2 uRepo;

	@Autowired
	private AuthoritiesRepo author;
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("index.html");
		model.addObject("msg", tweetsRepo.recentTweets());
		System.out.println("PASS: " + new BCryptPasswordEncoder().encode("password"));
		return model;
	}

	@PostMapping("/tweet")
	public ModelAndView post(@RequestParam("task") String task, Principal principal) {
		ModelAndView model = new ModelAndView("index.html");
		if (!task.isEmpty()) {
			String name = principal.getName();
			Tweets tweet = new Tweets();
			tweet.setName(name);
			tweet.setTweet(task);
			tweet.setTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			tweetsRepo.save(tweet);
		}
		model.addObject("msg", tweetsRepo.recentTweets());
		return model;
	}

	@PostMapping("/search")
	public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView model = new ModelAndView("index.html");
		model.addObject("msg", tweetsRepo.recentSearch(search));
		return model;
	}

	@GetMapping("/users/{user}")
	public ModelAndView user(@PathVariable("user") String user) {
		ModelAndView model = new ModelAndView("index.html");
		model.addObject("msg", tweetsRepo.userSearch(user));
		return model;
	}
	
	@GetMapping("/test")
	public String test(Principal principal) {
		return principal.getName();
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView model = new ModelAndView("register.html");
		
		return model;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam("username") String name, @RequestParam("password") String pass)
	{
		ModelAndView model = new ModelAndView("generic.html");
		
		Users users = new Users();
		Authorities auth = new Authorities();
		users.setName(name);
		users.setPass(pass);
		users.setEnabled(true);
		uRepo.save(users);		
		auth.setName(name);
		auth.setAuthority("ROLE_USER");
		author.save(auth);
		model.addObject("msg", "Account made for: " + name);
		return model;
	}
	
}
