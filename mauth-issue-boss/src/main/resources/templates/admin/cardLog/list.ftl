<#include "/macro/base.ftl" />
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/cardLog/list" method="post">
		<@pageHeadr />
		<div class="bjui-searchBar">
			<label>储值卡信息Id：</label>
			<input type="text" name="orderCardWaterId" value="" class="form-control" size="10">&nbsp;
			<label>用户ID：</label>
			<input type="text" name="userId" value="" class="form-control" size="10">&nbsp;
			<label>状态：</label>
			<select name="status" data-toggle="selectpicker" >
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
				<th>储值卡信息ID</th>
				<th title="1:创建,2:激活">状态</th>
				<th>用户ID</th>
				<th>信息</th>
                <th>支付时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<#if page??>
			<#list page.list as bean>
			<tr>
				<td align="center">${bean_index+1}</td>
				<td>${bean.orderCardWaterId!}</td>
				<td>${bean.status!}</td>
				<td>${bean.userId!}</td>
				<td>${bean.msg!}</td>
                <td>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
				<td>
					<a href="${base}/admin/cardLog/view?id=${bean.id}" class="btn btn-blue" data-toggle="dialog" data-id="cardLog-view" data-options="{title:'查看', height:200}">查看 </a>
					<#--<a href="${base}/admin/cardLog/edit?id=${bean.id}" class="btn btn-green" data-toggle="dialog" data-id="cardLog-edit" data-options="{title:'修改', height:300}">修改 </a>-->
					<#--<a href="${base}/admin/cardLog/delete?id=${bean.id}" class="btn btn-red" data-toggle="doajax" data-id="cardLog-delete" data-confirm-msg="确定要删除吗？">删除</a>-->
				</td>
			</tr>
			</#list>
			</#if>
		</tbody>
	</table>
</div>
<@pageFooter />
