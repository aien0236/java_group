/*
 * File: CommentDataAccessObjectImplementation.java
 * Author: Benson Chang
 * Date: 2024.03.25
 * Description: Implementation of DAO Design Pattern with Servlet website
 *
 * References:
 * [1] Stanley P. (2015). AuthorsBusinessLogic.java. Algonquin College, Ottawa.
 *     Retrieved from W10 - 2-AuthorsJSP.
 * [2] Ram N. (2013).  Data Access Object Design Pattern or DAO Pattern [blog] Retrieved from
 *     http://ramj2ee.blogspot.in/2013/08/data-access-object-design-pattern-or.html
 */

package dataaccesslayer.forum;

import dataaccesslayer.DataSource;
import model.forum.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl {

    public CommentDaoImpl() {
    }

    public List<Comment> getAllComments() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Comment> comments = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM comments");
            rs = pstmt.executeQuery();
            comments = new ArrayList<Comment>();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setComment(rs.getString("comment"));
                comment.setAuthor(rs.getString("author"));
                comment.setPost_id(rs.getInt("post_id"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return comments;
    }

    public boolean addComment(Comment comment) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean updateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO comments (comment_name, expiration_date, flag, donated, price, discount, commenttype, quantity, retailer_id) " +
                    "VALUES(?, ?, ?, false, ?, ?, ?, ?, ?)");
            pstmt.setString(4, comment.getComment());
            pstmt.setString(5, comment.getAuthor());
            pstmt.setInt(6, comment.getPost_id());
            // execute insert
            int rowsAffected = pstmt.executeUpdate();

            // true if a row was updated, so the insert was successful
            if (rowsAffected > 0) {
                updateState = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return updateState;
    }

    public Comment getCommentById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Comment comment = null;
        ResultSet rs;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("SELECT * FROM comments WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setComment(rs.getString("comment"));
                comment.setAuthor(rs.getString("author"));
                comment.setPost_id(rs.getInt("post_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return comment;
    }

    public boolean updateComment(Comment comment) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean updateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("UPDATE comments SET comment_name = ?, expiration_date = ?, flag = ?, donated = ?, price = ?, discount = ?, commenttype = ?, quantity = ?, retailer_id = ? " +
                    "WHERE id = ?");
            pstmt.setString(4, comment.getComment());
            pstmt.setString(5, comment.getAuthor());
            pstmt.setInt(6, comment.getPost_id());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                updateState = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return updateState;
    }
}
