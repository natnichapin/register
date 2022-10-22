package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CourseRegisterHistoryServlet", value = "/course-registered-history")
public class CourseRegisterHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session==null || session.getAttribute("courseRegistered")==null) {
            request.setAttribute("message", "ไม่มีข้อมูล การลงทะเบียน ขอให้ลงทะเบียนก่อน");
        }
        getServletContext().getRequestDispatcher("/user_registered.jsp").forward(request,response);
    }
//คลิกเมนู = link วิ่งผ่าน get  จะเป็น post ได้ก็ต่อเมื่อ submit ผ่าน from
    //ส่งข้อมูลไป ทำงานหลังบ้าน = post
    //Stop = session หายหมด
    //วนลูปข้อมูล บน map จะรีเทินเป็น entry
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
