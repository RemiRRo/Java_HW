import java.util.ArrayList;
import java.util.List;

class Student {
    private String surname;
    private String grade;
    private String subject;

    public Student(String surname, String grade, String subject) {
        this.surname = surname;
        this.grade = grade;
        this.subject = subject;
    }

    public String getSurname() {
        return surname;
    }

    public String getGrade() {
        return grade;
    }

    public String getSubject() {
        return subject;
    }
}

class Answer {
    public static void answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3) {
        System.out.println("Вход в метод answer");
        List<Student> students = new ArrayList<>();

        // Удалите пробелы, если есть, вокруг всех запятых и двоеточий в JSON
        JSON = JSON.replaceAll("\\s*,\\s*", ",");
        JSON = JSON.replaceAll("\\s*:\\s*", ":");

        // Парсинг JSON в список объектов Student
        // JSON = JSON.replaceAll("\"", ""); // Удаляем кавычки из JSON строки
        // JSON = JSON.replace("{", ""); // Удаляем открывающую и закрывающую фигурные скобки
        // JSON = JSON.replace("}", "");

        System.out.println(JSON);
        String[] studentArray = JSON.split(","); // Разделяем JSON строку по запятой для каждого студента
        for (String studentStr : studentArray) {
            String[] fields = studentStr.split(":"); // Разделяем поля студента по двоеточию
            if (fields.length == 3) {
                String surname = fields[0];
                String grade = fields[1];
                String subject = fields[2];
                students.add(new Student(surname, grade, subject));
            }
        }
            System.out.println(students.toString());
        // Форматированный вывод информации о студентах
        for (Student student : students) {
            String result = ELEMENT1 + student.getSurname() + ELEMENT2 + student.getGrade() + ELEMENT3 + student.getSubject();
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        String JSON = "";
        String ELEMENT1 = "";
        String ELEMENT2 = "";
        String ELEMENT3 = "";

        if (args.length == 0) {
            // При отправке кода на выполнение можно варьировать этими параметрами
            JSON = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                    "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                    "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
            ELEMENT1 = "Студент ";
            ELEMENT2 = "получил ";
            ELEMENT3 = "по предмету ";
        } else {
            JSON = args[0];
            ELEMENT1 = args[1];
            ELEMENT2 = args[2];
            ELEMENT3 = args[3];
        }

        answer(JSON, ELEMENT1, ELEMENT2, ELEMENT3);
    }
}