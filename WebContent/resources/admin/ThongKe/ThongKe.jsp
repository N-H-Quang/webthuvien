<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<h1 style="text-align: center;">Danh Sách Thể Loại</h1>
			<div style="text-align: center; padding: 6px;">
				<input type="text" placeholder="Search..">
				<i class="fa fa-search"></i>
			</div>
			<div class="row">
				<table class="table table-light col-md-offset-1 " style="max-width: 80%;">
					<tbody>
						<tr>
							<td>Tên Sách</td>
							<td>Thể Loại</td>
							<td>tác Giả</td>
							<td>NXB</td>
							<td>Image</td>
							<td>Hiện Còn</td>
						</tr>
						<tr>
							<td>Javacore</td>
							<td>Lập Trình</td>
							<td>Nguyễn Tấn Huy</td>
							<td>2020</td>
							<td><img src="http://placehold.it/50/30a5ff/fff"></td>
							<td>50
							</td>
						</tr>
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
s
