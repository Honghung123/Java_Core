package com.honghung.JAVA_8;

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream; 

record Student(String name, int age)  { 
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    public void display() {
        System.out.println(this.toString());
    }
}

public class PredicateClass {
    public static void main(String[] args) {
        Student student1 = new Student("Hong Hung", 19);
        Student student2 = new Student("Hong Huy", 15);
        Student student3 = new Student("Thanh Hung", 29);
        Student student4 = new Student("Nguyen Hung", 21);
        Student student5 = new Student("Hong Phat", 18);
        
        Predicate<Student> ageCondition = getAgeCondition();
        Predicate<Student> nameEquals = (Student student) -> student.name().contains("Hong");
        System.out.println(ageCondition.and(nameEquals).test(student1));
        List<Student> list = new ArrayList<Student>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        showListStudent18Above(ageCondition.or(nameEquals), list);

        System.out.println(" - ".repeat(10));
        Predicate<Student> negatePredicate = ageCondition.negate();
        showNegatePredicate(negatePredicate, list);

        Comparator<Student> compareAge = (s1, s2) -> 
            Integer.valueOf(s1.age()).compareTo(Integer.valueOf(s2.age()));
        list.sort(compareAge);
        System.out.println(" - ".repeat(10));
        list.forEach(Student::display);

        System.out.println("Predicate for primative types: ");
        IntPredicate intPredicate = isGreaterThan50();
        System.out.println(intPredicate.test(51)); // true
        var listInt = IntStream.range(0, 10).map(value -> value * 7);
        // Predicate parent = (Predicate) intPredicate;
        listInt.filter(intPredicate).forEach(System.out::println);

        System.out.println(findStudent().test("Dam Hong Hung", 20));
        System.out.println("List of students is aldult: ");
        Map<String, Integer> listStudent = list.stream()
                .collect(Collectors.toMap(
                        student -> student.name(), // Key mapper function
                        student -> student.age()  // Value mapper function 
                ));
        listStudent.forEach((name, age) -> {
            if(findStudent().test(name, age)){
                System.out.println("Name: " + name + " age: " + age);
            }
        });
    }
    
    public static void showListStudent18Above(Predicate<Student> predicate, List<Student> list) {
        System.out.println("Test default method AND: ");
        list.stream().filter(predicate).forEach(Student::display);
    }
    
    public static void showNegatePredicate(Predicate<Student> ageConditionNegate, List<Student> list) {
        System.out.println("Test default method NEGATE: ");
        list.stream().filter(ageConditionNegate).forEach(Student::display);
    }
    
    public static <T extends Student> Predicate<T> getAgeCondition() {
        return student -> student.age() > 18;
    }

    public static IntPredicate isGreaterThan50() {
        return currentNumber -> currentNumber > 50;
    }

    public static BiPredicate<String, Integer> findStudent() {
        return (name, age) -> name.contains("Hong") && age > 18;
    }
}
