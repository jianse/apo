<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/admin/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/verify.js"></script>
<script type="text/javascript">
	function verifyInfo() {
		if(!verifyNotNull(document.form1.name.value)) {
			alert("菜品类别不能为空");
			return false;
		}
	}
</script>
	<title></title>
</head>

<body>

	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<p>添加类别</p>
				<div align="center">
					<form action="${pageContext.request.contextPath}/admin/type_add.jsp" method="post" name="form1" onSubmit="return verifyInfo()">
						<table id="table2" class="line_table" style="width: 100%; margin: 0; padding: 0" cellSpacing="0" cellPadding="0">
							<tr>
								<td class="line_table" height="25" align="right" width="40%">
									<span class="left_bt2">菜品类别：</span>
								</td>
								<td class="line_table" height="25" width="60%">
									<input type="text" name="name" size="45" value="">
								</td>
							</tr>
							<tr>
								<td class="line_table" height="25" align="center" colspan="2">
									<input type="submit" value="添加">
								</td>
							</tr>
						</table>
					</form>
				</div>


			</td>


		</tr>
	</table>
</body>
</html>
