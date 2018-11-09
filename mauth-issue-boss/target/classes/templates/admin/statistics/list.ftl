<#include "/macro/base.ftl" />
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/statistics/list" method="post">
		<@pageHeadr />
		<div class="bjui-searchBar">
            <label>订单号：</label>
            <input type="text" name="orderNo">
			<label>订单类型：</label>
            <select name="type" data-toggle="selectpicker" data-width="60">
                <option value="">全部</option>
				<option value="内部">内部</option>
				<option value="对公">对公</option>
                <option value="X事件">X事件</option>
            </select>
            <label>开始时间:</label>
			<input type="text" name="start" placeholder="yyyy-MM-dd HH:mm:ss">
            <label>用户：</label>
            <input type="text" name="user" size="10">
			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-top" data-toggle="tablefixed" data-selected-multi="true">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th>订单号</th>
				<th>订单类型</th>
				<th>开始时间</th>
				<th>订单总面值</th>
				<th>兑换总面值</th>
				<th>剩余总面值</th>
				<th>不同面额数量</th>
				<th>卡的总数量</th>
				<th>已兑换卡的数量</th>
			</tr>
		</thead>
		<tbody>
			<#if page??>
			<#list page.list as bean>
			<tr>
				<td align="center">${bean_index+1}</td>
                <td>${bean.orderNo!}</td>
                <td>${bean.orderType!}</td>
				<td>${(bean.createTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
                <td>${bean.totalFace!}</td>
                <td>${bean.cashOutFace!}</td>
                <td>${bean.noChangeFace!}</td>
                <td>${bean.amount!}</td>
                <td>${bean.total!}</td>
                <td>${bean.cashOutCount!}</td>
			</tr>
			</#list>
			</#if>
		</tbody>
	</table>
</div>
<@pageFooter />