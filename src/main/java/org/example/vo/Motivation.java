package org.example.vo;

public class Motivation {

    int id = 0; // 번호
    String body = null; // 명언
    String author = null; //저자


    public Motivation(int id, String body, String author) {
        this.id = id;
        this.body = body;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
