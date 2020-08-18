<%@page import="model.bean.TheLoai"%>
<%@page import="model.bean.Loai"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/resources/template/header.jsp" />
<!--/.sidebar-->
<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
	<div class="row">
		<div class="row">
			<h1 style="text-align: center;">Sửa thể loại</h1>
			<% TheLoai theloai=(TheLoai)request.getAttribute("theloai");
			%>
			<div class="col-sm-11 col-md-offset-1">
				<form action="SuaTheLoaiServlet?id=<%=theloai.getMaTheLoai() %>" method="post">
					<p hidden="">
						<label>Mã thể Loại</label>
						<input class="w3-input" type="text" name="matl" value="<%=theloai.getMaTheLoai() %>">
					</p>
					<p>
						<label>Tên Loại</label>
						<select class="w3-input" id="cars" name="mal">
							<%
							ArrayList<Loai> loais = (ArrayList<Loai>)request.getAttribute("listloai");
	                    	for(Loai loai:loais){
							%>
							<option <% if(loai.getMaLoai().compareTo(theloai.getMaloai())==0) out.print("selected"); %>  value="<%=loai.getMaLoai() %>"><%=loai.getTenloai() %></option>
							<%
							}
							%>
						  </select>
					</p>
					<p>
						<label>Tên Thể loại </label>
						<input class="w3-input" type="text" name="tentl" value="<%= theloai.getTenTheLoai()%>">
					</p>
					<div style="text-align: center;">
					   <button class="btn btn-primary" type="submit" value="submit" name="submit">Sửa Thể Loại</button>

				</div>
				</form>
			</div>
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
