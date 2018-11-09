<#include "/macro/base.ftl" />
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/cardInfo/list" method="post">
		<@pageHeadr />
		<div class="bjui-searchBar">
			<label>卡类型：</label>
			<input type="text" name="cardType" value="" class="form-control" size="10">&nbsp;
			<label>订单号：</label>
			<input type="text" name="orderNo" value="" class="form-control" size="20">&nbsp;
			<label>省份标识：</label>
			<input type="text" name="authSign" value="" class="form-control" size="15">&nbsp;
            <label>状态：</label>
            <select name="status" data-toggle="selectpicker" >
                <option value="0">全部</option>
                <option value="1">未激活</option>
                <option value="2">激活</option>
            </select>
			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			<br/>
            <br/>
            <#--<a href="${base}/admin/cardInfo/add" class="btn btn-default" data-toggle="dialog" data-icon="plus" data-id="cardInfo-add" data-options="{title:'添加', height:200}">添加 </a>-->
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-top" data-toggle="tablefixed" data-selected-multi="true">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th>创建时间</th>
				<th>修改时间</th>
                <th>卡面额</th>
				<th>卡密</th>
				<th>卡类型</th>
				<th>订单号</th>
				<th>订单支付号</th>
				<th>身份标识</th>
				<th title="1 创建 2激活">状态</th>
				<th title="单位：天">激活有效期</th>
				<th>是否过期</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<#if page??>
			<#list page.list as bean>
			<tr>
				<td align="center">${bean_index+1}</td>
				<td>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
				<td>${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}</td>
				<td>${bean.cardFacePrice!}</td>
				<td>${bean.uuid!}</td>
				<td>${bean.cardType!}</td>
				<#--<td>-->
                    <#--<a href="${base}/admin/orderCard/view?id=${bean.orderCardId}" class="btn btn-blue" data-toggle="dialog" data-id="orderCard-view" data-options="{title:'查看', height:430}">-->
						<#--${bean.orderCardId!}-->
					<#--</a>-->
				<#--</td>-->
				<#--<td>-->
                    <#--<a href="${base}/admin/orderCardPay/view?id=${bean.orderCardPayId}" class="btn btn-blue" data-toggle="dialog" data-id="orderCardPay-view" data-options="{title:'查看', height:250}">-->
						<#--${bean.orderCardPayId!}-->
					<#--</a>-->
				<#--</td>-->
                <td>${bean.orderNo!}</td>
				<td>${bean.serialNo!}</td>
				<td>${bean.authSign!}</td>
				<td>
					<#if bean.status=1>没有激活
					<#else>已激活
					</#if>
				</td>
				<td>${bean.days!}</td>
				<td>${(bean.expire?string('已过期','没有过期'))!}</td>
				<td>${bean.remark!}</td>
				<td>
					<a href="${base}/admin/cardInfo/view?id=${bean.id}" class="btn btn-blue" data-toggle="dialog" data-id="cardInfo-view" data-options="{title:'查看', height:350}">查看 </a>
					<#--<a href="${base}/admin/cardInfo/edit?id=${bean.id}" class="btn btn-green" data-toggle="dialog" data-id="cardInfo-edit" data-options="{title:'修改', height:500}">修改 </a>-->
					<#--<#if bean.status=1>-->
					    <#--<a href="${base}/admin/cardInfo/active?id=${bean.id}" class="btn btn-red" data-toggle="doajax" data-id="cardInfo-active" data-confirm-msg="确定要激活吗？">激活</a>-->
					<#--</#if>-->
					<#--&lt;#&ndash;<a href="${base}/admin/cardInfo/delete?id=${bean.id}" class="btn btn-red" data-toggle="doajax" data-id="cardInfo-delete" data-confirm-msg="确定要删除吗？">删除</a>&ndash;&gt;-->
				</td>
			</tr>
			</#list>
			</#if>
		</tbody>
	</table>
</div>
<@pageFooter />
