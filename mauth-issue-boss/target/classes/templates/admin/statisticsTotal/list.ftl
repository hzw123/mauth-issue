<#include "/macro/base.ftl" />
<div class="bjui-pageHeader" style="padding: 15px 10px;">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/statisticsTotal/list" method="post">
		<div class="bjui-searchBar">
			<label>订单类型：</label>
            <select name="type" data-toggle="selectpicker" data-width="60">
                <option value="">全部</option>
				<option value="内部">内部</option>
				<option value="对公">对公</option>
                <option value="X事件">X事件</option>
            </select>
            <label>开始时间:</label>
			<input type="text" name="start" placeholder="yyyy-MM-dd HH:mm:ss">
			<label>结束时间:</label>
			<input type="text" name="stopTime" placeholder="yyyy-MM-dd HH:mm:ss">
			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-top" data-toggle="tablefixed" data-selected-multi="true">
		<thead>
			<tr style="height: 40px;" align="center">
				<th>订单总面值</th>
				<th>兑换总面值</th>
				<th>剩余总面值</th>
				<th>不同面额数量</th>
				<th>卡的总数量</th>
				<th>已兑换卡的数量</th>
			</tr>
		</thead>
		<tbody>
			<#if data??>
			<tr style="height: 100px;" align="center">
                <td>${data.totalFace!}</td>
                <td>${data.cashOutFace!}</td>
                <td>${data.noChangeFace!}</td>
                <td>${data.amount!}</td>
                <td>${data.total!}</td>
                <td>${data.cashOutCount!}</td>
			</tr>
			</#if>
		</tbody>
	</table>
</div>
