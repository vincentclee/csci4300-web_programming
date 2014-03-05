##Test-Driven Development with Eclipse

###CSCI 4300
**Before you start:** You should have Java and Eclipse installed. If not, the installation directions are in the “Integrated Development Environments” section of the Coding Resources page on eLC.

You should have completed at least the first iteration of the credit card project, which just stores the customer information, and created a JSP page as a Web view for the **CustomerAccount** class.

Ready to write some Java code? Let’s go!

1. Launch Eclipse, and open the CreditCard project . The  icon should contain a little Earth symbol, representing the Web, and a J for Java.  You should have a **CustomerAccount** class already defined.
2. Check the data fields of the CustomerAccount class.  We now have defined enough methods to implement and test the first of our User Stories: “Admin creates customer account.” 
3. Before generating Unit tests, you must add the JUnit library to your **build path** – this is the set of resources that Eclipse calls upon to build your project. In the Package Explorer view, select the **Java Credit Card** project and choose **Properties**. Under **Java Build Path**, click the Libraries tab and choose the JUnit library. When you have added this library, you should see the  icon in your Package Explorer window.
Now it’s time to create the unit tests. Select the CustomerAccount node in the Project Explorer window, and choose **New/JUnit Test**. If you don’t see JUnit Test in the new menu, click Other and explore for JUnit Test Case.  The conventional name for a JUnit test class is the word “Test” appended to the class name itself, so name this class CustomerAccountTest.
4. In the JUnit wizard, leave all the default choices unchanged in the first screen, **except for changing the Superclass as shown at left**. 1This class contains all the JUnit testing infrastructure we will need to write test code. Instead of typing junit.framework.TestCase, try clicking the Browse button and searching for **TestCase**.
5. Depending on your setup, you may get a screen asking you which methods to test. Select only the constructor as shown. Because the getter methods were auto-generated, there is no need to test them. 
6. You now see the following rather cryptic code. This is progress, you ask? All that is obvious is that this is some sort of test.  
To me, the main problems with this code are the name **testCustomerAccount**, which is uninformative2, and the lack of documentation as to what this code is supposed to do. What the code is supposed to do is test the constructor, so let’s change its name.
7. Click on the little arrow pointing to **testCustomerAccount** in the Package Manager view. Select **testCustomerAccount** and choose **Refactor/Rename**. Change the name of the method to **testConstructor**. (Method names and data field names should be in lower camel case. Conventionally, test method names should start with the prefix “test”).  
Note: be sure you do not change the name of the class, **CustomerAccountTest!**  Class names are in upper camel case, while method names are in lower camel case. More important, names must reflect the meaning of the items:  the **testConstructor** method will test only that the constructor works correctly, while the CustomerAccountTest class will contain a whole suite of test methods to test all the capabilities of the CustomerAccount class. 
8. What’s the advantage of using **Refactor** to change the name of a method rather than just erasing the text in the editor? If there are calls to the method elsewhere in the code, Refactor will automatically change their names too. Because making code understandable is critical to making it work correctly, I urge you to be willing to change the names of stuff when they no longer make sense (that is, as your understanding improves). Refactoring is key to the “Embrace Change” mantra of Extreme Programming.
9. Here is the code after refactoring and adding a comment (please follow suit by typing in the code yourself). The job of a test method is verifying that the “testee” object correctly carries out some part of its job.  So far, all our CustomerAccount does is contain data. Data is put into the object by its constructor, so the test code will construct a  CustomerAccount  object and verify that the  newly created object has the correct data.
Note that the comment does not specify all the steps a method will take – it only promises what should be accomplished after the method has completed.
10. What’s up with the **fails** statement? To see, select the **TestCustomerAccount** class and choose **Run As /Junit Test**. (You can’t run the testConstructor method alone – you must always run an entire class.) A new JUnit window should pop up, informing us that there was one test failure.  Under Failure Trace, you will see the error occurs because the test was not implemented. If this doesn’t make sense, go to the restroom and run cold water over your head, then come back and we’ll talk.  
The call to fail() means that we know the test is supposed to fail and we will tell you the reason.
11. Now let’s fix this by actually implementing the test. Here is where we must think hard about what we actually expect the CustomerAccount constructor to do: store data in an object. Here’s the start of the test code. We have created a new object, because that’s what constructors do. It’s conventional in writing test code to name the object we want to test either “instance” or “testee.” In this case we call it “instance1,” suggesting more instances to come. Here are a couple of notes about this code:  
The first line declares this instance1 variable using the standard pattern:  
**type Variable-Name = Variable-Value**  
In the **assertEquals** statement, I typed the name of an object “instance1” followed by a dot. After a moment, Eclipse offers me a menu of possible choices.
12. Here is a deconstruction of the **assertEquals** method call. The job of a test method is:  
* do nothing if the  testee class is working correctly;
* raise an Exception if the testee class is not working as expected.  
As you can see, the three inputs to assertEquals are the error message, the expected value, and the actual value.  
Important note: when you have typed in this code, you must remove the default call to fail. It is no longer true that the test has not been implemented, because we have just started implementing it!
13. Now let’s run this test. If you have already implemented the constructor, please comment out its code before running the test. 3 This time we get a different error, as shown at right. This is the correct test result – remember that we have yet to implement the constructor itself, so the test should fail.4
14. Here is the next line of test code. Enter this line.
15. Add a third assertEquals to test the customer address.
16. Add a fourth assertEquals to test the image URL. The expected value is **null**. (The word **null** is a key word in Java. Please don’t type it with quotes as “null”, because that is a non-null String value.)
17. The next test, of the unpaid balance, is a bit different. Because of the way Java represents the **double** data type,  two double values could differ by an infinitesimal amount and still be not equal. (This is one of the reasons why we have a TODO item to replace doubles with BigDecimals). In JUnit tests, we must also specify the acceptable difference between two values. If the instance 1 unpaid balance is within 0.001 of zero, we will call that good enough.
By the way, why is zero the expected value, even though we never specified the initial unpaid balance in the constructor?
18. Complete the test code by adding a test for the credit limit. This one is also a double, so you will need the fourth “delta” parameter.
19. Continue the test code by adding a second instance as shown (you may use your own name instead of mine!). Follow this declaration by six assertEquals statements. Remember to include “instance 2” in the error message for each assertEquals, so we can tell which instance fails. In general, we try to test enough instances to make sure that the test does not pass just because of special values of the instance data.
20. Now we can actually implement the code! Thanks to Extreme Programming, we now have a significantly better understanding of what our code is supposed to do.  If you previously commented out the constructor body, uncomment it now and skip over the next two steps.
21. Enter the following code, followed by five more assignment statements (not three!) to complete filling in the six data members of our class. 
22. The keyword  stands for the object in which the code is written. It will come in handy for the setting the credit limit – since the constructor parameter **creditLimit** has the exact same name as one of our data members, a naming conflict could result. No problem!  **this.creditLimit** is our data member, while just plain **creditLimit** is the method parameter.
23. Now for the acid test! Save your CustomerAccount.java code and run TestCustomerAccount again. You should be rewarded with the coveted green bar!
24. You may define multiple constructors if there is a good reason to create an object with a different set of data.  For example, there might be a **default** value for the initial credit limit (a value that is used if we don’t have reason to specify anything different).  In this case, the default value would be a constant and declared this way.  Declaring a variable as **final** means its value can never be changed (at least, without rewriting the code!) Declaring a variable as static means it has a single value shared among all objects in the class. Constants should be named with all upper case letters separated by underscores.
25. Creating an account with the default credit limit requires less input data, so we can define a new constructor that takes only three parameters instead of four. Although these two constructors have the same method name, Java can tell which one to call based on the number of input parameters. This trick is called **overloading** a method name.
26. The code shown at right has a revised spec comment and fewer input parameters. Type in the new constructor code as shown here. As always in Extreme Programming, we spec out the code and write the test code before actual implementation.
27. Add the following line to the test code testConstructor method, followed by six assertEquals statements to test the expected values of all the data members, including unpaid balance and initial credit limit.
28.  Use the ‘creatively lazy’ method of calling one constructor from another, called **constructor chaining**, as shown below. Note the special syntax of the line starting with , which implements constructor chaining. Besides saving work, constructor chaining prevents from writing duplicate chunks of code that would require separate testing and debugging.

####Adding transaction handling to the class
29. Add the following method spec to your CustomerAccount class.  
30. We will need a way to inform the user about any error messages, so add a String field **errorMessage** if there is not one already. Edit the spec above to describe the behavior of the addBoolean method, which will either update the unpaidBalance field or set the error message. Provide an auto-generated getErrorMessage method, and don’t forget the spec comment!
31. The method won’t compile without a return statement. Add a **stub** return statement5 and //TODO comment as shown here. Check that your Task view shows this TODO item, so you won’t forget to do it!
32. I have written some test code for the revised CustomerAccount class, which you can download from eLC.  Copy and paste this into your existing test code. Read over the test code and check the cases given. Note that in particular, we need to check that making a legitimate purchase after an illegal purchase attempt should reset the error message.
33. Now “test the class into existence” by implementing the addPurchase method.  Keep going until you see the coveted green bar.
34. Can you see the TODOs in your Task view? First, use the **Window/Show View** command to display the Task list – it should attach itself as a tag in the bottom window. If you don’t see all your TODO tags, you can configure the Task pane by using the Window/Preferences command and searching for Task Tags. Note that in this configuration, a //FIXME comment will rise to the top of your TODO list!

That’s it! Save your work and rest. If you have been working with a partner, ask in class about how to share your files among partners. Next time, we will see how to adapt this class as a JavaBean.


##CustomerAccount becomes a JavaBean

###CSCI 4300
**Before you start:** You should have completed the second iteration of the credit card project, which adds purchases or creates an error message,  and created a JSP page as a Web view for the **CustomerAccount** class. 
Ready to write some Java code? Let’s go!

1. Launch Eclipse, and open the CreditCard project .  Bring up your **CustomerAccount** class  in your editor.  Modify the class comment to clarify what to change, in case we forget (or don’t clearly understand):To make CustomerAccount into a JavaBean, we need to define the properties exchanged between JSP and Bean:  
a. **Properties read by the JSP page from the Bean:**  every piece of data that the page must display. This includes all of the customer data, the credit limit and unpaid balance, and the error message. Your should already have getter methods for all of these properties:  
b. **Properties sent by the JSP page to the Bean:** the amount of a new purchase. We already have a method named addPurchase that does this, but JavaBeans must express all inputs and outputs as getter and setter methods. This is easily accomplished by wrapping addPurchase with a setter method:  
Note that the spec  for the new setter method is nearly the same as the addPurchase spec, because the methods do the same task! Remember that method specs should tell what the method accomplishes, not the implementation details of how the method accomplishes its job (in this case, calling another method).  
Setter methods must return void, so we have dropped the return type from setPurchaseAmount.  I would recommend against simply refactoring addPurchase into setPurchaseAmount, since we use the Boolean return value from addPurchase in the test code.
2. Of course you will want to write test code for this new method, won’t you? Since the logic should be the same as for the addPurchase method, you may just copy the code and carefully make the appropriate changes. Remember that I will whack your grade if you copy your own code without reading it and modifying it as appropriate. Make sure the tests pass before proceeding.  Hint: there’s no more return type! 
3. Now it is time to “marry” the Bean to the JSP. Open the JSP page and replace the import statement with a <jsp:useBean> tag as shown above. This would be a good time to review the description of useBean in your text! The  part tells Tomcat to keep this object around from one request to the next, so that we can accumulate an unpaid balance.1
4. Delete all the  Java Scriptlets and Expression Scriptlets in your JSP page. These will be replaced with Bean references.
5. Save all the files and rerun the application. If it looks as if Eclipse has not incorporated all your changes, use the Project/Clean command.
6. Uh-oh! The JSP page now has an error. Checking down through the stack trace, you should see that our friend Jasper is upset with us,which means there is a problem translating our JSP.  In particular, Bean classes must have a no-arg constructor. So, we must add such a constructor, and then setter methods for the account number (we already have setters for the customer name, address, etc. ) We had very good reasons for not writing such a constructor before, but we need it now.2
7. Add some code to the testConstructor method  in CustomerAccountTest to validate creating a CustomerAccount with the no-arg constructor, then populating it with setter methods. Make sure you see the green bar before proceeding.
8. OK, now add the <jsp:setProperty>  tags into  the JSP page to populate the Bean:
9. Theoretically, the <jsp:setProperty> tags should automatically cause the Bean setter methods to fire. Since this is getting a bit mysterious, add some debug printouts to verify that these methods are in fact being invoked:
10. Run this puppy and see if the printouts appear on the Console.
11. Now, use <jsp:getProperty> tags to extract the properties from the Bean:
12. Now, add an input form to add a new purchase.
