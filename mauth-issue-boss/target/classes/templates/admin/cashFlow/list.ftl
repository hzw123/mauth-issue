<#include "/macro/base.ftl" />
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/cashFlow/list" method="post">
		<@pageHeadr />
		<div class="bjui-searchBar">
			<label>兑换订单号：</label>
			<input type="text" name="orderNo" value="" class="form-control" size="10">&nbsp;
			<label>身份标识：</label>
			<input type="text" name="authSign" value="" class="form-control" size="10">&nbsp;
			<label>状态：</label>
			<select name="code" data-toggle="selectpicker" >
				<option value="0">全部</option>
				<option value="1">未激活</option>
				<option value="2">激活</option>
			</select>
			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			<br/>
			<#--<a href="${base}/admin/cardLog/add" class="btn btn-default" data-toggle="dialog" data-icon="plus" data-id="card-add" data-options="{title:'添加', height:300}">添加 </a>-->
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-top" data-toggle="tablefixed" data-selected-multi="true">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th>卡激活时间</th>
				<th>兑换订单号</th>
				<th>卡面额</th>
				<th>卡密</th>
				<th>身份标识</th>
				<th>code</th>
				<th>结果</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<#if page??>
			<#list page.list as bean>
			<tr>
				<td align="center">${bean_index+1}</td>
                <td>${(bean.createTime?string('yyyy-MM-dd HH:mm:ss'))!}</td>
				<td>${bean.orderNo!}</td>
				<td>${bean.cardFacePrice!}</td>
				<td>${bean.cardKey!}</td>
				<td>${bean.authSign!}</td>
				<td>${bean.code!}</td>
				<td>${bean.msg!}</td>
				<td>
					<a href="${base}/admin/cashFlow/view?id=${bean.id}" class="btn btn-blue" data-toggle="dialog" data-id="cardLog-view" data-options="{title:'查看', height:300}">查看 </a>
				</td>
			</tr>
			</#list>
			</#if>
		</tbody>
	</table>
</div>
<@pageFooter />
