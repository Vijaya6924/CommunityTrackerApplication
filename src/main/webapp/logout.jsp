<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Invalidate session
    if (session != null) {
        session.invalidate();
    }

    // Redirect to login.jsp with message
    response.sendRedirect("login.jsp");
%>
