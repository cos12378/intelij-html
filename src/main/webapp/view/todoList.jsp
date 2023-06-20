<%@ page import="dto.TodoJoinuser" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
  <tr>
    <td>id</td>
    <td>content</td>
    <td>작성자</td>
    <td>작성일</td>
    <td>check</td>
    <td>수정</td>
  </tr>



<%
  List<TodoJoinuser> todos = (List<TodoJoinuser>)request.getAttribute("todolist");
  if(todos.size()!=0)
  for (TodoJoinuser todo:todos){

    %>
    <tr>
      <td><%= todo.getId()%></td>
      <td><%= todo.getName()%></td>
      <td><%= todo.getContent()%></td>
      <td><%= todo.getCreateAt()%></td>
      <td><%= todo.isChecked()%></td>
      <%
        if(session.getAttribute("uid")==todo.getUid()){
          /%>
      <td>
        <a href= "todoupdate?todoid<%= todo.getId()%>">수정</a>
      </td>
      <%
        }
        /%>
    </tr>
  <%}

%>
</table>