<#include "../main_template.ftl"/>
<@main_template title="Заявки"/>
<#macro m_body>
<div class="narrow">
    <h1 align="center">Рассмотрение заявок на ТО/ремонт</h1>
    <div id="right" style=" margin-left:auto;
    margin-right:auto;
    width:1000px; "><!--Правая колонка-->

        <div style="text-align: center" class="both"></div>


        <div class="wrap_table">
            <table class="gray_table request">
                <tbody>
                <tr class="even">
                    <th class="number">№</th>
                    <th class="type">От</th>
                    <th class="status">Статус</th>
                    <th  class="sum">Сумма</th>
                    <th class="date">Одобрить</th>

                </tr>
                    <#list orders as order>
                    <tr class="even">
                        <form action="/admin/orders" method="post">
                            <td align="right"><a href="/admin/orders/${order.getId()}">${order.getId()}</a></td>
                            <td>${order.getUsers().getName()} ${order.getUsers().getLastname()}
                                (${order.getUsers().getEmail()})
                            </td>
                            <td>${order.getStatus()}</td>

                            <td align="right">${order.getSum()}</td>

                            <#if order.getStatus()=="Заявка рассматривается">
                                <input hidden name="id" type="text" value="${order.getId()}">
                                <td><input class="button_red_small" type="submit" value="OK"></td>
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