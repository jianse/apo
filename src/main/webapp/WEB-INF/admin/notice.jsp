<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link href="${pageContext.request.contextPath}/admin/images/skin.css" rel="stylesheet" type="text/css"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <style type="text/css">
    <!--
    body {
      margin: 0;
      background-color: #EEF2FB;
    }

    -->
  </style>
  <title></title>
</head>

<body>

<table width="100%" height="1" border="0" cellpadding="0"
       cellspacing="0">
  <tr>
    <td valign="top" bgcolor="#F7F8F9">


      <div align="center">
        <table id="table2" class="line_table" style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
               cellPadding="0">
          <tbody style="margin: 0; padding: 0">
          <tr>
            <td class="line_table" align="center" colspan="8" height="20">
              <span class="left_bt2">公告信息列表</span>
            </td>
          </tr>

          <c:choose>
          <c:when test="${notices==null||notices.isEmpty()}">
          <tr>
            <td class="line_table" align="center" colspan="8" height="20">
              <span class="left_bt2">暂无公告!</span>
            </td>
          </tr>
          </c:when>
          <c:otherwise>
          <tr>
            <td class="line_table" align="center" width="25%">
              <span class="left_bt2">标题</span>
            </td>
            <td class="line_table" align="center" width="40%">
              <span class="left_bt2">内容</span>
            </td>
            <td class="line_table" align="center" width="25%">
              <span class="left_bt2">发布时间</span>
            </td>
            <td class="line_table" align="center" width="10%"></td>
          </tr>
          <c:forEach items="${notices}" var="notice">
          <tr>
            <td class="line_table" align="center" width="20%">
              <span class="left_txt">${notice.name}</span>
            </td>
            <td class="line_table" align="center" width="40%">
              <span class="left_txt">${notice.content}</span>
            </td>
            <td class="line_table" align="center" width="20%">
              <span class="left_txt">${notice.times}</span>
            </td>
            <td class="line_table" align="center" width="20%">
              <a href="${pageContext.request.contextPath}/admin/notice_delete.jsp">删除</a>
            </td>
          </tr>
          </c:forEach>
          </c:otherwise>
          </c:choose>
        </table>
      </div>

    </td>

  </tr>
</table>
</body>
</html>
