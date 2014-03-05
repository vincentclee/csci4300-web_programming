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
c. In the dataflow shown here, itemID and quantity are properties entered into the input form in the JSP and set into the Bean. The cart property will be a list of objects, each object representing a single line item. The JSP page gets the cart property from the bean.  
d. The design of this data flow implies  that the posted form data should include the item ID, not the description. However, the user wants to see the description. Examine the 
14. The primary  field of ShoppingCartBean is the list of items, so declare this as ArrayList<LineItem> cart. Auto-generate the getter for this field.
15. In order to add an item to the cart, we need to set two properties, itemID and quantity. Our strategy will be as follows:  
a. First, capture the itemID property and temporarily store it in a data field;  
b. Then, receive the quantity property, create a new LineItem, and add it to cart.  
16. Therefore, add a new field itemID and an auto-generated setter method. Even though this method is trivial, it is still public; add an appropriate spec comment.
17. Here is the spec for the addQuantity method. We don’t need a field for the quantity, because this data is not shared between methods.2
18. Now write the JUnit test code for ShoppingCartBean! It goes according to the following plan:
a. A testConstructor method to verify that you start with an empty cart;
b. A testAddItems method to test adding items. In this method you create a new ShoppingCartBean, then call setItemID followed by setQuantity.  Now call getCart() to verify that a new LineItem has been added to the list. Also extract the new LineItem from the list and verify its id, quantity, and description. Lather, rinse, and repeat with a couple more ids and quantities.
19. Implement the constructor and setQuantity methods. Congratulate yourself when it works!
20. Now it is time to wire the JSP to the Java Bean! Follow this code pattern.  It is important to set the itemID property before the quantity property; can you explain why?

21. The last line incorporates the Java Standard Tag library. In order for this to work, you must go to the Libraries node and add the JSTL 1.1 Library. 
22. Now lets’ test that the properties are being set correctly. Add a debug printout to your setQuantity to printout something like “Adding 5 Rocket-powered roller skates to cart.” Save your files and run the app.  
23. Houston, we have a problem! Check out the action attribute of the form element in acme.jsp. The URL /addToCart is not recognized, so “The requested resource is not available.”
24. This is a good chance to learn about the Web Application Descriptor file web.xml. Modern versions of JSP allow us to create applications without a web application descriptor, so your ACME Order Form does not yet have one. But we are going to need one now! Right-click the Project node, select  Java EE Tools, and chose Generate Web Descriptor Stub.
25. Look inside the Web Content/WEB-INF directory to find web.xml. Double click on this file to open it. You will see a list of possible welcome file names. The welcome file is the first page you see when the application is run. We have index.jsp as our only welcome file, so (carefully!) delete all the others.
26. This does not solve our problem about the addToCart URL problem, though. To fix this we need two configuration steps in web.xml:
a. Define the acme.jsp page as a named servlet;3
b. Specify that the addToCart URL is mapped to this servlet.
Look in your textbook for the <servlet> and <servlet-mapping>  elements of the web application descriptor file. I have gone ahead and written the solution here, but please at least check that this solution is consistent with the book’s explanation. One gotcha is that web.xml configuration is very sensitive to the presence or absence of leading front slashes. If you get a slew of horrible ServletLifetimeExceptions, these slashes might be the cause.
27. Now re-run the app. The server should restart!  Order a few items; the app should not blow up in your face, and  you should see the debug printouts, but the cart table on the JSP page does not yet update.
28. Now we shall introduce the JSTL forEach loop! Look this up in your text (pages 344ff in my copy) or Google it if you don’t have your text.
29. Follow the following pattern to display the cart. Note the use of Expression Language expressions such as ${bean.cart}.

30. Note that ${bean.cart} represents the return value of the getCart method., which is a collection. Each object in this collection, which will represent a LineItem, is denoted by item.
31. When you have got this app to run in NetBeans,  go to Part II of these instructions to deploy on your Linux Virtual Machine!
