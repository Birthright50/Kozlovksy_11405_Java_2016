<#include "main_template.ftl"/>
<@main_template title="Админ панель"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/admin/claims">Заявки на ТО, ремонт</a></div>
                <li>
                    <div><a href="/admin/orders">Заказы запчастей</a></div>
                </li>

            </ul>
        </div><!--/Левое меню-->
        <!--/Левое меню-->
        <!--Специиальные предложения -->

        <!--Новости -->

        <!--Как добраться-->

    </div><!--/Левая колонка-->
    <div id="right"><!--Правая колонка-->
        <ul class="breadcrumb-navigation">
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Админ панель</li>
        </ul>
        <div class="both"></div>
        <h1>Админ панель</h1>
        <a href="/admin/claims"><strong>Прием заявок ТО, ремонт</strong></a><br>
        Отклонение или принятие заявок пользователей на ремонт или ТО.


        <p>
            <a href="/admin/orders"><strong>Заказы запчастей</strong></a><br>
            Принятие заказов запчастей</p>


    </div>
</div>
</#macro>