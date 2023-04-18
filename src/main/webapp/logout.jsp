<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
session.invalidate();
PrintWriter writer = response.getWriter();
writer.println("<script>alert('로그아웃 되었습니다'); location.href='/exer/homeController?action=search&cid=5';</script>");
writer.close();
%>