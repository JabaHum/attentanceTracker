package com.example.attentancetracker.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.attentancetracker.Model.CourseUnits;
import com.example.attentancetracker.Model.Students;

import static android.content.ContentValues.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    public static final String DATABASE_NAME = "attendance_tracker_app.db";

    //table names
    public static final String TABLE_STUDENTS = "students_table";
    private static final String TABLE_COURSE_UNITS ="courseunits_table";

    // Common column names
    public static final String COL_1="ID";
    private static final String COL_7 ="created_at";

    //Students Table = Column Names
    public static final String COL_2="STUDENTS_REGNO";
    public static final String COL_3="STUDENTS_NAME";
    public static final String COL_8= "STUDENTS_PROGRAM";
    public static final String COL_9 = "STUDENT_SEX";

    //Course Units Tables = Column Names
    public static final String COL_5="COURSE_NO";
    public static final String COL_4="COURSE_UNIT";
    public static final String COL_6 ="LECTURER";
    public static final String COL_10 = "SEMESTER_TAUGHT";

    //

    //create students table
    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE "
            + TABLE_STUDENTS
            + "("
            + COL_1 + " INTEGER  PRIMARY KEY AUTOINCREMENT,"
            + COL_2 + " INTEGER,"
            + COL_3 + " TEXT,"
            + COL_8 + " TEXT,"
            + COL_9 + " TEXT,"
            + COL_7 + "DATETIME"
            +")";
    private  static final String CREATE_TABLE_COURSE_UNITS = "CREATE TABLE "
            + TABLE_COURSE_UNITS
            + "("
            + COL_1 + " INTEGER  PRIMARY KEY AUTOINCREMENT,"
            + COL_5 + " INTEGER,"
            + COL_4 + " TEXT,"
            + COL_6 + " TEXT,"
            + COL_10 + "TEXT,"
            + COL_7 + "DATETIME"
            +")";


    public DatabaseHelper( Context context, String DATABASE_NAME, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating required table
        db.execSQL(CREATE_TABLE_STUDENTS);
        db.execSQL(CREATE_TABLE_COURSE_UNITS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //deleting table if it exists
        db.execSQL(" DROP TABLE IF EXISTS "+TABLE_STUDENTS);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_COURSE_UNITS);

        //Create new tables if table doesnot exist
        onCreate(db);
    }

    //Creating a student/taking attendance
    private void addCourse(CourseUnits courseUnits){
        int id = courseUnits.getId();
        String courseNo = courseUnits.getCourseNo();
        String courseName = courseUnits.getCourseUnit();
        String courseLecturer = courseUnits.getCourseLecturer();
        String courseSemester =courseUnits.getCourseSemester();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_1,id);
        values.put(COL_5,courseNo);
        values.put(COL_4,courseName);
        values.put(COL_6,courseLecturer);
        values.put(COL_10,courseSemester);
        // Insert user values in database
        db.insert(TABLE_COURSE_UNITS, null, values);
        db.close(); // Closing database connection



    }

    private void addStudent(Students students){
        int id = students.getId();
        String regno = students.getStudentsRegno();
        String names = students.getStudentsName();
        String sex = students.getStudentsSex();
        String program = students.getStudentsProgram();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1, id);
        values.put(COL_2,regno);
        values.put(COL_3,names);
        values.put(COL_9,sex);
        values.put(COL_8,program);

        // Insert user values in database
        db.insert(TABLE_STUDENTS, null, values);
        db.close(); // Closing database connection

    }

    //delete methods for both students and course Units

    //delete method for students table
    private Integer deleteStudent(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_STUDENTS, "ID = ?",new String[]{id});
        db.close();

        Log.d(TAG, "Deleted all Student info from sqlite");

        return deleteStudent(id);
    }

    //delet methods for course units table
    private Integer deleteCourse(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_COURSE_UNITS, "ID = ?",new String[]{id});
        db.close();

        Log.d(TAG, "Deleted all Course Unit info from sqlite");

        return deleteCourse(id);
    }
}
