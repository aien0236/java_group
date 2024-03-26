<%@ page import="businesslayer.forum.PostsBusinessLogic" %>
<%@ page import="model.forum.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Benson
  Date: 2024-03-14
  Time: 10:25 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% PostsBusinessLogic postService = new PostsBusinessLogic();
    List<Post> posts = postService.getAllPosts(); %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forum</title>
    <!-- Customized Stylesheets -->
    <link rel="stylesheet" type="text/css" href="views/forum/css/style.css">
    <link rel="stylesheet" type="text/css" href="views/forum/css/home.css">
    <!-- Added an external JavaScript file with the 'defer' attribute to enable deferred loading -->
    <script src="views/forum/scripts/home.js" defer></script>
</head>

<body>
<!-- Main -->
<main>

    <div class="searchDiv">
        <!-- Filter -->
        <form id="filterForm">
            <input     type="text"  id="search"   name="search" placeholder="Search by title / content / category / author">
            <button    type="submit">Search</button><br>
            <!-- Radio buttons for filter type -->
            <div id="filterType"    class="filterType">
                <input type="radio" id="title"    name="filterType" value="title" checked>
                <label for="title">               Title</label>
                <input type="radio" id="content"  name="filterType" value="content">
                <label for="content">             Content</label>
                <input type="radio" id="category" name="filterType" value="category">
                <label for="content">             Category</label>
                <input type="radio" id="author"   name="filterType" value="author">
                <label for="content">             Author</label>
            </div>
        </form>
        <button id="addPost">+</button>
    </div>

    <!-- Add new post.jsp with image upload -->
    <div class="postDiv">
        <form id="postForm" enctype="multipart/form-data" action="Forum?purpose=add-post" method="post">

            <input  type="text"   id="title1"    name="title"    placeholder="Title"    required><br>
            <input  type="text"   id="category1" name="category" placeholder="Category" required><br>
            <input  type="text"   id="author1"   name="author"   placeholder="Author"   required><br>
            <textarea             id="content1"  name="content"  placeholder="Content"  required></textarea><br>
            <!-- Input for file upload -->
            <input  type="file"   id="image"     name="image"    accept="image/*"><br>
            <button type="button" id="uploadImg">Choose a Picture</button>
            <button type="submit">               Submit Post</button>

        </form>
        <button id="cancel">Cancel</button>
    </div>

    <!-- Posts -->
    <div id="posts" class="posts">
        <%
            for (Post post : posts) {
        %>
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
            </div>
        </div>
        <%
            }
        %>
    </div>

</main>
</body>
</html>
