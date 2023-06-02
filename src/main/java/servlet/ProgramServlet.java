package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProgramService;

import java.io.IOException;

@WebServlet("/program")
public class ProgramServlet extends HttpServlet {

    private final ProgramService programService;

    public ProgramServlet(ProgramService programService) {
        this.programService = programService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("act");
        switch (action) {
            case "delete":{
                deleteProgram(req, res);
                break;
            }
            case "update":{
               // updateProgram(req, res);
                break;
            }

        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doGet(req, res);
    }
    private void deleteProgram(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Long id =Long.parseLong(req.getParameter("id"));
        programService.delete(id);
        req.setAttribute("program",programService.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/program.jsp");
        requestDispatcher.forward(req, res);


    }
}
