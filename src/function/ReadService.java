package function;

import java.util.List;
import data.Article;

public class ReadService {
	
	// 모든 게시글을 반환하는 로직
	public List<Article> findAll(List<Article> articles){
		return articles;
	}
	
	// 특정 ID로 게시글을 찾아 반환하는 로직
	public Article findById(List<Article> articles, int id){
		for(Article article : articles) {
			if(article.getId() == id) {
				// 조회 시 조회수 증가!
				article.increaseViewCount();
				return article;
			}
		}
		return null;
	}
}
