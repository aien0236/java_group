/*
 * File:        home.js
 * Author:      Benson Chang
 * Date:        2024.03.25
 * Description: For controlling the page post.jsp
 */

// view post.jsp
document.addEventListener('DOMContentLoaded', function() {
    var postCards = document.querySelectorAll('.post-card');
    postCards.forEach(function(postCard) {
        postCard.addEventListener('click', function() {
            // get the post id
            var postId = this.dataset.postId;
            // redirect to a new page
            window.location.href = 'Post?postId=' + postId + '&purpose=view-post';
        });
    });
});

// For searching post
const searchInput = document.getElementById('search');
const filterTypeDiv = document.getElementById('filterType');

searchInput.addEventListener('input', function () {

    const searchText = searchInput.value.trim();

    if (searchText !== '') {
        filterTypeDiv.style.display = 'block';
        filterTypeDiv.style.opacity = 1;
    } else {
        filterTypeDiv.style.opacity = 0;
        filterTypeDiv.style.display = 'none';
    }
});

// For adding post
const postForm = document.getElementById('postForm');
const addPost = document.getElementById('addPost');
const cancel = document.getElementById('cancel');

addPost.addEventListener('click', function () {
    postForm.style.display = 'block';
    cancel.style.display = 'inline-block';
});

cancel.addEventListener('click', function () {
    postForm.style.display = 'none';
    cancel.style.display = 'none';
});

const uploadImg = document.getElementById('uploadImg');
const fileInput = document.getElementById('image');

uploadImg.addEventListener('click', function () {
    fileInput.click();
});
