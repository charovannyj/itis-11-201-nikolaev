<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration page</title>
</head>
<body>

<form action="start" method="post">
    Name:
    <input type="text" name="name"/>
    <br>
    <br>
    Date and time:
    <input type="date" name="date"/>
    <br>
    <br>
    Phone number:
    <input type="text" maxlength=11 onkeypress="var key = (typeof event.charCode == 'undefined' ? event.keyCode : event.charCode); if (key >= 48 && key <= 57 && ((doGetCaretPosition(this) == 0 && key == 57) || doGetCaretPosition(this) != 0)) return true; else return false;" name="phone"/>
    <br>
    <br>
    <label for="choose-master">Выберите Мастера:</label>
    <select name="master" id="choose-master">
        <#list listMaster as master>
            <option value="${master.id}">${master.name}</option>
        </#list>
    </select>
    <br>
    <br>
    <label for="choose-service">Выберите услугу:</label>
    <select name="service" id="choose-service">
        <#list listService as service>
            <option value="${service.id}">${service.name}</option>
        </#list>
    </select>
    <br>
    <br>
    <input type="submit" value="Enter">

    <#--Service:
    <input type="text" name="service"/>
    <br>
    <br>-->
</form>

</body>
</html>


