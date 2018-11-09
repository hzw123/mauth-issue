<#include "/macro/base.ftl" />
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/orderCard/list" method="post">
		<@pageHeadr />
		<div class="bjui-searchBar">
			<label>订单名称：</label>
			<input type="text" name="orderCardName" value="" class="form-control" size="15">&nbsp;
			<label>身份标识：</label>
			<input type="text" name="authSign" value="" class="form-control" size="15">&nbsp;
			<label>订单类型：</label>
            <select name="orderType" data-toggle="selectpicker" data-width="80">
                <option value="">全部</option>
                <option value="内部">内部</option>
				<option value="对公">对公</option>
                <option value="X事件">X事件</option>
            </select>
			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			<br />
			<a href="${base}/admin/orderCard/add" class="btn btn-default" data-toggle="dialog" data-icon="plus" data-id="orderCard-add" data-options="{title:'添加', height:500}">添加 </a>
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-top" data-toggle="tablefixed" data-selected-multi="true">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th>订单名称</th>
				<th>订单号</th>
				<th>订单类型</th>
				<th>下单时间</th>
				<th>修改时间</th>
                <th>订单总价</th>
				<th>支付账户</th>
				<th>支付方式</th>
				<th>身份标识</th>
				<th>状态</th>
				<th>有效天数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<#if page??>
			<#list page.list as bean>
			<tr>
				<td align="center">${bean_index+1}</td>
                <td>${bean.orderCardName!}</td>
                <td>${bean.orderNo!}</td>
                <td>${bean.orderType!}</td>
				<td>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
				<td>${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                <td>${bean.totalPrice!}</td>
				<td>${bean.userPayAccount!}</td>
				<td>${bean.payType!}</td>
				<td>${bean.authSign!}</td>
				<td>${bean.status!}</td>
				<td>${bean.days!}</td>
				<td>
					<a href="${base}/admin/orderCard/view?id=${bean.id}" class="btn btn-blue" data-toggle="dialog"  data-id="orderCard-view" data-options="{title:'查看', height:400}">查看 </a>
					<#--<a href="${base}/admin/orderCard/edit?id=${bean.id}" class="btn btn-green" data-toggle="dialog" data-id="orderCard-edit" data-options="{title:'修改', height:500}">修改 </a>-->
					<#--<a href="${base}/admin/orderCard/delete?id=${bean.id}" class="btn btn-red" data-toggle="doajax" data-id="orderCard-delete" data-confirm-msg="确定要删除吗？">删除</a>-->
					<#if bean.status=="已完成">
					    <a href="${base}/admin/orderCard/pwd?id=${bean.id}" class="btn btn-blue" data-toggle="dialog"  data-id="orderCard-pwd" data-options="{title:'查看密码', height:150}">查看密码 </a>
					    <a href="${base}/admin/orderCard/sendSms?id=${bean.id}" class="btn btn-green" data-toggle="dialog"  data-id="orderCard-sendSms" data-options="{title:'发送短信', height:150}">发送短信 </a>
						<a href="${base}/admin/orderCard/download?id=${bean.id}" class="btn btn-red" data-id="orderCard-load" data-confirm-msg="确定要下载订单下的储值卡码？">下载</a>
					<#else>
						<a href="${base}/admin/orderCard/pay?id=${bean.id}" class="btn btn-red" data-toggle="doajax" data-id="orderCard-pay" data-confirm-msg="确定要收款吗？">收款</a>
					</#if>
				</td>
			</tr>
			</#list>
			</#if>
		</tbody>
	</table>
</div>
<@pageFooter />