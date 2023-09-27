<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
    <hr>
       <h3><a href="/" style="text-align: center; text-decoration: none"> Главная </a></h3>
    <hr>
</head>
<body>
<form action="/staff" method="get">
    <div style="display: inline-flex">Поиск по ФИО:<input type="text" name="fullName"><br>
        <input type="submit" value="Поиск"/></div>
</form>
<br>
<#if staffs?has_content>
<table border="1">
    <tr>
        <th> ID работника</th>
        <th> Ф.И.О.</th>
        <th> Номер телефона </th>
        <th> Подробная информация </th>
    </tr>
    <#list staffs as staff>
    <tr>
        <th>${staff.id_staff}</th>
        <th>${staff.fullName}</th>
        <th>${staff.telNumber}</th>
        <th><a href="/staff/${staff.id_staff}"> Подробнее...</a></th>
    </tr>
    </#list>
</table>
    <#else> Данный работник не найден!
</#if>
<hr>

    <h3>Добавление сотрудника</h3>
    <form action="/staff/create" method="post" enctype="multipart/form-data">
        <div>ФИО:<input type="text" required name="fullName" minlength="5"/><br><br>
            Номер паспорта:<input type="text" minlength="7" maxlength="10" required name="num_of_passport"/><br><br>
            Номер телефона:<input type="text" required minlength="13" maxlength="20" name="telNumber"/><br><br>
            Стаж работы:<input type="number" required max="50" name="experience"/><br><br>
            Должность:  <select name="job_title" required>
                <option>Выберите</option>
                <option value="Продавец-кассир">Продавец-кассир </option>
                <option value="Менеджер">Менеджер </option>

            </select><br><br>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Добавить работника"/>
    </form>
<#if errorMessage??>
    <h3 style="color: darkblue">${errorMessage}</h3>
</#if>

</body>
</html>