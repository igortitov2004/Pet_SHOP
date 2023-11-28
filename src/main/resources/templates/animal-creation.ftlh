<!DOCTYPE html>
<html>
<#import "spring.ftl" as spring />
<head>
    <title>SHOP</title>
    <#--    <link rel="stylesheet" type="text/css" href="/style/inputRow.css">-->
    <link rel="stylesheet" type="text/css" href="/style/actionHref.css">
    <link rel="stylesheet" type="text/css" href="/style/actionButton.css">
    <hr>
    <h3><div class="ref"><a href="/animals" style="text-decoration: none">Назад</a></div></h3>
    <hr>
</head>
<body>
<h3 style="margin-left: 10px">Добавление животного</h3>
<hr>
<form action="/animals/create" method="post" enctype="multipart/form-data">
    <table style="margin-left: 10px">
        <tr style="height: 20px">
            <td><label for="a">Название:</label></td>
            <td><input type="text" style="width: 140px" value="${newAnimal.kindOfAnimal}" required name="kindOfAnimal" minlength="3"
                       maxlength="30"
                       id="a"/></td>
            <#if animalErr??>
                <td>
                    <div style="color: red">
                        <@spring.bind "newAnimal.kindOfAnimal"/>
                        <@spring.showErrors "<br>"/>
                    </div>
                </td>
            </#if>
        </tr>
        <tr>
            <td><label for="b">Порода:</label></td>
            <td><select name="breed"  style="width: 147px" required id="b">
                    <#--        <option disabled SELECTED><option>-->
                    <#list breeds as breed>
                        <option value="${breed.id_breeds}"> ${breed.breed}</option>
                    </#list>
                </select></td>
        </tr>
        <tr>
            <td><label for="c">Вес:</label></td>
            <td><input type="number" style="width: 140px" step="0.01" id="c" value="${newAnimal.weight_of_animal}" required
                       name="weight_of_animal"
                       min="0.01" max="50"
                       onkeyup="if(this.value.toString().lastIndexOf('e')===this.value.toString().length-1){
                             this.value=''}"/>
            </td>
        </tr>
        <tr>
            <td><label for="d">Возраст:</label></td>
            <td><input type="number" style="width: 140px" value="${newAnimal.ageOfAnimal}" id="d" required name="ageOfAnimal" min="0"
                       max="30"
                       step="1"
                       onkeyup="if(this.value.toString().lastIndexOf('e')===this.value.toString().length-1){
                             this.value=''}"/>
            </td>
        </tr>
    </table><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div class="action"><input type="submit" value="Добавить животное"/></div>
</form>

<#--<#if errorMessage??>-->
<#--    <h3 style="color: darkblue">${errorMessage}</h3>-->
<#--</#if>-->
</body>
</html>