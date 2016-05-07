<#include "../main_template.ftl"/>
<@main_template title="${model.getName()}"/>
<#macro m_body>
<div class="narrow">
    <div id="left"><!--Левая колонка-->
        <!--Левое меню-->
        <div id="left-menu"><!--Левое меню-->
            <ul class="left-menu-list">
                <#list brands as brand>
                    <li>
                        <div><a>${brand.getName()}</a></div>
                        <ul class="left-menu-sub">
                            <#list brand.getAutoModels() as model>
                                <li>
                                    <div><a href="/shop/${brand.getName()}/${model.getId()}">${model.getName()}</a>
                                    </div>
                                </li>

                            </#list>
                        </ul>
                    </li>
                </#list>
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
            <li><a href="/" title=""><img src="/resources/images/home.png" width="12"
                                          height="12"></a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li><a href="/shop">Запчасти</a></li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>${model.getBrand().getName()}</li>
            <li><span>&nbsp;/&nbsp;</span></li>
            <li>${model.getName()}</li>
        </ul>
        <div class="both"></div>
        <h1>${model.getBrand().getName()} ${model.getName()}</h1>
        <div class="selling_block">
            <@security.authorize access="!hasRole('ROLE_ADMIN')">
                <span class="basket">
		<a href="/personal_cabinet/basket">Корзина</a><br>

	</span>
            </@security.authorize>
        </div>
        <div class="catalog_block" id="550">
            <table class="deals">
                <thead>

                </thead>
                <tbody>
                    <#list model.getProducts() as product>
                    <tr>
                        <td class="foto">
                            <a>
                                <img src="/resources/images/no-auto.png">
                            </a>
                        </td>

                        <td class="description">
                            <p class="name"><a>${product.getName()}</a></p>
                            <p class="annotation">${product.getDescription()}</p>
                        </td>
                        <td class="detail">
                            <p class="price"><b>${product.getPrice()} руб</b></p>
                            <form action="/shop/add" method="post">
                                <div class="operation">

                                    <@security.authorize access="hasRole('ROLE_USER')">
                                        <input hidden name="id" type="text" value="${product.getId()}"/>
                                        <input hidden type="text" value="${springMacroRequestContext.getRequestUri()}"
                                               name="url"/>
                                        <input type="SUBMIT" class="button_red_smaller link_detail"
                                               rel="nofollow" value="В корзину"/>
                                    </@security.authorize>
                                </div>
                            </form>
                        </td>
                    </tr>
                    </#list>
                </tbody>
            </table>
            <p></p>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("table").tablesorter();
        $("#ajax-append").click(function () {
            $.get("assets/ajax-content.html", function (html) {
                // append the "ajax'd" data to the table body
                $("table tbody").append(html);
                // let the plugin know that we made a update
                $("table").trigger("update");
                // set sorting column and direction, this will sort on the first and third column
                var sorting = [[2, 1], [0, 0]];
                // sort on the first column
                $("table").trigger("sorton", [sorting]);
            });
            return false;
        });
    });
</script>
<script src="/resources/js/jquery-2.2.3.js"></script>

<script type="text/javascript" src="/resources/js/jquery.tablesorter.min.js"></script>
</#macro>