<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>Greeting Page</title>
  <style>
      body {
          display: flex;
          justify-content: center;
          height: 75vh;
          margin: 0;
      }
      form {
          text-align: center;
      }
      p {
          text-align: center;
      }
  </style>
</head>
<body>
<div>
  <h1>Welcome to the Greeting Page!</h1>

  <form action="/" method="post">
    <label for="url">Enter your name:</label>
    <input type="text" id="url" name="url" />
    <button type="submit">Submit</button>
  </form>

  <p>${shortUrl}</p>
</div>
</body>
</html>
