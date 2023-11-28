<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3>
        <div class="ref"><a href="/feeds" style="text-decoration: none">Назад</a></div>
    </h3>
    <hr>
</head>
<body>
<h3 style="margin-left: 10px;">Добавление корма</h3>
<hr>
<form action="/feeds/create" method="post" enctype="multipart/form-data">
    <table style="margin-left: 10px">
        <tr style="height: 20px">
            <td><label for="a">Название:</label></td>
            <td><input style="width: 180px" type="text" value="${newFeed.nameOfFeed}" required name="nameOfFeed"
                       id="a"/></td>
            <#if feedErr??>
                <td>
                    <div style="color: red">
                        <@spring.bind "newFeed.nameOfFeed"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>
            </#if>

        </tr>
        <tr>
            <td><label for="b">Животное:</label></td>
            <td><select style="width: 187px" name="animal" required id="b">
                            <option value="">Выберите</option>
                    <#list animals as animal>
                        <option value="${animal.id_animals}"> ${animal.kindOfAnimal}: ${animal.breed.breed}</option>
                    </#list>
                </select></td>
        </tr>
        <tr>
            <td><label for="c">Стоимость:</label></td>
            <td><input type="number"  style="width: 180px" step="0.01" value="${newFeed.priceOfFeed}" min="0.01" max="1000" required name="priceOfFeed" id="c"/></td>
        </tr>
        <tr>
            <td><label for="d">Вес:</label></td>
            <td><input type="number" style="width: 180px"  step="0.01" min="0.01" value="${newFeed.weightOfFeed}" maxlength="50" required name="weightOfFeed" id="d"/>
            </td>
        </tr>
        <tr>
            <td><label for="e">Производитель:</label></td>
            <td><input type="text"  style="width: 180px" required name="manufacturerOfFeed" value="${newFeed.manufacturerOfFeed}" minlength="3" maxlength="50" id="e"/>
            </td>
            <#if feedErr??>
                <td>
                    <div style="color: red">
                        <@spring.bind "newFeed.manufacturerOfFeed"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>
            </#if>
        </tr>
    </table>
    <br>
    <input type="hidden" value="0" name="amountOfFeeds"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Добавить корм"/></div>
</form>
</body>
</html>