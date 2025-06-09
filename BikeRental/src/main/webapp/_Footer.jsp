<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="_FooterOnly.jsp" %>
</body>
<script type="text/javascript">
	$(document).ready(function () {
	    AutoNumeric.multiple('.currency', {
	        digitGroupSeparator: ',',
	        decimalPlaces: 0, // không có phần thập phân
	        modifyValueOnWheel: false
	    });
	});

</script>
</html>