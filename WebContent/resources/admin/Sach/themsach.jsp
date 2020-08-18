<%@page import="model.bean.TheLoai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<h1 style="text-align: center;">Thêm  Sách</h1>
			<div class="col-sm-11 col-md-offset-1">
				<form action="ThemSachServlet" method="post"encType="multipart/form-data">
					<p>
						<label>Mã Sách</label>
						<input class="w3-input" type="text" name="masach">
					</p>
					<p>
						<label>Tên Sách</label>
						<input class="w3-input" type="text" name="tensach">
					</p>
					<p>
						<label>Thể  Loại</label>
						<select class="w3-input" id="cars" name="theloai">
							<%
							ArrayList<TheLoai> loais = (ArrayList<TheLoai>)request.getAttribute("listtheloai");
	                    	for(TheLoai loai:loais){
							%>
							<option   value="<%=loai.getMaTheLoai() %>"><%=loai.getTenTheLoai() %></option>
							<%
							}
							%>
						  </select>
					</p>
					<p>
						<label>Tác giả</label>
						<input class="w3-input" type="text" name="tacgia">
					</p>
					<p>
						<label>Nhà Xuất bản</label>
						<input class="w3-input" type="text" name="nxb">
					</p>
					<p>
						<label>Năm xuất bản</label>
						<input class="w3-input" type="text" name="namxb">
					</p>
					<p>
						<label>Image</label> <input class="w3-input" type="file"
						name="photo" >
					</p>
					<p>
						<label>Hiện Còn</label>
						<input class="w3-input" type="number" name="hiencon">
					</p>
					<p>
						<label>Số lượng </label>
						<input class="w3-input" type="number" name="sl">
					</p>
					<div style="text-align: center;">
					  <button class="btn btn-primary" type="submit" value="submit" name="submit">Thêm Sách</button>

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