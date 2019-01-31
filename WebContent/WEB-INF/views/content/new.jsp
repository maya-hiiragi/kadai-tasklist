<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>作成ページ</h2>
        <form method="post" action="<c:url value='/create'/>">
            <c:import url="../layout/_form.jsp"></c:import>
        </form>
        <p><a href="<c:url value='/index'/>">タスク一覧に戻る。</a></p>
    </c:param>
</c:import>