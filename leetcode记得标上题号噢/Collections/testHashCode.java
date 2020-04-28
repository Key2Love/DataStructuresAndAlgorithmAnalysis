package Collections;

import java.util.HashSet;

/**
 * @program: algorithm
 * @description:
 * @author: Sunbuhui7
 * @create: 2020-03-15 17:38
 **/

public class testHashCode {
    /**
     * 输出如下
     * false 比较的地址引用
     * true
     * 96321
     * 96321
     * aaa
     * @param args
     */
    public static void main(String[] args) {
        //重写了hashcode()方法，使得只要字符串相同，hash就相同
        String s1=new String("aaa");
        String s2=new String("aaa");
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);
        for(String it:hashSet){
            System.out.println(it);
        }
    }

    /**
     * 如果不重写Student类中equals和hashcode()的代码，HashSet就会添入重复项。
     */
    public void call(){
        HashSet<Student> students = new HashSet<>();
        students.add(new Student(1,"21"));
        students.add(new Student(2,"1"));
        students.add(new Student(1,"21"));
        for (Student it:students){
            System.out.println(it.name);
        }


    }
}
class Student{
    int num;
    String name;
    public Student(int num,String  name){
        this.num= num;
        this.name= name;
    }
    @Override
    public int hashCode(){
        return num*name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return num == s.num && name.equals(s.name);
    }
}
