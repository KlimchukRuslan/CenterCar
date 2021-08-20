package com.centercity.server.servlets;

import com.centercity.server.work.GpsApi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/car")
public class DataGps extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("button1") != null) {

            String dateOne = request.getParameter("dateOne");
            String dateEnd = request.getParameter("dateTwo");
            try {
                List list = GpsApi.postRequest(dateOne, dateEnd);
                request.setAttribute("car_list", list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request.getRequestDispatcher("pages/car_data.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("pages/car_data.jsp").forward(request, response);

    }

}
