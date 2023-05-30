package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/program")
public class ProgramServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //the channel id you want to get
//        String id=req.getParameter("id");
//        long programId=Long.parseLong(id);
//        ChannelService cs=new ChannelService();
//        //channel
//        Channel c= cs.getById(programId);
//        req.setAttribute("channel",c);
//        //load channel programs
//        ProgramService ps=new ProgramService();
//        req.setAttribute("programs",ps.loadProgram(programId));
//        req.getRequestDispatcher("WEB-INF/program.jsp").forward(req,res);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/program.jsp");
        requestDispatcher.forward(req, res);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doGet(req, res);
    }
}
