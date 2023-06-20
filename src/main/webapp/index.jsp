<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.List" %>
<%@ page import ="dto.TodoJoinuser" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<h2>Hello World!</h2>
    <tr>
        <td>id</td>
        <td>content</td>
        <td>작성일</td>
        <td>check</td>
        <td>수정</td>
    </tr>
    <table>
        <c:forEach items="${todolist}" var = "todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.getContent()}</td>
                <td>${todo.getCreateAt()}</td>
                <td>${todo.getName()}</td>
                <td>${todo.isChecked()}</td>
            </tr>
        </c:forEach>
    </table>

<%--<c:if test="${sessionScope.get('uid')!=null}"><a>로그아웃</a></c:if>--%>
<%--<c:if test="${sessionScope.get('uid')==null}"><a>로그인</a></c:if>--%>
<%--<c:forEach begin="0" end="10" step="1" var="i">--%>
<%--    <c:when test="${i}%2==0"></c:when>--%>
<%--        <h1>${i}짝수</h1>--%>
<%--    <h1>${i}</h1>--%>
<%--    <c:otherwise>--%>
<%--        <h1>${i}홀수</h1>--%>
<%--    </c:otherwise>--%>
<%--</c:forEach>--%>

<%--    <%--%>
<%--    for (int i=0; i<=10; i++) {--%>
<%--    %>--%>
<%--    <h1><%=i%></h1>--%>
<%--<%--%>
<%--}--%>
<%--    %>--%>


</body>

</html>
