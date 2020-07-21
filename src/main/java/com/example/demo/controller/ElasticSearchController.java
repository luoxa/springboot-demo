package com.example.demo.controller;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Article;
import com.example.demo.domain.JsonData;
import com.example.demo.repository.ArticleRepository;

//@RestController
//@RequestMapping("/es")
public class ElasticSearchController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@RequestMapping("/save")
	public Object save(){
		Article article  = new Article();
		article.setId(1);
		article.setTitle("ElasticSearch测试");
		article.setSummary("啦啦啦");
		article.setContent("hello elasticsearch");
		articleRepository.save(article);
		return JsonData.buildSuccess(article);
	}
	
	@RequestMapping("/search")
	public Object search(String title){
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
		Iterable<Article> list = articleRepository.search(queryBuilder);
		return JsonData.buildSuccess(list);
	}
	
}
