##JSP Personal Page Assignment

###CSCI 4300
It’s time to tell me about yourself! Create a personal Web page from these components:

1. A JavaBean class named csci4300.Student that contains information about a student;
2. A Java Server Page index.jsp that displays the contents of a Student object; in particular, a Student object that represents you.

Your Student object should contain:
* Your name;
* A link to an image of you;
* A description of yourself;
* A list of activities in which you are involved.

Each one of these data items should be represented as an appropriately typed, appropriately named, Java class member.
Test-driven development: I will provide JUnit test code for the Student class.
Model-View separation: In order for this class to be a JavaBean, it needs to have a no-arg constructor. Provide initialization parameters for your name, image URL, and description via <jsp:setProperty > tags. For the activities, provide an input form for entering a new activity.
Grading: 
HTML output validates as HTML 4.01 Strict or XHMTL
10%
Student class design (variable and method names)
10%
Passes JUnit tests
20%
No Java code in JSP page
20%
All personal data in Student object rather than JSP page
10%
JSP page displays all information
10%
Built and deployed on your VM, including JUnit testing
20%
TOTAL
100%

Grade deductions:
Up to 10% for failure to follow course coding guidelines.
Up to 20% for inappropriately copying code from your own work,  i.e. copying code but not changing it appropriately for its new location.  This is to encourage you to actually write the new code, so you are not repeating old mistakes.
Academic Honesty Rules for this assignment
This is an Individual Assignment.  These are completed on your own, entirely outside of class. You may discuss ideas with other students. You may not work together with other students, help other students with code, copy other students’ code, or write code for other students.  I will be happy to answer questions during my office hours, but please do not ask questions or work on this assignment in class.
Content from outside this class: You may not copy any code from any other source, such as the textbook or examples from the Web, without specific authorization from the instructor. Any content from an external source, including images, must be acknowledged in your code. You may use code from your in-class JSP exercise in this assignment.
Enforcement: if I suspect that a violation of these rules has occurred, I will first discuss it with the students involved. If after this discussion it still appears that a violation has occurred, I will handle the matter according to the UGA Academic Honesty Guidelines (http://www.uga.edu/honesty/). During any hearings I will ask for a penalty of an F in the course.
Implementation hint:
Use Extreme Programming to break the project into two iterations. In the first iteration, do everything except the list of activities. Add the activity list, which uses a collection, in the second iteration.
How to Submit:
If you successfully deployed on your VM, congratulations! Just include a note to this effect in your eLC submission. We will log in and check your work.
If you were able to complete this assignment on Eclipse but not on your VM, please package your Eclipse project folder as a ZIP archive and upload it. This folder will be a subfolder of your “workspace” folder. Then, submit the assignment on eLC.
