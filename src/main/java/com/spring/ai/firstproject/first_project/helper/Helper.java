package com.spring.ai.firstproject.first_project.helper;

import java.util.List;

public class Helper {

    public static List<String> getData() {

        return List.of("Introduction and History\n" +
                "James Gosling and his team at Sun Microsystems started developing Java in 1991 under the initial name \"Oak\". It was officially released in 1995. The primary goal was to create a language that featured a familiar C-like notation but offered greater simplicity, portability, and reliability across different computer systems. Today, Java is stewarded by Oracle Corporation and supported by a massive global community of developers.\n" +
                "Core Architecture\n" +
                "Java achieves its platform independence through the Java Virtual Machine (JVM).\n" +
                "• Source Code: Developers write human-readable code in .java files.\n" +
                "• Bytecode: The Java compiler (javac) transforms this source code into intermediate bytecode (.class files).\n" +
                "• Execution: The JVM reads this bytecode and executes it on any operating system—whether Windows, macOS, or Linux.\n" +
                "• JIT Compilation: The JVM uses Just-In-Time (JIT) compilation to convert frequently used bytecode directly into native machine code for faster performance.\n" +
                "Key Features\n" +
                "• Object-Oriented: Java uses classes and objects, promoting modular, reusable, and clean code organization.\n" +
                "• Automatic Memory Management: It features built-in garbage collection, which automatically frees up memory by deleting unused objects.\n" +
                "• Security: Java reduces security risks by omitting explicit memory pointers and running code inside a secure sandbox environment via the JVM.\n" +
                "• Robustness: Strong type checking helps catch programming errors early during compilation.\n" +
                "Major Uses\n" +
                "Java powers a vast share of the modern digital landscape.\n" +
                "• Enterprise Software: Large corporations rely on Java for backend banking systems, customer relationship tools, and large-scale business applications.\n" +
                "• Android Apps: Historically and currently, Java serves as a foundational language for building Android mobile applications.\n" +
                "• Big Data: Massive distributed frameworks like Apache Hadoop and Apache Kafka are implemented using Java.\n" +
                "• Cloud Services: Cloud-native microservices and web applications frequently utilize Java frameworks like Spring.\n" +
                "In summary, Java remains a dominant force in software development due to its incredible backward compatibility, security, and reliable performance.");

    }


}
