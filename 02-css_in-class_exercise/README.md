##Styling Web Pages with CSS

###Web Programming

In old-school HTML, page styling was accomplished via styling attributes in HTML tags. Beginning in the mid-1990s, this styling information was encoded in a separate language called **Cascading Style Sheets (CSS)**. By the early 2000s, most new browsers implemented CSS1. As of September 2012, browser support for CSS2 is still spotty (to say nothing of CSS3!). For this reason, you should be careful when using CSS2-only features. This tutorial uses basic CSS1 features that should work in all modern browsers.

1. Launch Eclipse. If you have not created a project named **HTML Project**, create a Static Web project with this name. Please let me know if you are having difficulties with your Eclipse installation or creating new Web Projects.
2. Right-click on the project node in Project Explorer view and create a new HTML file named **CSS_Example1.html**. In the second page of the file creation wizard, chose the **HTML 4.01Strict** template.
3.  In the Exercise folder on eLC, open the file **vonManderpootz.html**. Use the View Source option to see the HTML source code. Copy the contents of the page body, starting with `“<h3>Dr. Felix van Manderpootz</h3>”` and paste them to the CSSExample1 file in between the <body> and </body> tags.
4. In the Eclipse edit window, change the title of CSSExample1 from “Insert Title Here” to **“A Brilliant Mind.”** Save the file. 
5. Now use **Open With/Web browser** to view this file. Everything should look OK except that you will not be able to see the image.
6. Go back to the assignment page and locate the image file **MadScientist.jpg**. Save this file to your Web Content folder. In your Web Content view, you should be able to see the location of your Web Content folder.
7. Try **Open With/Web browser** again. You should now be able to see the page in its full glory!
8. Go to http://validator.w3.org and attempt to validate this file by **File Upload**. If you get a message **“Unable to determine parse mode”,** make sure your DTD statement looks like this: -- with no spaces after “HTML 4.01 EN”. Some students have been able to make this work with the word “Strict” in the DOCTYPE statement, but I cannot. Go figure.
9. You should still see the error message shown at right. To see what this is about, look at the Web browser view again. Notice that Dr. van Manderpootz’ list of Admirable Qualities is labeled “A”, “B”, “C”, while the list of Staggering Accomplishments is numbered “1”, “2”, “3”. This must be the effect of the type attribute – let’s check it against the documentation.
10. Open a browser window to http://www.blooberry.com/indexdot/html/index.html. (I keep this URL on my Bookmarks toolbar.) Look up the OL element and scroll down to find the TYPE attribute. You should see that the TYPE attribute exists, but is “Deprecated.” This means that browsers may still recognize the attribute, but future browsers may no longer support it because it is no longer part of the standard.
11. Examine the text in the validator error message. Note that the very first sentence tells you that the document type you are using, HTML 4.01 Strict, does not support this attribute. Other parts of this text suggest possible scenarios involving frames, which are not relevant here. The final “How to Fix” section, suggests, among other things, that we should “use CSS instead of this attribute.” Let’s try it!
12. In the Blooberry reference, navigate back to the Main Index and click the **Index dot CSS** tab. Find **Property Index,** then click Lists. You should see a section about **List** properties.
13. In CSS parlance, a **property** controls a single aspect of how a page is rendered in the browser. Click on the **list-style-type** property. Under **Allowed Values,** find **upper-alpha.** This is the value that should give us the labels “A”, “B”, etc.
14. It’s important to remember that a property is not an attribute. There is an attribute named style that contains a list of properties. Try this in the code:
15. Save the file and open with a Web browser again. You should see the first list marked “A”, “B”, “C”.
16. Go back to **validator.w3.org** and revalidate the file. It should now be valid HTML 4.01 Strict. Yay!
17. If we want to specify multiple properties, these are separated by semicolons. Try the code on the right to specify a font type as well as the list style type. Examine both the Web browser display and the validation output. Of course, you can look up allowable values for the font-family property in the **Display Properties Index** at blooberry.

####CSS selectors
18. CSS also allows you to control which page elements get a particular set of properties. Using cut and paste on the property list, enter this STYLE element into the HEAD section of your document. Also remove the style attribute from the first list item. When you save and view the page, all the OL (ordered list) elements will have the new style. 
19. You can also add styles that affect the entire document, using the BODY selector as shown at right. Examine the effect: the entire page is displayed in Arial font, except for the ordered lists! This demonstrates the “cascading” nature of CSS: since the OL selector is more specific than the BODY selector, the generic BODY style is applied first, followed by the specific OL style which overrides the font family.
20. Also note that we provide a list of possible font-family values. Arial is a specific font resource that is installed on most systems that have a word processor. In case of a machine that does not have Arial font installed, the browser falls back to its generic sans-serif font. (A sans-serif font lacks the little curlicues on letters that are found in a serif font. Most of this document is typed in a sans-serif font, but these words are in a serif font.
21. What if we want only some of the OL elements to be in our different style, we can use a **CSS class**, also called a **named style**. Change the STYLE section as shown at right. Then modify the first OL tag as follows, to specify the named style: . This time, only the first list should appear in the special style.
22. The most specific selector of all is restricted to a single element. Add the following style specification as shown at right. This selector applies only to the element whose id attribute is “modest.” Like a student id, the HTML id attribute must be unique for all elements in a document. Give the list item describing Dr. van Manderpootz’ becoming modesty this id value: . Now this list item, and no others, will appear as red boldfaced text.
####Pseudo-class selectors:
23. It’s also possible to define CSS selectors that take effect only in specific circumstances. Try the new CSS code at right. Save and check the effect: each LI item turns green when the mouse pointer hovers over it, except the modesty item. Can you guess why that item does not change?

A complete list of CSS selectors can be found in the **Selectors** part of Index dot CSS.

####Centering tables with the margin property
24. We often want to center a table on the page. This is accomplished by setting the CSS margin property to the special value **“auto.”** Try this out by editing the style attribute of the TABLE tag: Try it!  
This trick for centering tables is not well documented. Our blooberry.com CSS page says only that the ‘auto’ property allows the margins to be set by the browser – it does not mention anything about centering. And besides, how would we know to use the margin property?  
In situations like this, I like to Google. Try a Google search on “center table css.” Recall that for most effective searching, we think of a set of words that should all be in the documents we want, but not in documents we don’t want. For example, if you search for just “center table,” you may get some results you want, but also some nice photos of tables for the center of your dining room, and a really interesting article about the Chinese national table tennis training center. But let’s not get distracted, shall we?

####Using the float property to align images
25. In this example we use a TABLE to lay out the image and the lists side by side. This works well enough, but the preferred solution is to float the text around the image. Remove all the `<table>, <tr>, and <td>` tags, and their closing tags, and move the IMG tab up to just after the headings. Now add an image selector to the style tag as shown at right. This makes all the images float to the right, while text flows around them.
Of course, you might want some of your images to float to the right and others to float to the left. In this case, you can use the style attribute or, better yet, named classes.

####Visibility and display properties
26. You can make an element invisible by setting its **visibility** property to hidden, as shown at right. Try this out. The second list item becomes invisible, but it still takes up space and uses up a label value (that is, the visible third item is labeled “C”).
27. On the other hand, try this: . Now the second item is not only invisible, it does not take up space or use up a label value. It is as if the element does not exist! In future, we will use this trick to make page elements appear and disappear after the page has loaded, using JavaScript.

####Take an inventory of the style
28. Although we’ve defined several style properties for our table, in fact there are lots more. Your browser chooses a whole collection of default style properties when the page author (that’s you!) does not specify the style. Looking at these properties is interesting because it can give us more ideas for style properties we can tweak.
29. Launch the Firefox browser1 and open this page. In the **Tools** menu, launch Firebug. 
* Don’t see the File menu to open the file? You are probably in the one of the newer Firefox version. Try Firefox /New Tab.
* Don’t see the Tools menu? You are probably in the one of the newer Firefox version. Try Tools /Web Developer.
* Don’t see Firebug? Use the Tools/Web Developer/Get More Tools menu item to add it. You will need to restart Firefox.
30. Navigate to first OL element (you will need to open the HTML and BODY elements). Click the  tab on the left and the  tab on the right. You will see a plethora of properties. 

####Validating CSS
31. This brings up the issue of cross-browser CSS compatibility. You may design a page that looks great in your browser of choice, but crummy in other browsers because you used non-standard CSS. The best defense against cross-browser incompatibilities in CSS is the same as in HTML: validate the page to verify that it uses standard CSS. Try validating your page at W3C validator site http://jigsaw.w3.org/css-validator. Choose the  tab and copy the contents of your <style> tag, as shown here.

####Relative and absolute positioning
Now we will show how to control where a page element appears. Normally, the browser lays out elements one after the other, in what is called normal document flow, but we can change this.

32. Create a new HTML page CSS_Example2, using HTML 4.01 Strict of course!  Set the title to “Relative and Absolute Positioning.” Enter the content shown at right into the body. Here:
* Padding-top  puts space above the P element, so that the trick we are about to pull does not lead to overlapping text;
* An em is a typographical measure equal to the width of a letter “m.” It makes a good Scrabble © word.
* the SPAN element is a container used for the purpose of sticking style onto inline content, such as a chunk of text inside a paragraph.

33. Check out the results in the browser. You should see that the SPAN element has been lifted from its original position. This is determined by the property top in the style. In the browser world, vertical position is measured from the top down. (This is the opposite of x-y coordinates in algebra). So a negative displacement, -1 em, moves the element up. Notice also that the original position of the SPAN is still there and determines the flow of the remaining elements. This is similar to the effect of the visibility:hidden style property in the last exercise.

Now add the code shown at right. This time we use **absolute positioning**, which allows us to put the element anywhere we like. You should see that the original position has been removed from the document flow. The top position is now measured down from the top of the page. 

You can use absolute positioning to create effects in which text overlays images. I used an IMG tag and three P tags to create the effect below. Can you match it? This exact photo is no longer available, but you can use the current Amazing Student page at http://www.uga.edu/amazing/directory/. Don’t be shy about validating as you go along!

That’s it! Upload your finished page to eLC. You are now a CSS wizard!
