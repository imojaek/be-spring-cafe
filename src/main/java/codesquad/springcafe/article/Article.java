package codesquad.springcafe.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

public class Article {

    private final String writer;
    private String title;
    private String content;
    private Long articleId;
    private LocalDateTime createdTime;

    public Article(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.createdTime = LocalDateTime.now();
    }

    public Article(String writer, String title, String content, Long articleId, LocalDateTime createdTime) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.articleId = articleId;
        this.createdTime = createdTime;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getWriter() {
        return writer;
    }

//    글쓴이를 수정하지 않기 때문에 제거
//    public void setWriter(String writer) {
//        this.writer = writer;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
    public String getFormattedTime() {
        String formattedTime = this.createdTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        return formattedTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "articleId : " + articleId + ", writer : " + writer + ", title : " + title + ", content : " + content;
    }
}
