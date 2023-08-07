package com.ironman.marondalgram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

	@GetMapping("/timeline-view")
	public String timeline() {
		return "post/timeline";
	}
}
