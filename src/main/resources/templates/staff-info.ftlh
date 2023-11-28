<!DOCTYPE html>
<html>
<head>

   <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3><div class="ref"><a href="/staff" style="text-align: center; text-decoration: none"> Назад </a></div> </h3>
    <hr>
</head>
<body>

<h2 style="margin-left: 10px">Подробная информация</h2>
<b style="margin-left: 10px">Ф.И.О.: </b>${staff.fullName}<br>
<b style="margin-left: 10px">Номер паспорта: </b>${staff.numOfPassport}<br>
<b style="margin-left: 10px">Номер телефона: </b>${staff.telNumber}<br>
<b style="margin-left: 10px">Стаж работы: </b>${staff.experience}<br>
<b style="margin-left: 10px">Должность: </b>${staff.job_title}<br>
<hr>
<#if user.staff.id_staff!=staff.id_staff>
<form action="/staff/${staff.id_staff}/edit"  method="get" >
    <div class="action"><input type="submit" value="Редактирование"></div>
</form>
    <br>
<form action="/staff/delete/${staff.id_staff}"  method="post" >
    <input type="hidden" name="_csrf" value="${_csrf.token}">
<div class="action"><input type="submit" value="Удалить работника"/></div>
</form>
</#if>

</body>
</html>