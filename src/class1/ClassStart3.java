package class1;

public class ClassStart3 {
    public static void main(String[] args) {
        Student a = new Student();
        a.name = "힉생1";
        a.age = 21;
        a.grade = 80;

        Student b = new Student();
        b.name = "학생2";
        b.age = 23;
        b.grade = 90;

        System.out.println("이름: "+a.name+" 나이: "+a.age);
    }
}
