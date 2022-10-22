/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int202.register.models;

import java.util.*;

/**
 * @author Khaitong Lim
 */
public class CourseRepository {
    private final static String DATA_FILE = "data.txt";
    private static final Map<Integer, List<Subject>> courses = new HashMap();

    static { //static block เรียกแล้ว static block จะทำงานทันที : constructor ของ static ไม่ต้อง new
        init();
    }

    public static List<Subject> getSubjects(int semester) {
        return courses.get(semester);
    }

    public static Subject getSubject(int semester, String subjectId) { //ส่ง เทอมไหนมา จะส่ง list วิชานั้นกลับไป
        for (Subject subject : courses.get(semester)) {
            if (subject.getSubjectId().equalsIgnoreCase(subjectId)) {
                return subject;
            }
        }
        return null;
    }

    public static void init() { //อ่านไฟล์ดาต้า อ่านเสร็จใส่ array แล้วก็แปลง array เป็น object แล้วค่อยแยกเก็บลงใน map
        Scanner sc = null;
        sc = new Scanner(CourseRepository.class.getClassLoader().getResourceAsStream("data.txt"), "utf-8");
        List<String[]> subjectList = new ArrayList(50);
        String dataLine[] = null;
        while (sc.hasNextLine()) {
            dataLine = sc.nextLine().split(",");
            int semester = Integer.valueOf(dataLine[0]);
            Subject subject = new Subject(dataLine[1], dataLine[2], Double.valueOf(dataLine[3]));
            if (courses.get(semester) == null) {
                courses.put(semester, new ArrayList<>());
            }
            courses.get(semester).add(subject);
        }
        sc.close();
    }

}