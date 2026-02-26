package function;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import data.Article;

public class ReadArticle implements Page {
	private final Scanner sc;
	private final List<Article> articles;
	
    public ReadArticle(List<Article> articles, Scanner sc){
        this.sc = sc;
        this.articles = articles;
    }
	
	@Override
	// 상세 보기 할 게시글 ID 고르기
	public void select() {
		// TODO Auto-generated method stub
		Boolean isValid = false;
		while(!isValid) {
			System.out.println("조회를 원하는 게시글 번호를 입력하십시오.");
	        System.out.print("선택 > ");
	    	try {
	        	int id = sc.nextInt();
	        	sc.nextLine();
	        	
	        	Article target = findById(articles, id);
	            if(target == null) {
	            	System.out.println("해당하는 게시글이 없습니다.");
	            }else {
	            	show(id);
	            	isValid = true;
	            }
	        // 숫자 이외의 것을 입력했을 경우 다시 입력받기
	        }catch (InputMismatchException e){	
            	System.out.println("=================================");
            	System.out.println("입력이 올바르지 않습니다. 다시 입력해주세요. ");
            	System.out.println("=================================");   	
            	// 버퍼 비워 주기
            	sc.nextLine();
	        }
	    }
	}


	@Override
	// 상세 보기 게시글 보여주기
	public void show(int page) {
		// TODO Auto-generated method stub
		Article article = findById(articles, page);

		// 조회수 2 증가 문제 해결
		// 조회수 증가를 findByArticle 메서드에서 하지 않고 이 부분에서 실행합니다.
		if (article != null) {
			article.increaseViewCount();
		}
		
		System.out.println("=================================");
        System.out.println("번호\t: " + article.getId());
        System.out.println("제목\t: " + article.getTitle());
        System.out.println("작성자\t: " + article.getWriter());
        System.out.println("작성일\t: " + article.getCreatedAt());
        System.out.println("조회수\t: " + article.getViewCount());
        System.out.println("=================================");
        System.out.println(); // 상세 조회 종료 후 한 줄 띄우기
	}

	// 모든 게시글을 반환하는 로직
	public void selectAll() {
		if(articles.isEmpty()) {
			System.out.println("등록된 게시글이 없습니다. ");
			return;
		}
		
		System.out.println("<<<<<< 전체 게시글 목록 >>>>>>");
		System.out.println("---------------------------------");
        System.out.printf("%-4s | %-20s | %-8s | %-10s | %-6s%n", "번호", "제목", "작성자", "작성일", "조회수");
        System.out.println("---------------------------------");
		
		for(Article article : articles) {
	        System.out.printf("%-4d | %-20s | %-8s | %-10s | %-6d%n",
	                article.getId(),
	                article.getTitle(),
	                article.getWriter(),
	                article.getCreatedAt(),
	                article.getViewCount());
		}
		System.out.println("---------------------------------");
	}
	
	// 특정 ID로 게시글을 찾아 반환하는 로직
	private Article findById(List<Article> articles, int id){
		for(Article article : articles) {
			if(article.getId() == id) {
				return article;
			}
		}
		return null;
	}
}
