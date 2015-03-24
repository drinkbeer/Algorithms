/**
 * Created by chen on 15/1/7.
 */
public class ClassTypeTest {
    public static void test1() {
        String s1 = null;
        String s2 = "";
        String s3 = "Hello";
        s3 = s3 + ", World!";
    }
}

class People{
    private String name;
    private String id;
    //Constructor
    public People(){
        this("","");
    }

    public People(String name, String _id) {
        this.name = name;
        id = _id;
    }

    public void sayHello(){
        System.out.println("Hello!My name is " + name);
    }
    public void sayHello(String name){
        System.out.println("Hello," + name + "! My name is " + name);
    }

    //getter&setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Student extends People{
    private String sId;//学号
    //Constructor
    public Student() {
        this("","","");
    }

    public Student(String name, String id, String sId) {
        super(name, id);
        this.sId = sId;
    }

    public void sayHello(){
        super.sayHello();
        System.out.println("I am a CS student");
    }
    //getter&setter
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }
}