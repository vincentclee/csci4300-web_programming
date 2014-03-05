##Model-View Deployment on your VM

###CSCI 4300
In this exercise we will implement the infamous ACME mail-order company , which provides absurd contraptions to Wile E. Coyote in his demented attempts to catch the Road Runner.  We will edit and debug on Eclipse, then move the whole project up to our VM for deployment.

1. Launch Eclipse and start a new Dynamicv Web project named **ACME Order Form.** 
2. Create a new JSP page index.jsp. This will be the View for the project. Download the ACME.html file from eLC and paste its contents into the HTML part of the JSP page. Note that we always use strict HTML  doctypes, even if 
3. As usual, we start by mocking up the Web view. Run the project to get a sense of what this app is supposed to do. In this case, we have entered a couple of dummy items so that we can see the shopping cart format – these will be removed when we finish building the application.
4. We use the term line item for each item in the shopping cart.   Our dummy cart contains two line items, each with an item name and quantity.  So , we will create a **LineItem** class to represent these. Right-click on the project node and choose **New/JavaClass** again. Name this class **LineItem** and include it in package **acme.**
5. LineItem is what I call an **entity class**, meaning that it represents an instance of an entity that will be preserved as data for the application, typically in a database.1 A LineItem object needs to contain an itemID and the quantity of the item ordered. But for display purposes, we will also want to access the readable description of the item. So provide private data members for LineItem as shown here.
6. Create getters only for all three of these data members. Why do we not create setters? Because the contents of a LineItem object will be specified when the object is instantiated, and never changed afterwards.
7. Provide the list of item descriptions and  the method signature for a constructor as shown. You may need to  use your own demented imagination to populate the **itemDescription** array.

Please don’t write the code yet!  Note that we only need to specify the itemID and quantity to create a new LineItem object. The constructor will look up the description in the static **itemDescription** array shown.  By declaring the array as static, we tell Java to keep only one copy of this array, to be shared among all instances of this class. Each separate LineItem object needs its own itemID, quantity, and description, so these variables are not static.

8. You haven’t written the constructor code yet, have you? If you have, comment the code out before the next step. Right-click on the project node and choose **Build Path**. Add the JUnit 4 Library so we can use unit testing.
9. In the Project window, right-click on project node and **choose New/Other/Java/ Junit Test Case**.  Create a class LineItemTest , extending junit.framework.TestCase.
10. Testing an entity class is easy, since the job of an entity class is just holding data. Accordingly, create a single method testConstructor in which you create a three LineItem instance objects. For each instance,  provide three assertEquals statements. Be sure to test the instance description, as shown.
11. Now implement the constructor, “testing the class into existence.” Hooray!
12. Now it is time to create the cart itself. Right-click on the project node and create a new Java class. There is no specific menu item for creating a JavaBean – a Bean is just a Java class that obeys a certain standard interface. Put the new class in package **acme** and name it **ShoppingCartBean**. 
13. Our next task is to design the data flow between the JSP page and the bean.  
a. The JSP page is the view component: what the user  sees.  This page will contain the form to enter a new item, and display the items currently in the cart.  
b. The Bean is the model component, responsible for maintaining the actual state of the cart.  
c. In the dataflow shown here, itemID and quantity are properties entered into the input form in the JSP and **set** into the Bean. The cart property will be a list of objects, each object representing a single line item. The JSP page **gets** the cart property from the bean.  
d. The design of this data flow implies  that the posted form data should include the item ID, not the description. However, the user wants to see the description. Examine the 
14. The primary  field of ShoppingCartBean is the list of items, so declare this as **ArrayList<LineItem> cart**. Auto-generate the getter for this field.
15. In order to add an item to the cart, we need to set two properties, itemID and quantity. Our strategy will be as follows:  
a. First, capture the **itemID** property and temporarily store it in a data field;  
b. Then, receive the **quantity** property, create a new **LineItem**, and add it to **cart**.  
16. Therefore, add a new field **itemID** and an auto-generated setter method. Even though this method is trivial, it is still public; add an appropriate spec comment.
17. Here is the spec for the addQuantity method. We don’t need a field for the quantity, because this data is not shared between methods.2
18. Now write the JUnit test code for ShoppingCartBean! It goes according to the following plan:  
a. A **testConstructor** method to verify that you start with an empty cart;  
b. A **testAddItems** method to test adding items. In this method you create a new ShoppingCartBean, then call **setItemID** followed by **setQuantity**.  Now call **getCart()** to verify that a new LineItem has been added to the list. Also extract the new LineItem from the list and verify its id, quantity, and description. Lather, rinse, and repeat with a couple more ids and quantities.
19. Implement the constructor and **setQuantity** methods. Congratulate yourself when it works!
20. Now it is time to wire the JSP to the Java Bean! Follow this code pattern.  It is important to set the itemID property before the quantity property; can you explain why?
21. The last line incorporates the Java Standard Tag library. In order for this to work, you must go to the Libraries node and add the JSTL 1.1 Library. 
22. Now lets’ test that the properties are being set correctly. Add a debug printout to your setQuantity to printout something like “Adding 5 Rocket-powered roller skates to cart.” Save your files and run the app.  
23. Houston, we have a problem! Check out the action attribute of the form element in acme.jsp. The URL /addToCart is not recognized, so “The requested resource is not available.”
24. This is a good chance to learn about the **Web Application Descriptor** file web.xml. Modern versions of JSP allow us to create applications without a web application descriptor, so your ACME Order Form does not yet have one. But we are going to need one now! Right-click the Project node, select  **Java EE Tools**, and chose **Generate Web Descriptor Stub.**
25. Look inside the Web Content/WEB-INF directory to find web.xml. Double click on this file to open it. You will see a list of possible welcome file names. The welcome file is the first page you see when the application is run. We have index.jsp as our only welcome file, so (carefully!) delete all the others.
26. This does not solve our problem about the addToCart URL problem, though. To fix this we need two configuration steps in web.xml:  
a. Define the acme.jsp page as a named servlet;3  
b. Specify that the addToCart URL is mapped to this servlet.  
Look in your textbook for the **<servlet>** and **<servlet-mapping>**  elements of the web application descriptor file. I have gone ahead and written the solution here, but please at least check that this solution is consistent with the book’s explanation. One gotcha is that web.xml configuration is very sensitive to the presence or absence of leading front slashes. If you get a slew of horrible ServletLifetimeExceptions, these slashes might be the cause.
27. Now re-run the app. The server should restart!  Order a few items; the app should not blow up in your face, and  you should see the debug printouts, but the cart table on the JSP page does not yet update.
28. Now we shall introduce the JSTL forEach loop! Look this up in your text (pages 344ff in my copy) or Google it if you don’t have your text.
29. Follow the following pattern to display the cart. Note the use of **Expression Language** expressions such as **${bean.cart}.**
30. Note that **${bean.cart}** represents the return value of the getCart method., which is a collection. Each object in this collection, which will represent a LineItem, is denoted by **item.**
31. When you have got this app to run in NetBeans,  go to Part II of these instructions to deploy on your Linux Virtual Machine!

3 But acme.jsp file is a JSP file, not a servlet! Not to worry: our friend Jasper will compile it into a servlet.


##VM Deployment Exercise

###CSCI 4300
**Introduction:** until now, all of our exercises and assignments have run on our own computer. In order to have our applications visible on the Web, we must deploy them on a Web server. This exercise uses the ANT software development scripting tool on a  virtualUnix server, nike.cs.uga.edu, running the Apache Tomcat Java Web server. Other deployment options include Windows servers, Tomcat or JBoss Java Web servers, and the Maven software development scripting tool.

1. Get or install an ssh client program on your computer. If using a Windows machine, I recommend **WinSSH**, available via the magic of UGA site licensing from the friendly folks at Enterprise Information Technology Services, http://sitesoft.uga.edu. For Macs, you can use the ssh command on your underlying Unix OS, accessible via the Terminal application.
2. Using your ssh client, log into your CS account at **nike.cs.uga.edu** using the login and password given by the instructor. Note: nike is behind the UGA firewall, so if attempting this from outside the UGA network it will fail, unless you use the UGA VPN Tunnel software (also available at http://sitesoft.uga.edu).
3. Having logged into nike, you must now log into your virtual machine (VM), using the **student** login name. Please see the TA for this course if you don’t yet have your VM. 
4. This double hop makes it difficult to upload files from your local computer. Use the **ifconfig** command to check find your IP address, as shown. You can learn about all these other cool configuration values in your networking class!
5. Now go back to WinSSH (or the SSH command from the Mac terminal) and login to the IP address instead of the vmxx hostname. Same username and password. Now you have a direct link to your VM, which is useful when you need to upload files.
6. Do we have the ANT software installed? Type the command  
**which ant**  
– this will show that ANT is, indeed, available. Let’s go to work!
7. First, let’s set up a development environment on our VM. Traditionally, you will create a separate project directory for each project. Create the following directories in your home directory. If we follow the pattern of providing subdirectories to match package names, the ANT build process will go more smoothly. 
8. Also, we create separate directories for Java source code and Java class files, and separate pairs of directories for the implementation code and source code. The missing directories **ACME_Project/classes/acme** and **ACME_Project/test_classes/acme** will be automatically created when we compile the code.
9. Use the File Transfer tool on WinSSH to upload the implementation source files **LineItem.java** and **ShoppingCartBean.java** into **ACME_Project/src/acme**. Upload the test source files **LineItemTest.java** and **ShoppingCartBeanTest.java** into **ACME_Project/test_src/acme**.
10. Now the real fun starts! Create a file named **build.xml** in your ACME_Project folder with these contents.  Note that every XML tag must have a matching closing tag, a rule that is not enforced in HTML. The <echo> tag is allowed to be its own closing tag, since it does not contain any content.  
We’ve discussed the format of ANT build files in class; note that setting the default target to “compile” causes the “compile” target to run when you enter the “ant” command. From the shell, make sure you are in the ACME_PROject folder and type **ant**. You may need to fix a few XML syntax errors, but eventually you should  see this (rather Spartan) output telling you that the compile step has been run and the build was successful, but you still need to actually compile the code. Yay!
11. Now go to ant.apache.org and find the manual. Look up the Javac task in the manual and replace the <echo> task in your build file with a <javac> task. 1You only need to define the srcdir, destdir, and includeAntRuntime attributes. (You don’t need the runtime libraries, so set this to “no.”  The <javac> task does not contain any other tags, so make it self-close like the echo command above.
12. Test by typing the “ant” command again. After fixing any XML syntax errors, you should get a message telling you that the compile command has been run, two Java files have been run, and the build was successful. Yippee!
13. Using the Unix ls command or your SCP client, check that the Java class files **LineItem.class** and **ShoppingCartBean.class**  have been created and placed in the classes directory. Note that ANT created a subdirectory **acme** of **classes**. Again, Java source and class files go into folders matching their package names.
14. Run ant again. This time, the output tells us that the compile step has been run, but no files have actually been compiled! Just as its older cousin make does, ANT checks whether files that have already been compiled need to be re-compiled. In this case, since the class files are newer than their corresponding source files, the files are not recompiled.
15. Edit build.xml to add another target named **test_compile** that compiles all the test code. Since the test classes call methods of the implementation classes, any changes in the implementation code should be recompiled before we compile the test code. Therefore, make the test_compile target depend on the compile target. 
16. Inside the **test_compile** target tag, add a <javac> task to compile the test code. This will look just like the <javac> task in the compile target, except that the srcdir and destdir attributes will be test_src and test_classes, respectively. Also change the default target to test_compile in the <project> tag on line 1. Test by running the command **ant test_compile**.
17. Uh-oh! After correcting any XML errors, you will get a slew of errors about stuff being “not found.” This often means a classpath error. Examining the error messages, you will see that it is the implementations classes that are not found. These are in the classes directory, so add an attribute **classpath=”classes”** to the <javac> tag.2 Run the **ant test_compile** command again.  
 Yikes! Now ant cannot find the JUnit framework classes themselves. 3Unlike the implementation classes that we just created, JUnit classes have been compiled already and will be in a jar file. (Java Archive file.)  But where?
18. Part of the fun of administering Unix systems is figuring out where stuff is. The most basic tool is the **find** command. Check out the online manual for find by entering **man find**.
19. Now try to actually find the file: **find / -name junit\*jar**. (We need to escape the wildcard character so the shell does not replace it by a list of all the files in the current directory.) As you can tell, this command will search the entire directory structure of your VM, starting at the root directory /, for files whose names start with **junit** and end with **jar**.
20. Unfortunately, this command generates hundreds of lines of error output , telling us about all the directories we don’t have permission to list. We could override this problem by promoting ourselves to be the root user, but I discourage doing this unless it is really necessary.4 Instead, alter the find command to discard all the error messages by sending them to /dev/null:  
**find / -name junit\*jar 2>/dev/null5**  
21. This list is a bit more manageable! All we need to do is pick one of the JUnit 4 jar files, since we probably built our JUnit code on JUnit 4. Since we now have two items to go into our classpath, we get rid of the classpath attribute and replace it with a classpath element:
22. Note that the <javac>element is no longer self-closing, because it now contains the <classpath> element.  The <classpath> element is not self-closing either, but the <pathelement> elements are.  
Please take a moment to look over the section entitled Path-like Elements in the Apache documentation for the Javac task. In general, the elements of classpaths are either directories or jar files, both of which can contain classes.
23. Run ant test_compile again. This time the compile should succeed.  If you get the error shown at right, make sure you have included org.junit.Test in your includes.
24.  Now it’s time to actually run the JUnit test. In your Web browser, look up the <junit> element. Check the list of attributes – none of them are required! According to the description above the attribute list, “Tests are defined by nested test or batchtest tags (see nested elements).” Go down to the nested elements list, and find the **<test>** nested element. Note that the only required attribute here is **name**, the name of the test class. So, set up a basic test target as shown at right.
25. Change the default target to **test** in the <project tag> on line 1, and run ant. You’ll see a message telling you that the test has failed, but no error message to tell you what went wrong! What’s up with that?
26. To control the output, use a **<formatter>**nested element. Since <formatter> is a nested element, it can come before or after the <test> element inside <junit>. Choose the “plain” type and set usefile to false, which will dump the output to the console. 
27. Run **ant** again. Now you should see the error shown below, which is another classpath problem. This time the task needs two sets of classes: the implementation classes in the classes directory, and the test classes in the test_classes directory.  To add multiple locations to the classpath, use the nested **<classpath>** element, instead of the classpath attribute, as shown above. 
28. Run **ant** again. This time it should succeed!
29. Add **haltonfailure=”on”** to the <junit> tag. This will stop ant from continuing to the deploy step if there are any errors in the test step.

####Deploying the Web project
30. Now the real fun begins!  We’re going to deploy the actual Web project. This has three steps:  
a. Package the  project into a Web Archive (WAR) file;  
b. Copy this WAR file into the webapps directory on your Tomcat server;  
c. Restart the server.  
Actually it’s possible to skip step c. by configuring Tomcat to automatically reload any new WAR files that we drop into our webapps directory. However, I can’t resist the chance to try out the Tomcat control tags that we just learned about from our student presentation.

Accordingly, let’s add a new target named deploy to our build.xml file. In the project flow, we shall make “deploy” depend on “test.” This means that any time we change our Java code, we should automatically run all the tests again, and we should not redeploy unless all the tests pass.

Continuing with our slow-and-steady approach, let’s start by just adding a stub target as shown above. It does not matter in which order the targets are arranged within the build file, but I usually put them in chronological order of execution.

31.  Now change the default target to “deploy” in the first line of build.xml. Save build.xml and run ant. You should see all the targets run. No files should be recompiled, but the tests will be re-run anyway.
32. Now it’s time to build the WAR file. These have a (fairly) complex specified layout that must be just so in order to work. Fortunately, ANT has a <war> task that organizes the files into precisely this order, regardless of the arrangement of files within your project directory!
33. First, use SCP to upload your index.jsp file into the web directory inside your project directory. Use SCP to upload web.xml into the project directory itself.
34.   Look up the War task in the ant manual. Before we blindly forge ahead, look up the basedir, webxml, and destfile attributes. Let’s write a basic <war> task with just these attributes:
35. Note that we have scaled down the TODO comment!
36. Run ant again. You should see the TODO message, which means that the <war > task has succeeded! To check, examine the WAR file with the command jar –tf ACME.war.6  See! The WAR task has created the special META-INF and WEB-INF directories, and copied web.xml into the WEB-INF directory.
37. OK, lets copy this file to our webapps directory and see what happens:  
**cp ACME.war /opt/tomcat/webapps**
38. Oops! We get a permission denied error! Check this out with the appropriate ls command:
39. If you are not comfortable with Unix file permissions, this is a good time to catch up. The underlined line says that the file “.”, which is actually /opt/tomcat/webapps, is owned by root. Root has read, write, and execute permissions to this file, but others have only read and execute permissions. Please look up the ls command if this is Greek to you – if you get lost here, it is much more difficult to succeed in this course.
40. In order for the copy command to work, we need write permissions to the directory. So let’s give ourself write permission:
41. This is a predictable result, since we don’t own this file! The only recourse is to temporarily become root! Root’s password is the same as your own, original password (you did keep that paper, didn’t you?)
42. Note that the prompt changes to “#” when you are root. Do your job and exit back to being student as soon as possible! Remember that if you mess up your server, we’ll simply wipe the whole VM and you can start over.
43. Now try your copy command again: !cp7
44. Your ACME application is now loaded into Tomcat. Lets’ start the server from the command line:
45. Launch a Web browser and navigate to http://XXX:8080, where “XXX” is the IP address you located earlier on in the exercise. You should see the Tomcat logo. Yippee!
46. Almost done, right? Well, we’ve got a few tweaks left. Now attempt to navigate to your ACME app at http://XXX:8080/ACME. You will see a message saying that the files needed to implement the JSTL are not found. Bummer!
47. Download the JAR files javax.servlet.jsp.jstl-1.2.1.jar and javax.servlet.jsp.jstl-api.1.2.1.jar from eLC to your local computer. Upload them to your home directory on the VM, then:Relo
48. Reload the web page one more time. It looks like the same old same old, but on closer examination you have graduated to a different error! We have fixed the JSTL problem; now the problem is that Tomcat can’t find the Bean files.
49. Exit from root, and return to the ACME Project work directory. Repeat the command jar –tf ACME.war. Note that the LineItem and ShoppingCartBean are not included in the war file!
50. Return to the ANT War task manual page and look for the classes nested element. This is where you put in the location of your class files.  See if you can compose the necessary <classes> element (Hint: it’s a one-liner). Note that because Java maps packages to directories, the root directory specified should be **classes**, not **classes.acme**.
51. Now re-run ant and re-do the jar –tf command. You should now see the classes files. Note that the classes have been placed inside an acme subdirectory.
52. Cross your fingers, stroke your rabbit’s foot, and copy ACME.war to the Tomcat webapps folder. Reload the page and this is what you should see!


TO BE CONTINUED….
