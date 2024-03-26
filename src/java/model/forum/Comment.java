/* File: Comment.java
 * Author: Shang-Yuan Chang
 * Date: 2024.3.25
 * Modified:
 * Description: DTO for comments
 */
package model.forum;

import java.sql.Timestamp;

public class Comment {

    private int id;
    private String comment;
    private String author;
    private int post_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    /**
     * Return string representation of food.
     * Can be used for testing purposes.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", author='" + author + '\'' +
                ", post_id=" + post_id +
                '}';
    }
}
