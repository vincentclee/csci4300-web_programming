##Tomcat Configuration Exercise

###CSCI 4300
**Before you start:** please download Tomcat 7 from tomcat.apache.org and unpack the archive file:

* For Windows computers, get the 32-bit or 64-bit Windows zip, as appropriate;
* For Macs and Unix machines, get the tar.gz version.

Note that Tomcat is a collection of Java class files, not a native app. There is an option to install Tomcat as a Windows service, but I don’t recommend this. In the laptop environment, you will use Eclipse to start and stop Tomcat.

####Academic Honesty Rules for this Exercise:
This is an in-class exercise, not an individual assignment. You are encouraged to work with a partner and to share your work with other students. However, it is forbidden to copy the work of anyone else – we don’t learn much that way.

####The Reading Exercise:
1. Point a Web browser to the advanced Tomcat configuration tutorial by Chua Hock-Chuan.1 As you go through the material, answer the questions below. At the end, save this document with your answers and submit it.
2. Using a file browser on your computer, locate the Tomcat home directory, also called CATALINA_HOME. What is the path to this directory on your system? **Answer:**
3. W hat is the value of JAVA_HOME on your system? **Answer:**
4. **(Section 1.2)** What is a servlet container? **Answer:**
5. Use a text editor to find and open the server.xml file on your Tomcat installation.
6. **(Section 1.3)** Find the reference to JasperListener in your server.xml file. What is the purpose of the JasperListener? **Answer:**
7. **(Section 1.3)** What is Catalina? **Answer:**
8. **(Section 1.3)** What is JNDI? **Answer:**
9. **(Section 1.3)** What JNDI resources are named in your config file, and what is their purpose? **Answer:**
10. **(Section 1.3)** The <Connector> for port 8080 serves HTTP requests and has a timeout parameter. For what event is the Connector waiting? **Answer:**
11. **(Section 1.3)** What is the UserDatabase Realm? **Answer:**
12. **(Section 1.3)** What is the AJP Connector? **Answer:**
13. **(Section 1.3)** What is the meaning of the “appbase=webapps” attribute of the <Host> element? **Answer:**
14. **(Section 1.3)** On your system, what files are contained in the webapps directory? **Answer:**
15. **(Section 1.3)** What is the meaning of the “appbase=webapps” attribute of the <Host> element? **Answer:**
16. **(Section 1.3)** What is a Valve? **Answer:**

####The Actual Tomcat Launch
This part of the exercise does not have any answers that you must submit, but I bet you will be curious to see if you can do it!

17. Scroll to the top of the Web page and click on the link, "How to Install and Get Started with Tomcat". Follow the instructions to configure and launch your Tomcat instance.
18. Open a web browser and navigate to http://localhost:8080. Celebrate if this works!
19. Download the file TomcatHello.war from the eLC exercise. Can  you run this on your Tomcat server?
20. Navigate to the grocery list page and try adding some items (“Pizza”, “Beer”, etc.) to the list. As the items are added, the internal Java logic (“ListBean”) is writing debug messages to System.out. Can you find these messages on your computer?
21. That’s it! Next time we will do this on a Linux virtual host provided by the CS department.
