<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 2019-07-11
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shoppingCart.css">
    <script src="${pageContext.request.contextPath}/js/shoppingCart.js"></script>
    <title>Shopping Cart</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">ShoppingCart</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <a class="btn btn-outline-info my-3 my-sm-0" href="${pageContext.request.contextPath}/main">Products</a>
        </ul>
        <form action="${pageContext.request.contextPath}/main" class="form-inline my-2 my-lg-0" method="post">
            <c:if test="${user != null}">
                <a class="nav-link" href="#">Hello ${user.username} <span class="sr-only"></span></a>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</button>
            </c:if>
            <c:if test="${user == null}">
                <a class="nav-link" href="#">Hello Guest<span class="sr-only"></span></a>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</a>
            </c:if>

        </form>
    </div>
</nav>
<div class="container">
    <div class="shopping-list">
        <ul class="list-group">
            <c:forEach items="${shoppingCart}" var="shoppingItem">
                <div class="my-item">
                    <span hidden>${shoppingItem.product.id}</span>
                    <img src="${shoppingItem.product.productUrl}"
                         class="img-thumbnail rounded float-left my-img" alt="${shoppingItem.product.productName}">
                    <div class="right-side">
                        <h5 class="card-title">${shoppingItem.product.productName}</h5>
                        <p class="card-text">${shoppingItem.product.productDes}</p>
                        <p class="card-text">Per Price :${shoppingItem.product.price}</p>
                        <p class="card-text">Number:${shoppingItem.number}</p>
                        <p class="card-text">Total:$${shoppingItem.number * shoppingItem.product.price}</p>
                    </div>
                </div>
            </c:forEach>
        </ul>
    </div>
    <div id="my-bottom">

        <div>   <label>You total price : $</label>  ${totalPrice}</div>
        <c:if test="${user != null}">
            <button id="checkoutModelButton" type="button" class="btn btn-primary" data-toggle="modal" id="checkout" data-target="#checkoutModel">
                Check out
            </button>
        </c:if>
        <c:if test="${user == null}">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                Check out
            </button>
        </c:if>
    </div>

    <!-- Button trigger modal -->


    <div class="modal fade" id="checkoutModel" tabindex="-1" role="dialog"
         aria-labelledby="checkoutModelTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="checkoutModelTitle">Info</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div>
                        <label>PaymentType</label>
                        <input type="radio" checked value="visa" name="paymentType"><label> visa</label>
                        <input type="radio"  value="master" name="paymentType"><label> master</label>

                    </div>

                  <label>You total price : $</label>  ${totalPrice}
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button id="confirm" type="button" class="btn btn-primary">Confirm</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Warning</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    You must be login in
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">Login</a>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
