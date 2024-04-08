/*
 * File: ForumServlet.java
 * Author: Benson Chang
 * Date: 2024.03.25
 * Description: Implementation of Servlet website
 *
 * References:
 * [1] Unknown. AuthorServlet.java. Algonquin College, Ottawa.
 *     Retrieved from W10 - 2-AuthorsJSP.
 */
package controller.forum;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import businesslayer.forum.PostsBusinessLogic;
import model.forum.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.Date;

@MultipartConfig
public class ForumServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("In ForumServlet.doGet()");
        String purpose  = request.getParameter("purpose");
        if (purpose != null){
            switch (purpose){
                case "view-post":
                    request.getRequestDispatcher("views/forum/post.jsp").forward(request, response);
                    break;

                case "add-post":
                    request.getRequestDispatcher("views/forum/home.jsp").forward(request, response);
                    break;

                default:
                    request.getRequestDispatcher("views/forum/home.jsp").forward(request, response);
                    break;
            }

        }else {
            request.getRequestDispatcher("views/forum/home.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("In ForumServlet.doPost()");
        String purpose  = request.getParameter("purpose");
        switch (purpose){
            case "add-post":
                addPost(request, response);
                doGet(request, response);
                break;

            default:
                break;
        }


    }

    private void addPost(HttpServletRequest request, HttpServletResponse response) {
        // need to be multipart/form-data type
        String title      = request.getParameter("title");
        String category   = request.getParameter("category");
        String content    = request.getParameter("content");
        String author     = request.getParameter("author");
        // the file part
        Part filePart     = null;
        try {
            filePart = request.getPart("image");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
        String fileName   = getFileName(filePart);
        String uploadPath = getServletContext().getRealPath("") + "views" + File.separator + "forum" + File.separator + "images";
        File uploadsDir = new File(uploadPath);
        if (!uploadsDir.exists()) {
            uploadsDir.mkdirs();
            System.out.println("Directory created at: " + uploadPath);
        } else {
            System.out.println("Directory already exists at: " + uploadPath);
        }
        String filePath = uploadPath + File.separator + fileName;
        String basePath = "views" + File.separator + "forum" + File.separator + "images" + File.separator + fileName;

        // sava data
        try (InputStream fileContent = filePart.getInputStream()) {
            File fileToSave = new File(filePath);
            System.out.println(filePath);
            Files.copy(fileContent, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // error handling
            System.out.println("File upload failed: " + e);
        }

        // other fields
        PostsBusinessLogic postsBusinessLogic = new PostsBusinessLogic();
        Post post = new Post();
        post.setCategory(category);
        post.setImage_path(basePath);
        post.setAuthor(author);
        post.setContent(content);
        post.setTitle(title);
        post.setDate(new Timestamp(new Date().getTime()));
        postsBusinessLogic.addPost(post);
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp != null) {
            for (String cd : contentDisp.split(";")) {
                if (cd.trim().startsWith("filename")) {
                    String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                    return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
                }
            }
        }
        return null;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
