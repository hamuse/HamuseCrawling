package com.hamuse.web.crw;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamuse.web.proxy.Box;
import com.hamuse.web.proxy.CrawlingProxy;
import com.hamuse.web.proxy.Inventory;

@RestController
@RequestMapping("/crw")
public class Crw {
	@Autowired Box box;
	@Autowired CrawlingProxy crawler;
	
	@GetMapping("/bugs")
	public void bugsCrw() {
		System.out.println("bugs crw");
	}
	
	@GetMapping("/cgv")
	public ArrayList<HashMap<String, String>> cgvCrw() {
		System.out.println("cgv crw");
		return crawler.cgvCrawl();
	}
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> naverCrw() {
		System.out.println("naver crw");
	 return crawler.engCrawling("https://endic.naver.com/?sLn=kr");
	}
}
