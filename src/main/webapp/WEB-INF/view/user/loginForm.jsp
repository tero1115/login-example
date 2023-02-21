<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>

        <body>
            <ul>
                <li><a href="/loginForm">로그인 페이지</a></li>
                <li><a href="/joinForm">회원가입 페이지</a></li>
                <li><a href="/">메인 페이지</a></li>
            </ul>
            <div class="container-box">
                <div class="inner-box">
                    <h1>로그인 페이지</h1>
                    <hr>
                    <form action="/login" method="post">
                        <input type="text" name="username" class="form-control" placeholder="Enter username"
                            id="username"><br>
                        <input type="password" name="password" class="form-control" placeholder="Enter password"
                            id="password"><br>
                        <button type="submit">로그인</button>
                    </form>
                </div>
            </div>

        </body>

        </html>