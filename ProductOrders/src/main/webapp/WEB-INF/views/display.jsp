 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productorders.model.Product,com.productorders.model.Order" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <style type="text/css">
    body {
        background-color: #f8f9fa;
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    h2 {
        color: #333;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #aab7b9;
    }

    a.button {
        display: inline-block;
        padding: 10px 15px;
        text-decoration: none;
        background-color: #aab7b9;
        color: #FFFFFF;
        border-radius: 4px;
        transition: background-color 0.3s;
    }

    a.button:hover {
        background-color: #888;
    }

    .productName, .productUsage {
        color: #333;
    }

    .editLink, .deleteLink {
        color: #007bff;
    }

    .editLink:hover, .deleteLink:hover {
        color: #0056b3;
    }

    /* Added styling for the search form */
    form {
        margin-bottom: 20px;
    }

    form input[type="number"],
    form input[type="text"],
    form input[type="submit"],
    form button.resetButton {
        color:black;
        padding: 10px 15px;
        margin-right: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    form input[type="number"],
    form input[type="text"],
    form input[type="submit"] {
        background-color: #aab7b9;
        color: black;
    }

    form button.resetButton {
        background-color: #dc3545;
        color: #fff;
    }

    form input[type="number"]:focus,
    form input[type="text"]:focus {
        outline: none;
        background-color: #ddd;
    }

    form input[type="submit"]:hover,
    form button.resetButton:hover {
        background-color: #888;
    }
</style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        function redirectToForm() {
            window.location.href = "/ProductOrders/";
        }
        $(document).ready(function () {
            $("#searchForm").submit(function (event) {
                var id = $("input[name='id']").val();
                var productName = $("input[name='productname']").val();
                var price = $("input[name='price']").val();

                if (id === "" && productName === "" && price === "") {
                    alert("Please enter at least one field to perform a search.");
                    event.preventDefault(); 
                }
            });
        });
        
    </script>
</head>
<body>
    <h2>Product List</h2>
    <form action="search" method="GET" id="searchForm">
        Product ID: <input type="text" name="id" />
        Product Name: <input type="text" name="productname" />
        Price: <input type="text" name="price" />
        <input type="submit" class="searchButton" value="Search" />
        <button type="reset" class="resetButton" onclick="redirectToForm()">Reset</button>
        
    </form>

    <table border="1">
        <thead>
            <tr>
                <th>ProductId</th>
                <th>ProductName</th>
                <th>ProductUsage</th>
                <th>MfgDate</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <c:choose>
            <c:when test="${not empty searchresults}">
                <h3>Search Results:</h3>
                <tbody>
                    <c:forEach items="${searchresults}" var="result">
                        <tr>
                            <td><c:out value="${result.id}" /></td>
                            <td><c:out value="${result.productname}" /></td>
                            <td><c:out value="${result.productusage}" /></td>
                            <td><c:out value="${result.manufacturingDate}" /></td>
                            <td><c:out value="${result.price}" /></td>
                            <td><a href="edit/${result.id}" class="editLink">Edit</a></td>
                            <td><a href="delete?id=${result.id}" class="deleteLink">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </c:when>
            <c:otherwise>
                <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td><c:out value="${product.id}" /></td>
                            <td><c:out value="${product.productname}" /></td>
                            <td><c:out value="${product.productusage}" /></td>
                            <td><c:out value="${product.manufacturingDate}" /></td>
                            <td><c:out value="${product.price}" /></td>
                            <td><a href="edit/${product.id}" class="editLink">Edit</a></td>
                            <td><a href="delete?id=${product.id}" class="deleteLink">Delete</a></td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty searchresults && empty products}">
                        <tr>
                            <td colspan="7" class="colspan-center">No records found.</td>
                        </tr>
                    </c:if>
                    <a href="/ProductOrders/form"><button>Add Product</button></a>
                </tbody>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>

