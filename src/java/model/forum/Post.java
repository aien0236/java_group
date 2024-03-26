/* File: Post.java
 * Author: Shang-Yuan Chang
 * Date: 2024.3.25
 * Modified:
 * Description: DTO for posts
 */
package model.forum;

import java.sql.Timestamp;

public class Post {


    private int id;
    private String title;
    private String content;
    private String category;
    private String image_path;
    private String author;
    private Timestamp date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    /**
     * Return string representation of food.
     * Can be used for testing purposes.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", image_path='" + image_path + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }
}
