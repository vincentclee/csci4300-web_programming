<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSF Tutorial</title>
<f:loadBundle basename="com.tutorial.messages" var="msg"/>
</head>
<body>
	<h:form>
		<h:messages layout="table"></h:messages>
		<h:panelGrid columns="2">
			<h:outputLabel rendered="true" value="#{msg.name}"></h:outputLabel>
			<h:inputText value="#{loginBean.name}" tabindex="0"></h:inputText>
			<h:outputLabel rendered="true" value="#{msg.password}"></h:outputLabel>
			<h:inputSecret value="#{loginBean.password.convertedID}">
				<f:converter converterId="javax.faces.Long"></f:converter>
				<f:validator validatorId="com.tutorial.validatePassword"></f:validator>
			</h:inputSecret>
		</h:panelGrid>
		<h:commandButton action="login" value="#{msg.login}"></h:commandButton>
	</h:form>
</f:view>
</body>
</html>