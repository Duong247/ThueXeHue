<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Chào mừng ${lastName }</h1>
<div class="content-cover">
	<div class="card dashboard-card">
		<div class="card-title">
			<p>Xe máy</p>
			<i class="fa-solid fa-motorcycle icon-title"></i>
		</div>
		<h4 style="font-weight: 600">${bikeCount}</h4>
	</div>
	<div class="card dashboard-card">
		<div class="card-title">
			<p>Lượt thuê</p>
			<i class="fa-solid fa-person icon-title"></i>
		</div>
		<h4 style="font-weight: 600">36</h4>
	</div>
	<div class="card dashboard-card">
		<div class="card-title">
			<p>Doanh thu tháng</p>
			<i class="fa-solid fa-money-bill icon-title"></i>
		</div>
		<h4 style="font-weight: 600">36</h4>
	</div>
</div>

<div id='myDiv'></div>

<script>
var trace1 = {
		  type: 'bar',
		  x: [
			<c:forEach var="r" items="${revenues}">
	            "${r.dayLabel}",
	        </c:forEach>
			  ],
		  y: [
			  <c:forEach var="r" items="${revenues}">
	            ${r.getTotalRevenue()},
	         </c:forEach>
			  ],
		  width:0.4,
		  marker: {
		      color: '#727cf5',
		      line: {
		          width: 2.5
		      }
		  }
		};

		var data = [ trace1 ];

		var layout = {
		  title: {
		    text: 'Doanh thu 7 ngày gần đây'
		  },
		  font: {size: 16},
		  xaxis: {
		    tickmode: 'linear',
		    dtick: 1            
		  }
		};

		var config = {responsive: true}

		Plotly.newPlot('myDiv', data, layout, config );

</script>