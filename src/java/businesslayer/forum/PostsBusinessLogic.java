/*
 * File: PostsBusinessLogic.java
 * Author: Benson Chang
 * Date: 2024.03.25
 * Description: The business logic for posts
 *
 * References:
 * [1] Stanley P. (2015). AuthorsBusinessLogic.java. Algonquin College, Ottawa.
 *     Retrieved from W10 - 2-AuthorsJSP.
 */
package businesslayer.forum;

import dataaccesslayer.FoodDaoImpl;
import dataaccesslayer.forum.PostDaoImpl;
import model.food.Food;
import model.forum.Comment;
import model.forum.Post;

import java.util.List;

public class PostsBusinessLogic {

    private PostDaoImpl postsDao = null;

    public PostsBusinessLogic() {
        postsDao = new PostDaoImpl();
    }

    public List<Post> getAllPosts() {
        return postsDao.getAllPosts();
    }

    public boolean addPost(Post post) {
        return postsDao.addPost(post);
    }

    public Post getPostById(int postId) {
        return postsDao.getPostById(postId);
    }

    public boolean updatePost(Post post) {
        return postsDao.updatePost(post);
    }

    public void deletePostById(int postId){
        postsDao.deletePost(postId);
    }

}
