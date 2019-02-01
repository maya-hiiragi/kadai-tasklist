<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>詳細ページ</h2>
        <table>
	        <tr>
	            <th>ID</th>
	            <td><c:out value="${tasls.id}"/></td>
	        </tr>
	        <tr>
	            <th>タスク内容</th>
	            <td><c:out value="${tasks.content}"/></td>
	        </tr>
        </table>
        <p><a href="<c:url value='/edit?id=${tasks.id}'/>">このデータを編集する。</a></p>
        <p><a href="#" onclick="confirmDelete();">このデータを削除する。</a></p>
        <form method="post" action="<c:url value='/delete?id=${tasks.id}'/>">
            <input type="hidden" name="_token" value="<c:out value='${_token}'/>">
        </form>
        <script>
        function confirmDelete(){
	        if (confirm("このデータを削除しますか？")){
	            document.forms[0].submit();
	        }
        }
        </script>
        <p><a href="<c:url value='/index'/>">タスク一覧に戻る。</a></p>
    </c:param>
</c:import>