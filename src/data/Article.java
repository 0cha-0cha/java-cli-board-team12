package data;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {
    private int id;
    private String title;
    private String content;
    private String writer;
    private final LocalDate createdAt;
    private int viewCount;

    public Article(int Id, String title, String content, String writer) {
        setId(Id);
        setTitle(title);
        setContent(content);
        setWriter(writer);
        this.createdAt = LocalDate.now();  //생성 시 createdAt 자동 세팅
        this.viewCount = 0; //viewCount 0 시작
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getWriter() {
        return writer;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void increaseViewCount() {
        this.viewCount++;
    }
}