package com.example.demo;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.utils.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchTest {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Test
	public void saveTest(){
		Article article  = new Article();
		article.setId(1);
		article.setTitle("ElasticSearch测试");
		article.setSummary("啦啦啦");
		article.setContent("hello elasticsearch");
		articleRepository.save(article);
	}
	
	
	@Test
	public void searchTest(){
		String title = "ElasticSearch";
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title);
		Iterable<Article> list = articleRepository.search(queryBuilder);
		System.out.println(JsonUtils.Obj2String(list));
	}
	
	
}
