package com.ll.exam;

import com.ll.exam.article.ArticleController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Rq rq = new Rq(req, resp);

        ArticleController articleController = new ArticleController();

        String Uri = req.getRequestURI();

        switch (rq.getMethod()){
            case "GET":
                switch (Uri) {
                    case "/usr/article/list/free":
                        articleController.showList(rq);
                        break;
                    case "/usr/article/write/free":
                        articleController.showWrite(rq);
                        break;
                }
                break;

            case "POST":
                switch (Uri) {
                    case "/usr/article/list/free":
                        articleController.doWrite(rq);
                        break;
                }
            break;
        }
    }
}
