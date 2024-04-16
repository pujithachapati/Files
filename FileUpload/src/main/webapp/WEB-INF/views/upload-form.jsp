<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Upload Form</title>
</head>
<body>
    <form action="/FileUpload/upload-success" method="post" enctype="multipart/form-data">
        <label for="file">Choose a file:</label>
        <input type="file" name="file" id="file" required>
        <br>
        <button type="submit">Upload</button>
    </form>
</body>
</html>