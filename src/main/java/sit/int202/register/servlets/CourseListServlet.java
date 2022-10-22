package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.register.models.CourseRepository;
import sit.int202.register.models.Semester;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CourseListServlet", value = "/course-list")
public class CourseListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("semesters", Semester.getAllSemesterText()); //static method เรียกผ่าน class ไม่ต้อง new instance
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(
                request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        request.setCharacterEncoding("UTF-8");
        if (parameterMap.get("semester")==null) {
            doGet(request,response); //ไม่มีให้วนเลือกใหม่
            return;
        }
        //สามารถ get parameter ตัวเดียวโดยใช้ parameter map ได้
        int semester = Integer.valueOf(parameterMap.get("semester")[0]); //เอาข้อมูลของ semester ยัดใส่ map //เทอมที่ถูกเลือก
        request.setAttribute("semesters", Semester.getAllSemesterText());//ต้องส่งทั้งหมดไปด้วย ไม่งั้น หาย เพราะ response ไปแล้ว
        request.setAttribute("selectedSemester"
                , semester);
        request.setAttribute("subjects", CourseRepository.getSubjects(semester)); //แสดงวิชาของเทอมที่เลือก
        getServletContext().getRequestDispatcher("/course_list.jsp").forward(request,response);


    }
}
