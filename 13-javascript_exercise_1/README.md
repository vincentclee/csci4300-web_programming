##JavaScript for Java Programmers

###CSCI 4300

####Introduction: what is JavaScript? 
JavaScript, CSS, and HTML are all languages used in Web pages:
* HTML describes the **page layout**, such as headers, text, images, tables, lists, etc.
* CSS describes the **styles** of the page elements, such as their colors, font sizes, and background colors;
* JavaScript describes the **interactive behavior** of the page: actions the page takes in response to user **events** such as clicking a mouse button.

JavaScript has very little to do with Java. The name “JavaScript” was chosen as a marketing ploy by Netscape in its battles with Microsoft. Microsoft likes to promote a Microsoft-specific language called Jscript, which is almost the same JavaScript. 

Historically, JavaScript has been plagued with **browser incompatibility** problems: code that works fine in one browser does not work in others. Fortunately, the **World-Wide-Web Consortium (W3C)** has published **standards** for JavaScript, which are now supported by all major browsers. All the code we will write in this class adheres to the standards, so your code should work unless your users are equipped with older browsers (such as the Netscape 4 browser).

Although the code we write should work in any new browser, we will be using Mozilla Firefox for this exercise. One of the newest browsers, Firefox is equipped with some useful development tools which will ease your transition into JavaScript.

####First JavaScript Example
1. Launch Eclipse and create a new Dynamic Web Project named JavaScript Examples. We’ll be using this project for the next few exercises.
2. Create a new HTML file (not a JSP file!) named vonManderpootz.html. You can copy the contents of this page either from the existing file in your HTML project or by downloading from the assignment page on eLC.
3. Launch Mozilla Firefox and open the Tools/Web Developer menu. I have underlined the tools I use for Web development. If you don’t have these tools, use Get More Tools to get them. (You can use Firebug to view the DOM, so DOM inspector is not really necessary. I will use Firebug to view the DOM in these screenshots.)
4. Use Firefox to open the vonManderpootz.html file (it’s in your workspace folder). Open Firebug and click the HTML tab. Try opening and closing some of the elements. Note that the corresponding sections of the visible pages light up when you select various elements in the document. Way cool, eh?
5. In 
6. Note the <TBODY> element, which does not correspond to the HTML code! Mozilla creates this element as part of the Document Object Model, which we will discuss in class.
7. Close down Firebug for now. Enter the boxed code into the <head> section of your document. The predefined alert function pops up a dialog box. 
8. Save the file and reload it in Firefox. You should see the cheery hello message!You must click OK before you can see the page content.
Functions and event handlers
9. In our first example, the alert box pops up before the page contents are displayed. To control when an action takes place, we convert the action to a function, as shown at right.  Note that since JavaScript is a weakly typed language, functions do not have return types.
10. Save the file and reload in Firefox. This time you will not see the cheery alert box, because the function has not been called. To make the box pop up on demand, we will add an event handler.
Event handlers
11. Add an <input> element to the code after the end of the table, as shown at right. Save in Eclipse and reload the page. You should see a button that pops up the alert box when clicked. Note that this input is not in a <form> tag, because it will not submit data to a server.
12. Use if you have DOM Explorer, use it to explore the INPUT element. You will see that this element has three attributes: its type (button), value (‘Click to say hello’) and the onclick event handler.
13. One of our favorite JavaScript ricks is creating rollover effects.  We do this by invoking the onMouseOver event handler, which fires when the mouse pointer moves over an element. Add the code changes shown here and define a function to pop up an alert box saying “Ouch! You stepped on me!” when the user rolls the mouse over the element. 
To be continued…
