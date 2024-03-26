/*
 * File: CommentsBusinessLogic.java
 * Author: Benson Chang
 * Date: 2024.03.25
 * Description: The business logic for comments
 *
 * References:
 * [1] Stanley P. (2015). AuthorsBusinessLogic.java. Algonquin College, Ottawa.
 *     Retrieved from W10 - 2-AuthorsJSP.
 */
package businesslayer.forum;

import dataaccesslayer.forum.CommentDaoImpl;
import model.forum.Comment;

import java.util.List;

public class CommentsBusinessLogic {

    private CommentDaoImpl commentsDao = null;

    public CommentsBusinessLogic() {
        commentsDao = new CommentDaoImpl();
    }

    public List<Comment> getAllComments() {
        return commentsDao.getAllComments();
    }

    public boolean addComment(Comment comment) {
        return commentsDao.addComment(comment);
    }

    public Comment getCommentById(int commentId) {
        return commentsDao.getCommentById(commentId);
    }

    public boolean updateComment(Comment comment) {
        return commentsDao.updateComment(comment);
    }



}
