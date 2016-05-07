<#include "../main_template.ftl"/>
<@main_template title="Обслуживание"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/personal_cabinet/my-auto">Обслуживание</a></div>
                <li>
                    <div><a href="/personal_cabinet/basket/">Моя корзина</a></div>
                </li>
                <li>
                    <div><a href="/personal_cabinet/orders/">Мои заказы</a></div>
                </li>
                <li>
                    <div><a href="/personal_cabinet/configuration">Мои настройки</a></div>
                </li>
            </ul>
        </div><!--/Левое меню-->
        <!--/Левое меню-->
        <!--Специиальные предложения -->

        <!--Новости -->

        <!--Как добраться-->
        <p></p>
        <h3 class="up_case"><a>Как добраться</a></h3>
        <div class="banner address">
            <div class="head_banner"></div>
            <p>
                299002, г. Севастополь, ул. Живописная 17
            </p>
            <p>
                125047, г. Москва, ул. Пушкина, дом 21.
            </p>

            <div class="foot_banner"></div>
            <div class="compas"></div>
        </div>
        <p></p>
    </div><!--/Левая колонка-->
    <div id="right"><!--Правая колонка-->
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12"
                                          height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li><a href="/personal_cabinet" title="Личный кабинет">Личный кабинет</a></li>

            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Обслуживания</li>
        </ul>
        <div class="both"></div>
        <h1>История обслуживания</h1>

        <div class="select_auto">
            <h2>Ваш автомобиль</h2>
            <b><@security.authentication property="principal.userInfo.automobile"/></b>
        </div>

        <div class="wrap_table">
            <table class="gray_table request">
                <tbody>
                <tr class="even">
                    <th class="number">№</th>
                    <th class="type">Вид ремонта</th>
                    <th class="status">Статус</th>
                    <th class="date">Дата</th>
                    <th class="status">Ответ</th>
                    <th class="sum">≈ цена</th>
                    <th class="sum">Удалить заявку</th>
                </tr>
                    <#if claims?size =0>
                    <tr>
                        <td colspan="5">Ваш автомобиль ещё не обслуживался у нас.</td>
                    </tr>
                    </#if>
                    <#list claims as claim>
                    <tr class="even">
                        <form method="post" action="/personal_cabinet/delete" >
                        <td align="center">${claim?counter}</td>
                        <td width="35%">${claim.getReason()}</td>
                        <td>${claim.getStatus()}</td>
                        <td>${claim.getfDate()}</td>
                        <td width="35%">${claim.getResponse()}</td>
                        <td align="center">${claim.getSum()}</td>
                            <#if claim.getStatus()=="Заявка рассматривается">
                            <td align="center">
                                <input hidden type="text" name="id" value="${claim.getId()}">
                                <input class="button_red_small" type="submit" value="Удалить">
                            </td>
                            </#if>
                        </form>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>

    </div>
</div>
</#macro>