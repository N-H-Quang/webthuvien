<%@page import="model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<h1 style="text-align: center;">Danh Sách Nhân Viên</h1>
			<table class="table table-light col-sm-offset-1" style="max-width: 80%;">
				<tbody>
					<tr>
						<td>Họ Tên</td>
						<td>Chức Vụ</td>
						<td>Age</td>
						<td>Số Điện Thoại</td>
						<td>Lương</td>
						<td>ACtion</td>
					</tr>
					 <%
                    	ArrayList<NhanVien> nhanViens = (ArrayList<NhanVien>)request.getAttribute("listnv");
                    	for(NhanVien nhanVien:nhanViens){
                    %>
                    <tr>
                    <td><%= nhanVien.getTenNV() %></td>
                    <td><%= nhanVien.getChucVu()%></td>
                    <td><%= nhanVien.getTuoi() %></td>
                    <td><%= nhanVien.getSDT() %></td>
                    <td><%= nhanVien.getLuong() %></td>
                    <td><a class="btn btn-danger" href="XoaNhanVien?msv=<%= nhanVien.getMaNV() %>">Xóa</a><a class="btn btn-success" href="SuaNhanVien?msv=<%= nhanVien.getMaNV() %>">Sửa</a></td>
                    
                    <td>
                    </tr>
                    <%
                    	}
                    %>
					
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