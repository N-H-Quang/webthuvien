<%@page import="model.bean.Loai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<h1 style="text-align: center;">Sữa Loại Sách</h1><%
		Loai  loai=(Loai)request.getAttribute("Loai");
		%>
		<div class="col-sm-11 col-md-offset-1">
			<form  method="post"
				action="SuaLoaiServlet"
				encType="multipart/form-data">
				 <h3>${requestScope["message"]}</h3>
				<p hidden="hidden">
					<label>Mã Loại</label> <input  class="w3-input" type="text"
						name="maloai" value="<%=loai.getMaLoai()%>">
				</p>
				<p>
					<label>Tên Loại</label> <input class="w3-input" type="text"
						name="tenloai" value="<%=loai.getTenloai()%>">
				</p>
				<p>
					<label>Image</label> <input class="w3-input" type="file"
						name="photo" >
				</p>
				<div style="text-align: center;">
					  <button class="btn btn-primary" type="submit" value="submit" name="submit">Sữa loại sách</button>

				</div>
			</form>
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