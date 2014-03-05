##Form Checking with the W3C DOM

###CSCI 4300
**Introduction:** this exercise uses the W3C Document Object Model (DOM) as described in the lecture notes, “Use the DOM, Luke!” The DOM provides us with an API for accessing HTML page elements as JavaScript objects.
In this exercise, we will use these JavaScript objects to verify that a form has been filled in before allowing it to submit.

1. Launch Eclipse. If you have not already done so, create a new Dynamic Web project named **JavaScript Examples**.
2. Right-click the project node and useNew/HTML page to create a page named **formCheck.html**. Download the HTML file **formCheck_Starter.html** from the eLC Assignment  page. Open the file with a text editor and paste its contents over the contents of formCheck.html. Save the contents.
3. Create another HTML page index.html, containing a link to formCheck.html. Now you should be able to run the application and navigate to our file.
4. The page claims to validate as HTML 4.01, so visit the validator page at http://validator.w3.org and verify this. In general, we’d like all our pages to validate as HTML 4.01 Strict, XHTML, or HTML5.

####Creating an Echo servlet
5. The transfer of REQUEST variables from client to server follows the “name=value” format. That is, each variable has a specific name and a specific value. Open FormCheck.html with a text editor and examine the source code to see how the variables are named.
6. This code contains a logic error: the city variable never makes it to the server. Examine the source code and fix the error.
7. In the HTML code, the form is defined to submit to “Echo.” When you fill out the form and submit, you will get an error because there is no resource at that URL.
8. Create a new Servlet named **EchoServlet** in package **servlets**, initialized as follows: 
a. The URL pattern is /Echo;
b. The class comment identifies this as a diagnostic servlet that echoes posted form contents;
c. The doPost spec comments says “Echoes all request parameter names and values”.
9. Edit the doPost method with the standard setup for directly responding: set the response content-type, get the PrintWriter output channel, yada yada. Write a couple of input lines to the output so that we can verify the servlet mapping. When you run the application and submit the form, you should now see the start of the echo response. I included a <link rel=”stylesheet” line to capture the CSS style.
10. Add code to the servlet to begin the table as shown.
11. Use the getParameterNames() and getParameterValue() methods of HttpServletRequest to fill out the table values. This is a great time to practice the Java for-each loop!
12. Now when you submit the page, you should see the values of all the input boxes. Note that even if you leave the form empty, the request parameter is still submitted.
13. Next, we will explore how the onSubmit handler works. You must use the keyword return inside the HTML onSubmit attribute, as shown here. Then the rule is:
a. If the handler returns true, the form data is submitted;
b. If the handler returns false the form is not submitted. In this case, please let the user know why the form was not submitted!
 
14. In the case shown above, the form should not be submitted.
15. Now, edit the formOK method to pop up a “Success!” message and return true. This time, the form should submit.
16. To make this useful as an actual form checker, we first need to access the data that the user typed in. Here is where the DOM comes in! Edit the formOK function as follows, and test it by running the code.


17. Yikes! When we run this, we don’t see the alert telling us that we have found the input box. This is a good example of JavaScript’s sinister silent failure behavior, and shows why I use positive acknowledgement boxes like the one above. Fix the problem by giving the input box an id value:
18. Save and run again – this time you should get the confirmation box.
19. Now we have an object reference to the input box, but how can we tell if the user has filled anything in? To make sure we are doing this right, go to the official source: http://www.w3.org/TR/DOM-Level-2-HTML/html.html. Look in this page for the HTMLInputElement interface. 
20. Yikes! This has a lot of parts, but be patient and scan down the documentation to the attribute value:

21. Now you are in a position to make the following code work, by referring to the value member of the firstNameObj object:

22. OK, we are almost done! Put in an if statement to display an alert box and return false if the contents of the box are the empty String “”, and return true otherwise.
23. From here on it’s a race to the finish. Add if statements for all of the other form elements. You will need to go through the same DOM exploration process, but it does not take long.
24. A final challenge: the zip code select box ALWAYS returns an element, so we can’t tell if the user selected something or not. Fix this by adding an initial dummy option “—Select—“. If that is the current value of the select element, then the form is not complete!
25. Finish this up and upload the formCheck.jsp and EchoServlet.java files.
