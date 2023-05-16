package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ChannelService;

import java.io.IOException;
@WebServlet("/")
public class ChannelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ChannelService channelService=new ChannelService();
        var a=  channelService.getAll();
        req.setAttribute("channelList",a);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("WEB-INF/channel.jsp");
        requestDispatcher.forward(req, res);
    }
}
