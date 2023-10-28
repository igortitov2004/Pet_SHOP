<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
</head>
<body>
<form action="/staff/${staff.id_staff}" method="get">
    <input type="submit" value="Назад"/>
</form>
<h3>Изменение данных работника</h3>
<hr>
<form action="/staff/${staff.id_staff}/edit" method="post" enctype="multipart/form-data">
    ФИО:<input type="text"  value="${staff.fullName}" required name="fullName"/><br><br>
    <#if err??>
        <div style="color: red">
            <@spring.bind "staff.fullName"/>
            <@spring.showErrors "<br>"/>
        </div>
    </#if>
    Номер паспорта:<input type="text"  value="${staff.num_of_passport}" required name="num_of_passport"/><br>
    <#if err??>
        <br><div style="color: red">
        <@spring.bind "staff.num_of_passport"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if>
    Номер телефона:<input type="text" value="${staff.telNumber}" required name="telNumber"/><br>
    <#if err??>
        <br><div style="color: red">
        <@spring.bind "staff.telNumber"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if>
    Стаж работы:<input type="number" value="${staff.experience}" required name="experience" /><br>
    <#if err??>
        <br><div style="color: red">
        <@spring.bind "staff.experience"/>
        <@spring.showErrors "<br>"/>
    </div>
    </#if>
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