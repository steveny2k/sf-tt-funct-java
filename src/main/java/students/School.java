package students;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/*
@FunctionalInterface
interface StudentCriterion {
    */
/*public abstract *//*
boolean test(Student s);
//    void doStuff();
}

class SmartStudentCriterion implements StudentCriterion {
    private double threshold;

    public SmartStudentCriterion(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(Student s) {
        return s.getGpa() > threshold;
    }
}

class EnthusiasticStudentCriterion implements StudentCriterion {
    @Override
    public boolean test(Student s) {
        return s.getCourses().size() > 2;
    }
}


class RandomStupidClassName implements StudentCriterion {
    @Override
    public boolean test(Student s) {
        return s.getCourses().size() < 3;
    }
}
*/
public class School {
    public static void showAll(List<Student> ls) {
        for (Student s : ls) {
            System.out.println("> " + s);
        }
        System.out.println("------------------------------");
    }

    //    public static List<Student> getSmartStudents(List<Student> ls, double threshold) {
//        List<Student> res = new ArrayList<>();
//        for (Student s : ls) {
//            if (s.getGpa() > threshold) {
//                res.add(s);
//            }
//        }
//        return res;
//    }
//    public static List<Student> getEnthusiasticStudents(List<Student> ls, int threshold) {
//        List<Student> res = new ArrayList<>();
//        for (Student s : ls) {
//            if (s.getCourses().size() > threshold) { /// criterion.test(s) -> boolean
//                res.add(s);
//            }
//        }
//        return res;
//    }
    //                                                   Command pattern, object, for behavior, as argument
    public static List<Student> getStudentsByCriterion(List<Student> ls,
//                                                       StudentCriterion criterion) {
                                                       Predicate<Student> criterion) {
        List<Student> res = new ArrayList<>();
        for (Student s : ls) {
            if (criterion.test(s)) { // criterion(s)??? NO NO NO
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Student> roster = Arrays.asList(
                new Student("Fred", 3.5, "Math", "Physics"),
                new Student("Jim", 2.7, "Art"),
                new Student("Sheila", 3.9, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
        );
        showAll(roster);
//        showAll(getSmartStudents(roster, 3.5));
//        showAll(getSmartStudents(roster, 2.2));
//        showAll(getEnthusiasticStudents(roster, 2));
/*
        showAll(getStudentsByCriterion(roster, new SmartStudentCriterion(3.5)));
        showAll(getStudentsByCriterion(roster, new SmartStudentCriterion(2.2)));
        showAll(getStudentsByCriterion(roster, new EnthusiasticStudentCriterion()));
*/
//        showAll(getStudentsByCriterion(roster,
//                new StudentCriterion() {
//                    public boolean test(Student s) {
//                        return s.getCourses().size() < 3;
//                    }
//                }
//        ));
//        showAll(getStudentsByCriterion(roster,
//                /*new StudentCriterion()*/ /*{*/
//                    /*public boolean test*/(Student s) -> {
//                        return s.getCourses().size() < 3;
//                    }
//                /*}*/
//        ));
//        showAll(getStudentsByCriterion(roster, (Student s) -> { return s.getCourses().size() < 3; } ));
        showAll(getStudentsByCriterion(roster, s -> s.getCourses().size() < 3  ));
//        StudentCriterion calc = (Student s) -> { return s.getCourses().size() < 3; };
//        StudentCriterion calc = (s) -> { return s.getCourses().size() < 3; };
//        StudentCriterion calc = s -> { return s.getCourses().size() < 3; };
//        StudentCriterion calc;
        Predicate<Student> calc;
        calc = s -> s.getCourses().size() < 3 ;

//        Collections.sort(roster, (s1, s2) -> s1.getCourses().size() - s2.getCourses().size() );
        roster.sort((s1, s2) -> s1.getCourses().size() - s2.getCourses().size() );
        showAll(roster);

        showAll(getStudentsByCriterion(roster, Student::isEnthusiastic));
    }
}
