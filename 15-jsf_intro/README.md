##Intro to Java Server Faces

###CSCI 4300
Introduction: So far, we have built our MVC applications “by hand,” so to speak, defining the Model, View, and Controller classes and linking them together. This exposes us to risks such as the scenario depicted below, in which a clever user goes around the Controller and accesses a secure resource without being authenticated.

In industry practice it is more common to use an MVC framework, which auto-generates some of the code and protects us against this sort of vulnerability. Java Server Faces and Spring MVC are two of the most popular frameworks. In my experience, JSF has the less steep learning curve.

This document is just an intro to an online JSF tutorial. Before starting the online tutorial, we need to do a bit of configuration.
1. Download the javax.faces.jar file from eLC. This replaces the jsf-impl and jsf-api files mentioned in the tutorial.
2. In Eclipse, create a new Dynamic Web project named JSF Examples. In the Wizard panel where you name the project, select a Java Server Pages 2.1 configuration.
3. Continuing in the New Project Wizard, click the checkbox to create a stub web.xml on the fourth pane.
4. In the fifth pane, you are asked to pick the JSF library, but you don’t have one! Click the Library Manager icon . Create a new library named JSF Library. Then choose  and add the javax.faces.jar file. Select this library and you should be good to go!
5. Now you can follow the rest of the steps in the online tutorial at http://www.eclipse.org/webtools/jsf/dev_resource/JSFTutorial-RC3/JSFTools_tutorial.html. You can quit when you have created a basic login page and content page.
6. Zip it and ship it! Upload to eLC and submit. This may be your future life as a Web developer!
