<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form action="arithmetic" method="post">
            <div>
                <label for="first">First:</label>
                <input type="text" name="first" id="first" value="${firstInput}">
            </div>
            <div>
                <label for="second">Second:</label>
                <input type="text" name="second" id="second" value="${secondInput}">
            </div>

            <div>
                <button type="submit" id="addition" name="addition">+</button>                                        
                <button type="submit" id="subtraction" name="subtraction">-</button>
                <button type="submit" id="multiplication" name="multiplication">*</button>
                <button type="submit" id="division" name="division">%</button>
            </div>
        </form>
       
        <br>
        <div>
            Result: ${message}
        </div>
    
        <div>
            <a href="/Calculators/age">Age Calculator</a>
        </div>

    </body>
</html>
