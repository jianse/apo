<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- <link href="images/common.css" rel="stylesheet" type="text/css" /> -->
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
</head>
<body>
<table width="100%" height="1" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td valign="top" bgcolor="#F7F8F9">
            <div align="center">
                <table id="table2" class="line_table" style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
                       cellPadding="0">
                    <tbody style="margin: 0; padding: 0">
                    <tr>
                        <td class="line_table" align="center" colspan="11" height="20"><span
                                class="left_bt2">菜单信息列表</span></td>
                    </tr>
                    <tr>
                        <td class="line_table" align="center"><span
                                class="left_bt2">菜单名称</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">展示图片</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">原料</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">类型</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">说明</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">市场价格</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">市场价销售数量</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">会员单价</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">会员价销售数量</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">&nbsp;</span></td>
                        <td class="line_table" align="center"><span
                                class="left_bt2">&nbsp;</span></td>
                    </tr>

                    <c:choose>
                        <c:when test="${menusData.total==null||menusData.total==0}">
                            <tr>
                                <td class="line_table" align="center" colspan="11">暂无数据!</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${menusData.data}" var="item">
                        <tr>
                            <td class="line_table" align="center">
                                <a href="${pageContext.request.contextPath}/admin/menus_update.jsp?id=${item.id}">${item.name}</a>
                            </td>
                            <td class="line_table" align="center">
                                <a href="${pageContext.request.contextPath}${item.imgpath==null?"/img/default.png":item.imgpath}" target="_blank">
                                    <img src="${pageContext.request.contextPath}${item.imgpath==null?"/img/default.png":item.imgpath}" width="30" height="30" alt="${item.name}">
                                </a>
                            </td>
                            <td class="line_table" align="center"><span class="left_txt">${item.burden}</span></td>
                            <td class="line_table" align="center"><span class="left_txt">${item.typeid}</span></td>
                            <td class="line_table" align="center"><span class="left_txt">${item.brief}</span></td>
                            <td class="line_table" align="center"><span class="left_txt">${item.price}</span></td>
                            <td class="line_table" align="center"><span class="left_txt">${item.sums}</span></td>
                            <td class="line_table" align="center"><span class="left_txt">${item.price1}</span></td>
                            <td class="line_table" align="center"><span class="left_txt">${item.sums1}</span></td>
                            <td class="line_table" align="center">
                                <a href="${pageContext.request.contextPath}/admin/menus_update.jsp?id=${item.id}">修改</a>
                            </td>
                            <td class="line_table" align="center">
                                <a href="${pageContext.request.contextPath}/admin/menus_delete.jsp?id=${item.id}">删除</a>
                            </td>
                        </tr>
                        </c:forEach>
                            <tr>
                            <td class="line_table" align="center" colspan="11" height="20">
                                    <span class="left_bt2">第${menusData.pageNum}页
                                            &nbsp;&nbsp;共${menusData.pages}页
                                    </span>&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/admin/menus.jsp?pageNum=1">[首页]</a>
                                <a href="${pageContext.request.contextPath}/admin/menus.jsp?pageNum=${menusData.pages}">[尾页]</a>&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/admin/menus.jsp?pageNum=${menusData.pageNum-1}">[上一页]</a>
                                <a href="${pageContext.request.contextPath}/admin/menus.jsp?pageNum=${menusData.pageNum+1}">[下一页]</a>
                            </td>
                        </tr>
                        </c:otherwise>
                    </c:choose>
                </table>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
