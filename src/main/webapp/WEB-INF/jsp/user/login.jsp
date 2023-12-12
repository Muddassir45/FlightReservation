<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f4f8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            width: 100%;
        }

        .logo {
            width: 100px;
            height: 100px;
            margin: 0 auto 20px;
            background-image: url('flight.png'); /* Replace 'flight.png' with your actual logo image path */
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            border-radius: 50%;
        }

        h2 {
            color: #007BFF;
            font-size: 28px; /* Adjust font size */
            margin-bottom: 20px;
        }

        form {
            margin-top: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        label {
            display: block;
            text-align: left;
            margin-bottom: 10px;
            color: #333;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 2px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            outline: none;
        }

        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 14px 24px; /* Adjust padding */
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        h1 {
            color: #ff0000;
            font-size: 18px;
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="logo"></div>
        <h2>Login</h2>
        <form action="log" method="post">
            <label for="email">User Name:</label>
            <input type="text" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
            <h1>${msg}</h1>
        </form>
    </div>
</body>

</html>
