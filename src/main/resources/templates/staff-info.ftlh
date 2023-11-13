<!DOCTYPE html>
<html>
<head>

   <title>SHOP</title>
    <hr>
    <h3><a href="/staff" style="text-align: center; text-decoration: none"> Назад </a></h3>
    <hr>
</head>
<body>

<h2>Подробная информация</h2>
<b>Ф.И.О.:</b>${staff.fullName}<br>
<b>Номер паспорта:</b>${staff.numOfPassport}<br>
<b>Номер телефона:</b>${staff.telNumber}<br>
<b>Стаж работы:</b>${staff.experience}<br>
<b>Должность:</b>${staff.job_title}<br>
<hr>
<#if user.staff.id_staff!=staff.id_staff>
<form action="/staff/${staff.id_staff}/edit"  method="get" >
    <input type="submit" value="Редактирование">
</form>
    <br>
<form action="/staff/delete/${staff.id_staff}"  method="post" >
    <input type="hidden" name="_csrf" value="${_csrf.token}">
<input type="submit" value="Удалить работника"/>
</form>
</#if>

</body>
</html>