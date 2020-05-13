package com.example.java.chapter5;

import org.python.util.PythonInterpreter;

public class Test {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("print 'hello' ");
        interpreter.cleanup();
        interpreter.close();
    }
}
