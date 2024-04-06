/*
 * File:        PostDaoImpl.java
 * Author:      Benson Chang
 * Date:        2024.03.25
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
import model.forum.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImpl {

    public PostDaoImpl() {
    }

    public List<Post> getAllPosts() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Post> posts = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "SELECT * FROM posts order by id desc");
            rs = pstmt.executeQuery();
            posts = new ArrayList<Post>();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setCategory(rs.getString("category"));
                post.setImage_path(rs.getString("image_path"));
                post.setAuthor(rs.getString("author"));
                post.setDate(rs.getTimestamp("date"));
                posts.add(post);
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
        return posts;
    }

    public boolean addPost(Post post) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean updateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("INSERT INTO posts (title, content, category, image_path, author, date) " +
                    "VALUES(?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getCategory());
            pstmt.setString(4, post.getImage_path());
            pstmt.setString(5, post.getAuthor());
            pstmt.setTimestamp(6, post.getDate());
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

    public Post getPostById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Post post = null;
        ResultSet rs;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            // do not insert AuthorID, it is generated by Database
            pstmt = con.prepareStatement("SELECT * FROM posts WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setCategory(rs.getString("category"));
                post.setImage_path(rs.getString("image_path"));
                post.setAuthor(rs.getString("author"));
                post.setDate(rs.getTimestamp("date"));
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
        return post;
    }

    public boolean updatePost(Post post) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean updateState = false;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement("UPDATE posts SET post_name = ?, expiration_date = ?, flag = ?, donated = ?, price = ?, discount = ?, posttype = ?, quantity = ?, retailer_id = ? " +
                    "WHERE id = ?");
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getCategory());
            pstmt.setString(4, post.getImage_path());
            pstmt.setString(5, post.getAuthor());
            pstmt.setTimestamp(6, post.getDate());

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

    public void deletePost(int postId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(
                    "DELETE FROM posts WHERE id = ?");
            pstmt.setInt(1, postId);
            pstmt.executeUpdate();
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
    }
}
