<html lang="en">
<#include "base.ftl">

<#macro title>Weather</#macro>
<#macro header>WEATHER</#macro>

<#macro content>
    Temperature: ${temperature}°C
    <br>
    Description: ${description}
    <br>
    Humidity: ${humidity}%
</#macro>

</html>