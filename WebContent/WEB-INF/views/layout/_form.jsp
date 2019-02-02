<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input name="_token" type="hidden" value="<c:out value='${_token}'/>">

<label id="id">ID</label>
<c:choose>
    <c:when test="${tasks.id == 0}">
        <input name="id" type="text" disabled="disabled">
    </c:when>
    <c:otherwise>
        <input name="id" type="text" disabled="disabled" value="<c:out value='${tasks.id}'/>">
    </c:otherwise>
</c:choose>
<br/>

<label id="content">タスク内容</label>
<input name="content" type="text" value="<c:out value='${tasks.content}'/>">
<br/>
<br/>

<input type="submit" value="反映">