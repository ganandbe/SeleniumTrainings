package Javaprograms;

public class Constructor1 {

    String name;
    int id;
    int age;

    public Constructor1(String n,int i){
        name=n;
        id=i;
    }

    public Constructor1(String n,int i,int k){

        name=n;
        id=i;
        age=k;
    }

    public void print(){
        System.out.println("Student name...."+name);
        System.out.println("Student id...."+id);
        System.out.println("Student Age...."+age);

    }

    public Constructor1(){

        System.out.println("Student details list");


    }


    public static void main (String args[]){
        Constructor1 c1 = new Constructor1("Anand",001);
        Constructor1 c4 = new Constructor1("Anand",001,28);
        Constructor1 c5 = new Constructor1();
        c1.print();
        c4.print();

    }



}
