<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

  <script  src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
  <script src="/webstore/resource/js/controllers.js"></script>
  
  <section class="container" ng-app="cartApp">
      <div class="pull-right" style="padding-right:50px">
	  	<a href="product?id=${product.productId}&language=en" >English</a>|<a href="product?id=${product.productId}&language=nl" >Dutch</a>
	</div>
    <div class="row">
       <div class="col-md-5">
  			<img src="<c:url value="/resource/images/${product.productId}.JPG"></c:url>" alt="image"  style = "width:100%"/>
	  </div>
      <div class="col-md-5">
        <h3>${product.name}</h3>
        <p>${product.description}</p>
        <p>
          <strong><spring:message code="productDetail.productId.label"/> </strong><span class="label label-warning">${product.productId}</span>
        </p>
        <p>
          <strong><spring:message code="productDetail.manufacturer.label"/></strong> : ${product.manufacturer}
        </p>
        <p>
          <strong><spring:message code="productDetail.category.label"/></strong> : ${product.category}
        </p>
        <p>
          <strong><spring:message code="productDetail.availableUnitsInStock.label"/> </strong> : ${product.unitsInStock}
        </p>
        <h4>${product.unitPrice} USD</h4>
        <p ng-controller="cartCtrl">
          <a href="<spring:url value="/products" />" class="btn btn-default">
			   <span class="glyphicon-hand-left glyphicon"></span> back
	      </a>
          <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"> <span
            class="glyphicon-shopping-cart glyphicon"></span> Order Now
          </a>
          <a href="<spring:url value="/cart" />" class="btn btn-default">
  			<span class="glyphicon-hand-right glyphicon"></span> View Cart
		</a>
        </p>
      </div>
    </div>
  </section>
