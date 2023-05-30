package servlet;

import Entity.Program;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ChannelService;
import service.ProgramService;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ChannelServlet extends HttpServlet {
    ChannelService channelService=new ChannelService();
    ProgramService programService=new ProgramService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":{
                getAllChannel(req, res);
                break;
            }
            case "program":{
                showProgram(req, res);
                break;
            }

        }
    }
    protected void showProgram(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        long id=Long.parseLong(req.getParameter("id"));
        List<Program> channel_fk=programService.loadProgram(id);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/program.jsp");
        req.setAttribute("program", channel_fk);
        requestDispatcher.forward(req, res);

    }
    private void getAllChannel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ChannelService channelService=new ChannelService();
        var a=  channelService.getAll();
        req.setAttribute("channelList",a);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/channel.jsp");
        requestDispatcher.forward(req, res);
    }


}
