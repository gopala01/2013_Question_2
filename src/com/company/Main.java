package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MAX_STUDENTS = 500;

        int i = 0;
        String[] idArray = new String[MAX_STUDENTS];

        String[] grade1Array = new String[MAX_STUDENTS];
        String[] grade2Array = new String[MAX_STUDENTS];
        String[] grade3Array = new String[MAX_STUDENTS];
        String[] grade4Array = new String[MAX_STUDENTS];

        String[] overallGradesArray = new String[MAX_STUDENTS];

        inputArrays(MAX_STUDENTS, i, idArray, grade1Array, grade2Array, grade3Array, grade4Array);

        inputOverallGrades(overallGradesArray, grade1Array, grade2Array, grade3Array, grade4Array);

        printArrays(idArray, grade1Array, grade2Array, grade3Array, grade4Array, overallGradesArray);
    }

    public static void inputOverallGrades(String[] overallGradesArray, String[] grade1Array, String[] grade2Array, String[] grade3Array, String[] grade4Array)
    {
        for (int i = 0; i < grade1Array.length; i++) {
            overallGradesArray[i] = calcFinalGrade(i, grade1Array,grade2Array,grade3Array,grade4Array);
        }
    }


    public static void printArrays(String[] idArray, String[] grade1Array, String[] grade2Array, String[] grade3Array, String[] grade4Array, String[] overallGrades)
    {
        for (int i = 0; i < idArray.length; i++) {
            print("Student " + idArray[i]);
            print("Grade 1 - " + grade1Array[i]);
            print("Grade 2 - " + grade2Array[i]);
            print("Grade 3 - " + grade3Array[i]);
            print("Grade 4 - " + grade4Array[i]);
            print("Overall Grade -  "+overallGrades[i]);
        }
    }
    public static String calcFinalGrade(int i, String[] grade1Array, String[] grade2Array, String[] grade3Array, String[] grade4Array)
    {
        int numAGrades = countGrades(i, "A", grade1Array, grade2Array, grade3Array, grade4Array);
        int numBGrades = countGrades(i, "B", grade1Array, grade2Array, grade3Array, grade4Array);
        int numCGrades = countGrades(i, "C", grade1Array, grade2Array, grade3Array, grade4Array);
        int numDGrades = countGrades(i, "D", grade1Array, grade2Array, grade3Array, grade4Array);
        int numEGrades = countGrades(i, "E", grade1Array, grade2Array, grade3Array, grade4Array);

        if (numAGrades >= 3)
        {
            return "A";
        }
        else if (numBGrades>= 3)
        {
            return "B";
        }
        else if (numCGrades>= 3)
        {
            return "C";
        }
        else if (numDGrades>= 3)
        {
            return "D";
        }
        else if (numEGrades >= 3)
        {
            return "E";
        }
        else
        {
            return "F";
        }
    }

    public static int countGrades(int i, String targetGrade, String[] grade1Array, String[] grade2Array, String[] grade3Array, String[] grade4Array)
    {
        int count = 0;
        if (grade1Array[i].equals(targetGrade))
        {
            count++;
        }
        if (grade2Array[i].equals(targetGrade))
        {
            count++;
        }
        if (grade3Array[i].equals(targetGrade))
        {
            count++;
        }
        if (grade4Array[i].equals(targetGrade))
        {
            count++;
        }
        return count;
    }

    public static void inputArrays(int MAX, int i, String[] idArray, String[] grade1Array, String[] grade2Array, String[] grade3Array, String[] grade4Array)
    {
        String id = inputString("What is your ID?");
        while (!id.equals("0") && i != MAX)
        {

            idArray[i] = id;
            grade1Array[i] = inputString("What is your grade 1?");
            grade2Array[i] = inputString("What is your grade 2?");
            grade3Array[i] = inputString("What is your grade 3?");
            grade4Array[i] = inputString("What is your grade 4?");

            i++;
            id = inputString("What is your ID?");
        }
    }
    public static void print(String m)
    {
        System.out.println(m);
    }

    public static String inputString(String m) {
        String answer;
        Scanner scanner = new Scanner(System.in);

        print(m);
        answer = scanner.nextLine();
        return answer;
    }

}
