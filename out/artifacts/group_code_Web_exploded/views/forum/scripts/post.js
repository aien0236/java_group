/*
 * File:        post.js
 * Author:      Benson Chang
 * Date:        2024.03.25
 * Description: For controlling the page post.jsp
 */

const commentButton = document.getElementById("commentButton");
commentButton.addEventListener('click', function () {
    const postsDiv = document.getElementById('posts');
    const postCard = document.getElementById('post-card');
    const addComment = document.createElement('form');
    addComment.id = 'comForm';
    addComment.action = 'CommentServlet';
    addComment.method = 'post';
    addComment.innerHTML = `
            <div class="comment-card">
                <div class="comment-header">
                    <input class="comment-profile-name" type="text" id="comName" name="comName" placeholder="Name" required>
                </div>
                <input class="comment-content" type="text" id="comContent" name="comContent" placeholder="Content" required>
                <button type="submit">Submit</button>
            </div>
            `;
    if (postCard.nextSibling) {
        postsDiv.insertBefore(addComment, postCard.nextSibling);
    } else {
        postsDiv.appendChild(addComment);
    }
})