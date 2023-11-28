<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3>
        <div class="ref"><a href="/accessories" style="text-decoration: none">Назад</a></div>
    </h3>
    <hr>
</head>
<body>
<h3 style="margin-left: 10px">Добавление аксессуара</h3>
<hr>
<form action="/accessories/create" method="post" enctype="multipart/form-data">
    <table style="margin-left: 10px">
        <tr style="height: 20px">
            <td><label for="a">Название:</label></td>
            <td><input type="text" style="width: 180px" required name="nameOfAccessor" id="a"/></td>
            <#if accessorErr??>
                <td>
                    <div style="color: red">
                        <@spring.bind "newAccessor.nameOfAccessor"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>

            </#if>
        </tr>
        <tr>
            <td><label for="b"> Животное:</label></td>
            <td>
                <select name="animal" required id="b" style="width: 187px">
                    <#list animals as animal>
                        <option value="">Выберите</option>
                        <option value="${animal.id_animals}"> ${animal.kindOfAnimal}: ${animal.breed.breed}</option>
                    </#list>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="c">Стоимость:</label></td>
            <td><input style="width: 180px" id="c" type="number" step="0.01" min="0.01" max="300" required
                       name="priceOfAccessor"/>
            </td>
        </tr>
        <tr>
            <td><label for="d">Производитель:</label></td>
            <td><input style="width: 180px" id="d" type="text" required name="manufacturerOfAccessor"/>
            </td>
            <#if accessorErr??>
                <td>
                    <div style="color: red">
                        <@spring.bind "newAccessor.manufacturerOfAccessor"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>

            </#if>
        </tr>
    </table>
    <br>
    <input type="hidden" value="0" name="amount_of_accessories"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Добавить аксессуар"/></div>
</form>
</body>
</html>