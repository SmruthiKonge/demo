<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/contents/header.jsp" %>
	<div class="container wrapper">
		<div class="container">
			<div class="page-header">
			<br>
				<h1>ALL Prodcuts</h1>
				<p class="lead">Checkout all products available now!</p>
			</div>
			<table class="table table-striped table hover">
				<thead>
					<tr class="bg-success">
						<th>Photo Thumb</th>
						<th>Product Name</th>
						<th>Category</th>
						<th>Description</th>
						<th>Price</th>
						<th> </th>

					</tr>
				</thead>
				<c:forEach items="${products}" var="product">
				
				<tr>
				<td><img src= "<c:url value="/resources/images/${product.id}.png" />" alt="image" style="width:30%"/></td>     
				<td>${product.name}</td>
				<td>${product.categoryId}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td><a href="<spring:url value="/productList/viewProduct/${product.id }"/>"> 
				<span class="glyphicon glyphicon-info-sign"></span>
				</a></td>
				</tr>
				</c:forEach>
			</table>
<%@include file="/WEB-INF/views/contents/footer.jsp" %>			