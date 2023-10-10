<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculation Result</title>
</head>
<body>
<div>
    <h3>Calculation Result</h3>
    <h3>The sum of the entered numbers is: ${result}</h3>
    <form action="resultServlet" method="post">
        Enter number 3: <input type="text" name="num3"><br>
        Enter number 4: <input type="text" name="num4"><br>
        <input type="submit" value="Calculate">
    </form>

</div>
</body>
</html>
