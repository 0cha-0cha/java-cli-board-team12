package function;

import static function.PrintUtil.*;

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
			slowPrintChar("조회를 원하는 게시글 번호를 입력하세요.\n", 50);
	        slowPrintChar("선택 > ", 50);
	    	try {
	        	int id = sc.nextInt();
	        	sc.nextLine();
	        	
	        	Article target = findById(articles, id);
	            if(target == null) {
	            	slowPrintChar("해당하는 게시글이 없습니다.\n", 50);
	            }else {
	            	show(id);
	            	isValid = true;
	            }
	        // 숫자 이외의 것을 입력했을 경우 다시 입력받기
	        }catch (InputMismatchException e){	
            	slowPrintLine("=================================", 100);
            	slowPrintChar("입력이 올바르지 않습니다. 다시 입력해주세요.\n", 50);
				slowPrintLine("=================================", 100);
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
		slowPrintChar(page + " 번 게시물 불러오는 중...\n", 50);
		slowPrintChar("........", 100);
		clear();
		slowPrintChar("게시글 정보를 불러왔습니다.\n", 50);
		slowPrintLine("=================================", 100);
        slowPrintLine("번호\t: " + article.getId(), 200);
        slowPrintLine("제목\t: " + article.getTitle(), 200);
        slowPrintLine("작성자\t: " + article.getWriter(), 200);
        slowPrintLine("작성일\t: " + article.getCreatedAt(), 200);
        slowPrintLine("조회수\t: " + article.getViewCount(),200);
		slowPrintLine("=================================", 100);
        System.out.println(); // 상세 조회 종료 후 한 줄 띄우기
	}

	// 모든 게시글을 반환하는 로직
	public void selectAll() {
		if(articles.isEmpty()) {
			slowPrintChar("등록된 게시글이 없습니다.\n", 50);
			return;
		}
		slowPrintChar("게시물 목록을 불러오는 중...\n", 50);
		slowPrintChar("........................\n", 100);

		clear();
		slowPrintChar("게시글 목록을 불러왔습니다.\n", 50);

		System.out.println();
		slowPrintLine("                    <<<<<< 전체 게시글 목록 >>>>>>", 500);
		slowPrintLine("----------------------------------------------------------------------", 100);
		String header = String.format("%-4s | %-20s | %-8s | %-10s | %-6s", "번호", "제목", "작성자", "작성일", "조회수");
		slowPrintLine(header, 200);
		slowPrintLine("----------------------------------------------------------------------", 100);

		for(Article article : articles) {
			String row = String.format("%-4d | %-20s | %-8s | %-10s | %-6d",
					article.getId(),
	                article.getTitle(),
	                article.getWriter(),
	                article.getCreatedAt(),
	                article.getViewCount());
			slowPrintLine(row, 200);
		}
		slowPrintLine("---------------------------------", 100);
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
