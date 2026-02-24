package function;

import data.Article;
import java.util.ArrayList;
import java.util.List;

public class BoardService {

    private List<Article> articles = new ArrayList<>();
    private int nextId = 1;

    private CreateService createService;
    private ReadService readService;
    private UpdateService updateService;
    private DeleteService deleteService;

    public BoardService() {
        createService = new CreateService();
        readService = new ReadService();
        updateService = new UpdateService();
        deleteService = new DeleteService();
        
     // --- 로컬 테스트용 더미 데이터 생성 ---
        // nextId를 사용하여 ID를 부여하고, 사용 후 1씩 증가시킵니다.
        articles.add(new Article(nextId++, "첫 번째 공지사항", "반갑습니다. 게시판입니다.", "관리자"));
        articles.add(new Article(nextId++, "Java 공부하는 법", "꾸준히 하는 것이 중요합니다.", "공부왕"));
        // ----------------------------------
    }

    // 게시글 등록 메소드 (형성빈)
    public void addArticle(String title, String content, String writer) {

    }

    // 게시글 수정 메소드 (이근찬)
    public void updateArticle(int articleId, String newTitle, String newContent) {
    	
    }

    // 게시글 삭제 메소드 (손주현)
    public void deleteArticle(int articleId) {

    }

    // 게시글 조회 메소드 (표지민) _ 모든 게시글 조회
    public List<Article> getAllArticles() {
    	readService.findAll(this.articles);
    }

    // 게시글 조회 메소드 (표지민) _ 특정 ID로 게시글 조회
    public Article getArticleById(int articleId) {
    	readService.findById(this.articles, articleId)
    }

}

