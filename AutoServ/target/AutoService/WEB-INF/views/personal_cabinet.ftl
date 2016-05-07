<#include "main_template.ftl"/>
<@main_template title="Личный кабинет"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/personal_cabinet/my-auto">Обслуживание</a></div>
                <li>
                    <div><a href="/personal_cabinet/basket">Моя корзина</a></div>
                </li>
                <li>
                    <div><a href="/personal_cabinet/orders">Мои заказы</a></div>
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
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12" height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>Личный кабинет</li>
        </ul>
        <div class="both"></div>
        <h1>Личный кабинет</h1><a href="/personal_cabinet/my-auto"><strong>Обслуживание</strong></a><br>
        Отслеживание состояний ваших заявок, оформление новых заявок.



        <p>
            <a href="/personal_cabinet/basket"><strong>Моя корзина</strong></a><br>
            Добавленные в корзину товары из нашего интернет-магазина.</p>
        <p>
            <a href="/personal_cabinet/orders"><strong>Мои заказы</strong></a><br>
            Просмотр и оформление заказов интернет-магазина.</p>
        <p>
            <a href="/personal_cabinet/configuration"><strong>Мои настройки</strong></a><br>
            Настройки вашего профиля.</p>

    </div>
</div>
</#macro>