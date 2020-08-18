<%@page import="model.bean.BanDoc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<h1 style="text-align: center;">Danh Sách Bạn Đọc</h1>
	<form style="text-align: center; padding: 6px;" action="DanhSachBanDoc">
			<input type="text" placeholder="Search.." name="search">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form>
	
		<div class="row">
			<table class="table table-light col-md-offset-1 " style="width: 80%;">
				<tbody>
					<tr>
						<td>Mã BĐ</td>
						<td>Họ Tên</td>
						<td>Địa Chỉ</td>
						<td>Số Điện Thoại</td>
						<td>Email</td>
						<td>ACtion</td>
					</tr>
					<%
						ArrayList<BanDoc> loais = (ArrayList<BanDoc>) request.getAttribute("listbandoc");
					for (BanDoc loai : loais) {
					%>
					<tr>
					<td><%=loai.getMaBD() %></td>
					<td><%=loai.getHoTen() %></td>
					<td><%=loai.getDiaChi() %></td>
					<td><%=loai.getSdt() %></td>
					<td><%=loai.getEmail() %></td>
					<td><a class="btn btn-danger" href="XoaBanDoc?id=<%=loai.getMaBD()%>">Xóa</a></td>
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