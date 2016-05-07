<#include "main_template.ftl"/>
<@main_template title="Контакты"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <li>
                    <div><a href="/contacts">Контакты</a></div>
                </li>

            </ul>
        </div><!--/Левое меню-->
        <!--/Левое меню-->

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
            <li>Контакты</li>
        </ul>
        <div class="both"></div>
        <h1>Контакты</h1>
        <script type="text/javascript" charset="utf-8" async src="https://api-maps.yandex.ru/services/constructor/1.0/js/?sid=22yWC4v0AT8AhFp5IQ2hnrMOcljhEBCc&width=730&height=260&lang=ru_RU&sourceType=constructor&scroll=true"></script>


        <p></p>
        <div class="news-list">
            <hr>
            <p class="news-item" id="bx_3099439860_12898">


                299002, г. Севастополь, ул. Живописная 17<br>

                sevastopol@autoservice.ru<br>

                +7 (978) 000-00-00 <br>

            </p>
            <hr>
            <p class="news-item" id="bx_3099439860_12899">

                125047, г. Москва, ул. Пушкина, дом 21 <br>
                moscow@autoservice.ru<br>
                8(800)555-35-35<br>
            </p>
            <hr>

        </div>

    </div>
</div>
</#macro>