<#include "../main_template.ftl"/>
<@main_template title="Добавление"/>
<#macro m_body>
<div class="narrow">


    <div id="right">
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Добавить бренд</li>
        </ul>
        <div class="both"></div>
        <h1>Добавить бренд</h1>
        <#if RequestParameters.error??>
            <p><span class="errortext">Уже существует.<br></span></p>
        </#if>
        <#if RequestParameters.success??>
            <p style="color: green"><span>Добавлено<br></span></p>
        </#if>
        <div id="pop-form" class="static">
            <div class="container_form">
                <div style="margin-top: 16px;">

                    <form name="form_auth" method="post" target="_top" action="/services/addBrand">


                        <div class="form-group">
                            <span class="input-text">Бренд&nbsp&nbsp&nbsp&nbsp&nbsp</span>
                            <input class="text" autocomplete="on" type="text" maxlength="255" value="" name="brand">
                        </div>

                        <br><br>
                        <p></p>
                        <input align="center" type="submit" name="Login" value="Добавить" class="button_red_big"
                               style="left: 110px; top: -31px">

                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</#macro>