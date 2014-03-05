##MVC/Database Exercise

###CSCI 4300
**Introduction:** having worked through exercises on the Model-View-Controller design pattern and on JDBC code to manipulate databases, we will now combine those two skillsets, Our example application is, once again, the credit card application.

Having worked on previous iterations of the credit card application, you have probably noticed that it does not make sense for all the customer data and transactions to disappear when we close down the application. In a real credit card application, this data should persist as long as the credit card account is open. We call such long-lived data **application scoped** data, and normally store such data in a relational database.

In this exercise we will create some MySqL database tables to maintain the customer account and transaction info, then “wire up” these tables to the visible Web application via JSP pages, controllers, and helper classes.

**Before you start:** these instructions can be carried out on your local system if you have MySQL and MySQL workbench installed. Otherwise, you can work on your VM. If working on the VM:
* First, build the database tables in your CSCI4300 directory, using the command line client or phpMyAdmin;
* Next, write your specs, JUnit test code, and initial stub implementation code on Eclipse (adapting your existing CreditCard project);
* Then, upload code to the VM and test using ANT.

Continue these steps as you test your code into existence, or edit your code directly on the server using a Unix editor such as **emacs** or **vi**.

1. Create the Customer table first. MySQL provides the decimal data type, which allows us to specify the total number of digits and the number of digits after the decimal point.
2. In MySQL 5.1, we must specify the InnoDB database engine in order to use foreign key constraints, as we will show in the next step.
3. Now create the Purchase table, which is linked to the Customer table via a foreign key. This implements the many-to-one relationship between customers and purchases (one customer has many purchases, but each purchase belongs to only one customer). Be careful with the commas and parens; on the command line client, you can use the up arrow to edit the previous command.
4. Enter these commands to test the foreign key constraint:
5. Now enter the same Purchase with custID=1, which should succeed. Next, attempt to delete Gordon Gecko’s account:
6. Launch Eclipse and open the CreditCard application. Check the libraries and make sure you have the server runtime library installed in the application. If not, use **Build Path/Add Libraries** to add the Tomcat runtime library.
7. There will be two JSP pages in this iteration of the application:  
a. **customerList.jsp**, holding a list of the customer data for all accounts;  
b. **customer.jsp** holding the customer data for a single account plus a list of the transactions for that account.
8. Let’s start by writing the JSP pages.  First, download the starter mockup of **customerList.jsp** from eLC. Create a  new JSP file with this name and open it in Eclipse. Copy the downloaded code into customerList.jsp. Run the application, and navigate to customerList.jsp to view the generated code.
9.  Note that the page will contain multiple table rows, meaning it must use a JSTL forEach loop.
10. Next, let’s start mapping out the Controller workflow. This example will not use authentication, so we won’t worry about session data:

Method | Request params | Result
------ | -------------- | ------
GET | None | Customer list
GET | custID | Single customer

You can continue adding to this table as you implement additional functionality. (It’s not a sin to edit my class notes!)

11.  For the MVC iteration of this project, the functionality in your existing CustomerAccount class will be broken into various classes:

* The existing class **Customer**  becomes a **data transfer object** class. It contains the data that will be displayed on the JSP pages, and is part of the Model component of the MVC architecture.
* A new class **Purchas**e will be a data transfer object representing purchases.  The Customer class will be refactored to include a list of Purchase objects.
* A new class, **CustomerDAO** is the **data access object** class. This manages the database tables and is a helper class for the Controller.
* A new class, CustomerController, will be the MVC Controller

The next few steps in the development process do not use the database, so you can carry them out on Eclipse.

13.  Create the new class Purchase. As this is an “entity class,” which will simply carry the contents of a database record, it only needs a constructor and getter methods. 
14. Create a JUnit test case PurchaseTest. You only need a single testConstructor method and two or three test cases.
15. Test Purchase into existence. This part should be easy!
16. Refactor the Customer cllass by adding a new field to contain the list of purchase for this account. You will also need to change the addPurchase method signagure, so that adding a purchase not only changes the unpaid balance but appends a new Purchase object to the list.
17. Edit your CustomerAccountTest class so that the testAddPurchase method now tests the length and contents of the purchase list. Edit CustomerAccount until it passes the tests.
18. Create a new Java class CreditDAO in package creditcard. Download the starter Java and JUnit code from eLC.  Implement only the addCustomer and  getCustomerList method for starters.
19. At this point, please move to the VM for the JUnit tests. You will quickly discover that each time we run the unit test, it adds two new records to the table, which causes the test to fail. Instead of adding Java code or removing the records by hand, see if you can use the ANT sql task to delete the records.
20. Now create the controller class CreditController. Remember to use New/Servlet to create this class. From the table above, we just need the doGet method to start with. This method should:
* Create a new helper object of class CreditDAO;
* Get the list of Customers from the helper;
* Attach the list of CustomerAccounts to the request as an attribute;
* Forward the request to customerList.jsp.
21. You see where this is going, right? Now we need to edit customerList.jsp to add a forEach loop that will spit out the customer accounts. Remember that we are just giving account details here, not the list of transactions.
22. See if you can get this to work. Remember that you may need to insert some customer account records by hand.
23. Set up the form in customerList,jsp to add a new customer. This will be handled by the doPost method in CreditController. As before, this action should return to the customerList.jsp page.
24. Next, write the **customer.jsp** page following the general pattern above. It should contain a list or table containing the Purchase objects, and an input form for entering a new Purchase. Remember that all requests will go through CreditController, which is mapped to the URL /Customer. Be sure to fill out the controller workflow table above; you’ll see that there is a GET  and a POST request involved.
