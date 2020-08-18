<%@page import="model.bean.Loai"%>
<%@page import="model.bean.Sach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<!--/.sidebar-->
<div class="col-sm-8 col-sm-offset-3 col-lg-10 col-lg-offset-3 main"
	style="max-width: 60%;">
	<div class="row">
		<h1 style="text-align: center;">Danh Sách Sách</h1>
		<table class="table table-light">
			<tbody>
				<tr>
					<td>Tên Sách</td>
					<td>Thể Loại</td>
					<td>Tác Giả</td>
					<td>nhà xuất bản</td>
					<td>nxb</td>
					<td>Hình Ảnh</td>
					<td>Hiện Còn</td>
					<td>Số lần mượn</td>
					<td>ACtion</td>
				</tr>
				<%
					ArrayList<Sach> loais = (ArrayList<Sach>) request.getAttribute("listsach");
				for (Sach loai : loais) {
				%>
				<tr>
					<td><%=loai.getTenSach() %></td>
					<td><%=loai.getTheLoai() %></td>
					<td><%= loai.getTacGia() %></td>
					<td><%= loai.getNhaXuatBan() %></td>
					<td><%= loai.getNamXuatban() %></td>
					<td><img style="width: 50px" src="${pageContext.request.contextPath}/resources/img/<%=loai.getAnhSach()%>"></td>
					<td><%=loai.getSoHienCon() %></td>
					<td><%=loai.getSoLanMuon() %></td>
					<td><a class="btn btn-danger" href="Xoasach?id=<%=loai.getMaSach()%>">Xóa</a>
						<a class="btn btn-success" href="SuaSach?id=<%=loai.getMaSach()%>">Sửa</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
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