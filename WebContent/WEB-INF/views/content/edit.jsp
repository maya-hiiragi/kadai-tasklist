<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>編集ページ</h2>
        <form method="post" action="<c:url value='/update?id=${tasks.id}'/>">
            <c:import url="../layout/_form.jsp"></c:import>
        </form>
        <a href="<c:url value='/show?id=${tasks.id}'/>">詳細ページに戻る。</a>
    </c:param>
</c:import>