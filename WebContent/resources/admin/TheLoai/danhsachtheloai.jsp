<%@page import="model.bean.TheLoai"%>
<%@page import="model.bean.Loai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<h1 style="text-align: center;">Danh Sách Thể Loại</h1>
		<form style="text-align: center; padding: 6px;" action="DanhSachTheLoai">
			<input type="text" placeholder="Search.." name="search">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form>
		<div class="row">
			<table class="table table-light col-md-offset-1 ">
				<tbody>
					<tr>
						<td>Mã Loại</td>
						<td>Mã Thể Loại</td>
						<td>Tên Thể Loại</td>
						<td>ACtion</td>
					</tr>
					<%
						ArrayList<TheLoai> loais = (ArrayList<TheLoai>) request.getAttribute("listtl");
					for (TheLoai loai : loais) {
					%>
					<tr>
						<td><%=loai.getMaloai()%></td>
						<td><%=loai.getMaTheLoai()%></td>
						<td><%=loai.getTenTheLoai()%></td>
						<td><a class="btn btn-danger" href="xoatheloai?id=<%=loai.getMaTheLoai()%>">Xóa</a>
							<a href="SuaTheLoaiServlet?id=<%= loai.getMaTheLoai() %>" class="btn btn-success">Sửa</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

</div>
<script src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/chart.min.js"></script>
<script src="resources/js/chart-data.js"></script>
<script src="resources/js/easypiechart.js"></script>
<script src="resources/js/easypiechart-data.js"></script>
<script src="resources/js/bootstrap-datepicker.js"></script>
<script src="resources/js/custom.js"></script>
<script>
	window.onload = function() {
		var chart1 = document.getElementById("line-chart").getContext("2d");
		window.myLine = new Chart(chart1).Line(lineChartData, {
			responsive : true,
			scaleLineColor : "rgba(0,0,0,.2)",
			scaleGridLineColor : "rgba(0,0,0,.05)",
			scaleFontColor : "#c5c7cc"
		});
	};
</script>

</body>

</html>
