<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <div class="ref"><a href="/staff">Назад</a></div>
    <hr>
</head>
<body>
<h3 style="margin-left: 10px">Добавление работника</h3>
<hr>
<form action="/staff/create" method="post" enctype="multipart/form-data">
    <table style="margin-left: 10px">
        <tr style="height: 20px">
            <td><label for="a">ФИО:</label></td>
            <td><input  type="text" id="a" style="width: 180px" value="${staff.fullName}"
                       required name="fullName"/></td>
            <#if err??>
                <td>
                    <div style="color: red">
                        <@spring.bind "staff.fullName"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>
            </#if>
        </tr>
        <tr>
            <td><label for="b">Номер паспорта:</label></td>
            <td><input type="text" style="width: 180px" id="b" value="${staff.numOfPassport}" required
                       name="numOfPassport" minlength="9" maxlength="9"/></td>
            <#if err??>
                <td>
                    <div style="color: red">
                        <@spring.bind "staff.numOfPassport"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>

            </#if>
        </tr>
        <tr>
            <td><label for="c">Номер телефона:</label></td>
            <td><input type="text" style="width: 180px" id="c" value="${staff.telNumber}" required
                       name="telNumber" minlength="13" maxlength="13"/></td>
            <#if err??>
                <td>
                    <div style="color: red">
                        <@spring.bind "staff.telNumber"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>
            </#if>
        </tr>
        <tr>
            <td><label for="d">Стаж работы:</label></td>
            <td><input type="number" style="width: 180px" value="${staff.experience}" required
                       name="experience" min="0" max="50"  id="d"/></td>
        </tr>
        <tr>
            <td><label for="e">Должность:</label></td>
            <td><select name="job_title" style="width: 187px" required id="e">
                    <option value="">Выберите</option>
                    <option value="Менеджер"> Менеджер</option>
                    <option value="Продавец-кассир"> Продавец-кассир</option>
                </select></td>
        </tr>
    </table>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Применить"/></div>
</form>
</body>
</html>