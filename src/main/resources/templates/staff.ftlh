<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <link rel="stylesheet" type="text/css" href="/style/moreInfoButton.css">
    <link rel="stylesheet" type="text/css" href="/style/searchButton.css">
    <link rel="stylesheet" type="text/css" href="/style/table.css">
    <hr>
       <h3><div class="ref"><a href="/" style="text-align: center; text-decoration: none"> Главная </a></div> </h3>
    <hr>
</head>
<body>
<form action="/staff" method="get">
    <input style="margin-left: 10px" type="text" name="fullName" placeholder="Поиск по ФИО"><br><br>
       <div class="search"><input type="submit" value="Поиск"/></div>
</form>
<hr>
<#if staffs?has_content>
    <section style="margin-left: 10px; width: 700px" >
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
                <tr>
                    <th style="width: 100px"> ID работника</th>
                    <th> Ф.И.О.</th>
                    <th> Номер телефона </th>
                </tr>
                </tr>
                </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                <#list staffs as staff>
                    <tr>
                        <td style="text-align: center; width: 100px">${staff.id_staff}</td>
                        <td><div class="more"><a href="/staff/${staff.id_staff}">${staff.fullName}</a></div> </td>
                        <td style="text-align: center">${staff.telNumber}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </section>
<#else> <h4 style="color:red; margin-left: 10px">Данный работник не найден!</h4><br>
</#if>
<br>
<form action="/staff/create" method="get">
   <div class="action"><input type="submit" value="Добавить работника"></div>
</form>
</body>
</html>