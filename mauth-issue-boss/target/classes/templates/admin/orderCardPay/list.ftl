<#include "/macro/base.ftl" />
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/orderCardPay/list" method="post">
		<@pageHeadr />
		<div class="bjui-searchBar">
			<label>储值卡类型ID：</label>
			<input type="text" name="cardid" value="" class="form-control" size="10">&nbsp;
			
			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			<br />
			<#--<a href="${base}/admin/orderCardPay/add" class="btn btn-default" data-toggle="dialog" data-icon="plus" data-id="orderCard-add" data-options="{title:'添加', height:350}">添加 </a>-->
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-top" data-toggle="tablefixed" data-selected-multi="true">
		<thead>
			<tr>
				<th width="30">序号</th>
                <th>流水号</th>
                <th>流水类型</th>
                <th>订单id</th>
                <th>流水金额</th>
                <th>支付时间</th>
                <th title="1 支付成功,0 支付失败">状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<#if page??>
			<#list page.list as bean>
			<tr>
				<td align="center">${bean_index+1}</td>
                <td>${bean.serialNo!}</td>
                <td>${bean.serialType!}</td>
                <td>${bean.orderCardId!}</td>
                <td>${bean.serialAmount!}</td>
                <td>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                <td>${bean.status!}</td>
				<td>
					<a href="${base}/admin/orderCardPay/view?id=${bean.id}" class="btn btn-blue" data-toggle="dialog" data-id="orderCardPay-view" data-options="{title:'查看', height:250}">查看 </a>
					<#--<a href="${base}/admin/orderCardPay/edit?id=${bean.id}" class="btn btn-green" data-toggle="dialog" data-id="orderCardPay-edit" data-options="{title:'修改', height:350}">修改 </a>-->
					<#--<a href="${base}/admin/orderCardPay/delete?id=${bean.id}" class="btn btn-red" data-toggle="doajax" data-id="orderCardPay-delete" data-confirm-msg="确定要删除吗？">删除</a>-->
				</td>
			</tr>
			</#list>
			</#if>
		</tbody>
	</table>
</div>
<@pageFooter />
