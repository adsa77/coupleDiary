<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script defer src="/js/calendar.js"></script>

    <link rel="stylesheet" href="/css/calendar.css">
    <title>calendar</title>
</head>
<body>
    <section>
        <div id="header">
            <div>
                <h1>left</h1>
            </div>
            <div id="moveLastMonth">
                <h1>⬅️</h1>
            </div>
            <div id="todayDate">
                <div id="thisYear"></div>
                <div id="thisMonth"></div>
                <div id="thisDay"></div>
            </div>
            <div id="moveNextMonth">
                <h1>➡️</h1>
            </div>
            <div>
                <h1>right</h1>
            </div>
        </div>
        <div id="calendar"></div>
    </section>
</body>
</html>