<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <hr>
    <h3><a href="/staff/${staff.id_staff}" style="text-align: center; text-decoration: none"> Назад </a></h3>
    <hr>
</head>
<body>

<h3>Изменение данных работника</h3>
<hr>
<form action="/staff/${staff.id_staff}/edit" method="post" enctype="multipart/form-data">
    ФИО:<input type="text"  value="${staff.fullName}" required name="fullName"/><br>
    <#if err??>
        <div style="color: red">
            <@spring.bind "staff.fullName"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    <br>
    Номер паспорта:<input type="text"  value="${staff.numOfPassport}" required name="numOfPassport"/><br>
    <#if err??>
        <div style="color: red">
        <@spring.bind "staff.numOfPassport"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if>
    <br>
    Номер телефона:<input type="text" value="${staff.telNumber}" required name="telNumber"/><br>
    <#if err??>
        <div style="color: red">
        <@spring.bind "staff.telNumber"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if>
    <br>
    Стаж работы:<input type="number" value="${staff.experience}" required name="experience" min="0" max="50"/><br><br>
    Должность:
        <select name="job_title" required >
            <option value="${staff.job_title}" >${staff.job_title}</option>
                <option value="Менеджер"> Менеджер</option>
                <option value="Продавец-кассир"> Продавец-кассир</option>
        </select><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Применить"/>
</form>
</body>
</html>