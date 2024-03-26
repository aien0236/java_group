<%@ page import="businesslayer.forum.PostsBusinessLogic" %>
<%@ page import="model.forum.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.forum.Comment" %>
<%@ page import="businesslayer.forum.CommentsBusinessLogic" %><%--
  Created by IntelliJ IDEA.
  User: Benson
  Date: 2024-03-14
  Time: 10:25 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Variables Declaration--%>
<%
    PostsBusinessLogic postService              = new PostsBusinessLogic();
    CommentsBusinessLogic commentsBusinessLogic = new CommentsBusinessLogic();
    int postId                                  = Integer.parseInt(request.getParameter("postId"));
    Post post                                   = postService.getPostById(postId);
    List<Comment> comments                      = commentsBusinessLogic.getAllComments();
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Post</title>
    <!-- Customized Stylesheets -->
    <link rel="stylesheet" type="text/css" href="views/forum/css/style.css">
    <link rel="stylesheet" type="text/css" href="views/forum/css/home.css">
    <!-- Added an external JavaScript file with the 'defer' attribute to enable deferred loading -->
    <script src="views/forum/scripts/post.js" defer></script>
</head>

<body>
<!-- Main -->
<main>

    <!-- Post -->
    <div id="posts" class="posts">

        <!-- Post block -->
        <div class="post-card" id="post-card" data-post-id="<%= post.getId()%>">
            <div class="post-header">
                <span class="post-category"> <%= post.getCategory()%></span>
            </div>
            <img src="<%= post.getImage_path()%>" alt="" class="post-image">
            <div class="post-content">
                <div  class="post-meta">     <%= post.getDate()%>    </div>
                <h2   class="post-title">    <%= post.getTitle()%>   </h2>
                <p    class="post-excerpt">  <%= post.getContent()%> </p>
                <div  class="post-author">   <%= post.getAuthor()%>  </div>
                <div  class="post-actions">
                    <div class="post-action">Like</div>
                    <div id="commentButton" class="post-action">Comment</div>
                    <div class="post-action">Share</div>
                </div>
            </div>

        </div>

        <!-- Comments block -->
        <%
            if (comments != null){
                for (Comment comment : comments) {
        %>
                    <div class="comment-header">
                        <div>
                            <span class="comment-profile-name"><%= comment.getAuthor()%></span>
                            <span class="comment-profile-verified">&#10003;</span>
                        </div>
                    </div>
                    <div class="comment-content">
                        <%= comment.getComment()%>
                    </div>
        <%
                }
            }
        %>
    </div>


</main>
</body>
</html>
