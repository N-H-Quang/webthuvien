<%@page import="model.bean.PhieuMuon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<h1 style="text-align: center;">Danh Sách Phiếu Mượn</h1>
		<div style="text-align: center; padding: 6px;">
			<input type="text" placeholder="Search.."> <i
				class="fa fa-search"></i>
		</div>
		<div class="row">
			<table class="table table-light col-md-offset-1 " style="width: 80%;">
				<tbody>
					<tr>
						<td>Mã Phiếu Mượn</td>
						<td>Tên bạn Đọc</td>
						<td>Tên Sách</td>
						<td>Ngày Mượn</td>
						<td>Ngày Phải Trả</td>
						<td>Ngày Trả</td>
						<td>Trạng Thái</td>
						<td>ACtion</td>
					</tr>
					<%
						ArrayList<PhieuMuon> loais = (ArrayList<PhieuMuon>) request.getAttribute("listpm");
					for (PhieuMuon loai : loais) {
					%>
					<tr>
						<td><%= loai.getMaPM() %></td>
						<td><%= loai.getTenBD() %></td>
						<td><%= loai.getTenSach() %></td>
						<td><%= loai.getNgayMuon() %></td>
						<td><%= loai.getNgayPhaiTra() %></td>
							<td><%= loai.getNgayTra() %></td>
						<td><a href="SetTrangThaiServlet?id=<%=loai.getMaPM()%>" class="btn"><%= loai.getTrangThai() %></a></td>
						<td><a class="btn btn-danger" href="XoaPhieuMuon?id=<%= loai.getMaPM() %>">Xóa</a></td>
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