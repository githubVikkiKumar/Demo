<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp Page</title>
<style>
    body {
        font-family: sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    form {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
    }

    form input[type="text"],
    form input[type="password"],
    form select {
        width: 100%;
        padding: 10px;
        margin: 5px 0 15px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    form input[type="radio"] {
        margin-right: 5px;
    }

    form label {
        margin-bottom: 10px;
        display: block;
        color: #333;
    }

    form .gender-label {
        display: inline-block;
        margin-right: 10px;
    }

    form input[type="submit"] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    form input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <form action="regForm" method="post">
        <h2>SIGN UP PAGE</h2>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name"/>

        <label for="email">Email:</label>
        <input type="text" id="email" name="email"/>

        <label for="pass">Password:</label>
        <input type="password" id="pass" name="pass"/>

        <label>Gender:</label>
        <span class="gender-label">Male<input type="radio" id="male" name="gender" value="Male" /></span>
        <span class="gender-label">Female<input type="radio" id="female" name="gender" value="Female" /></span>

        <label for="city1">Select State:</label>
        <select id="city1" name="city1">
            <option value="cityName">City Name</option>
            <option value="hariyana">Hariyana</option>
            <option value="delhi">Delhi</option>
            <option value="patna">Patna</option>
            <option value="rajkot">Rajkot</option>
            <option value="nasik">Nasik</option>
            <option value="sikandrabad">Sikandrabad</option>
            <option value="karnatka">Karnatka</option>
            <option value="mumbai">Mumbai</option>
            <option value="simla">Simla</option>
        </select>

        <input type="submit" value="Register"/>
    </form>
</body>
</html>
