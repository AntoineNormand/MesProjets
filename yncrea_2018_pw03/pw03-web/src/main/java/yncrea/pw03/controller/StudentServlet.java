package yncrea.pw03.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yncrea.pw03.config.AppConfig;
import yncrea.pw03.entity.Student;
import yncrea.pw03.service.StudentService;
import yncrea.pw03.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/students")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;
    private ConfigurableApplicationContext context;

    @Override
    public void init() throws ServletException {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        studentService = context.getBean(StudentService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentService",studentService);
        req.setAttribute("context",context);
        List<Student> studentList = studentService.findAll();
        req.getSession().setAttribute("studentList",studentList);
        req.getServletContext().getRequestDispatcher("/Students.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {
        context.close();
    }
}
