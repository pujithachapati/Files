<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Product Form</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.js"></script>
    <style type="text/css">
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    h2 {
        color: #fff;
    }
    #orderDetails,#productDetails{
    	margin: 15px 0px 0px 15px;
    	font-weight:bold;
    	font-size:20px;
    }
    

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    td {
        padding: 12px;
        border-bottom: 1px solid #ddd;
    }

    form input[type="text"],
    form input[type="date"] {
        width: calc(100% - 16px);
        box-sizing: border-box;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

    .button {
        background-color:darkslategrey;
        border-radius: 8px;
        border: none;
        font-weight: bold;
        color: #fff;
        padding: 12px 20px;
        cursor: pointer;
    }

    #remove {
        margin-left: 5px;
        background-color: darkslategrey;;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 6px;
        cursor: pointer;
    }

    #addTblRow {
        float: right;
        margin-top: 20px;
        background-color:darkslategrey;;
        color: #fff;
        border: none;
        padding: 10px 20px;
        border-radius: 6px;
        cursor: pointer;
    }
    #formContainer{
    	background-color: darkseagreen;
    }

</style>

<script>
$(document).ready(function () {
	 	$(document).on('click', '.remove-record', function() {
	    	if ($(this).closest('tr').index() !== 0){
	    		$(this).closest('tr').find('input, select').val('');
	        	$(this).closest('tr').remove();
	        }
	    	else{
	    		alert("cannot delete the first row");
	    	}    
	        
	    });
	 	var numberOfOrders = ${product.orders.size()==0?0:product.orders.size()};



	 	$("#addTblRow").click(function(){
	 	   let i = $('#Tbody').find('tr').length;
	 	   numberOfOrders = i;
	 	   var v = $('#addRow').clone();
	 	   $('#Tbody').find('tr:last').after(v);

	 	   $(v).find('input,select').each(function() {
	 	       $(this).val('').attr('name', $(this).attr('name').replace(/\[\d+\]/, '[' + i + ']'));
	 	   });
	 	}) 
	
    	var alreadyExists = false;
    	var existingProductName = $("#productnameid").val();
    	function handleProductNameInput() {
    		
    		
        	var productName = $(this).val();
        	
			if(productName.trim()!== existingProductName.trim()){
					alreadyExists = false;
			}
			
        	if (productName.trim() !== "" && !alreadyExists) {
            	checkProductExists(productName);
        	}
    	}

    	function checkProductExists(productName) {
    	    $.ajax({
    	        type: "GET",
    	        url: "/ProductOrders/checkProductname",
    	        data: { productname: productName },
    	        success: function (result) {
    	            if (result==="true" && !alreadyExists) {
    	                alreadyExists = true;
    	                alert("Product already exists!");
    	            } else {
    	                alreadyExists = false;
    	            }
    	        },
    	        error: function (error) {
    	            alert("Error checking product name.");
    	        }
    	    });
    	}
		$("#productnameid").on("blur", handleProductNameInput);
		
        var validationRules = {
            productname: {
                required: true,
            },
            productusage: {
                required: true
            },
            manufacturingDate: {
                required: true
            },
            price: {
                required: true,
                number: true,
                min: 0
            }
        };

        var validationMessages = {
            productname: {
                required: "Please enter product name"
            },
            productusage: {
                required: "Please enter product usage"
            },
            manufacturingDate: {
                required: "Please enter manufacturing date"
            },
            price: {
                required: "Please enter the price",
                number: "Please enter a valid number",
                min: "Please enter a non-negative value"
            }
        };
        
        //$.fn.validate = function(){
	        for (var i = 0; i < numberOfOrders; i++) {
	        	validationRules["orders[" + i + "].customername"] = { required: true };
	            validationRules["orders[" + i + "].quantity"] = {
	                required: true,
	                number: true,
	                min: 0
	            };
	            validationRules["orders[" + i + "].address"] = { required: true };
	            
	            validationMessages["orders[" + i + "].customername"] = { required: "Please enter the customer name" };
	            validationMessages["orders[" + i + "].quantity"] = {
	                required: "Please enter the quantity",
	                number: "Please enter a valid number",
	                min: "Please enter a non-negative value"
	            };
	            validationMessages["orders[" + i + "].address"] = { required: "Please enter the customer address" };
	        }
       // }

        $('#form').validate({
        	 rules: validationRules,
             messages: validationMessages
        });
          /* $("#submitBtn").click(function(){
        	 var cn = 
        	$('#form').validate(function(){
        		if (!$(this).valid())
        			return false;
        		else 
        			return true;
        	});  */
        	/* $('#form').validateForm({
                rules: validationRules,
                messages: validationMessages
            }); 
        }); */
        
    });
</script>
</head>

<body>
    <div id="formContainer">
        <form:form modelAttribute="product" method="post" action="${product.id==null ? 'save' : 'update'}" id="form">
            <div id="productDetails">Product Details</div>
            <table>
                <tbody>
                    <tr>
                    	
                        <td><input type="hidden"  name="id" value="${product.id}" /> </td>
                        <td>ProductName*:<form:input path="productname" id="productnameid" name="productname" /></td>
                        <td>ProductUsage*:<form:input path="productusage"/></td>
                        <td>Manufacturing Date*:<form:input path="manufacturingDate" type="date"/></td>
                        <td>Price*:<form:input path="price" id="price" /></td>
                    </tr>
                </tbody>
            </table>

            <div id="orderDetails">Order Details</div>
            <div id="orderContainer">
                <table id="orderTable">
                    <thead>
                        <tr>
                        	<th></th>
                            <th>CustomerName*</th>
                            <th>Quantity*</th>
                            <th>Address*</th>
                            <th><button type="button" id="addTblRow">Add Row</button></th>
                        </tr>
                    </thead>
                    <tbody id="Tbody">
                        <c:forEach begin="0" end="${product.orders.size()==0?0:product.orders.size()-1}" var="i">
                            <tr id="addRow" class="validate">
                                <td><form:input path="orders[${i}].id" type="hidden"/></td>
                                <td><form:input path="orders[${i}].customername" required="true"/></td>
                                <td><form:input path="orders[${i}].quantity" required="true"/></td>
                                <td><form:input path="orders[${i}].address" required="true"/></td>
                                <td><button type="button" class="remove-record" id="remove">Delete</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <input type="submit" value="Submit" class="button" id="submitBtn" />
            </div>
            
        </form:form>
    </div>



</body>

</html>
