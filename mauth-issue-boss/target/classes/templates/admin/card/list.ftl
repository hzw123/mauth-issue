<#include "/macro/base.ftl" />
<div class="bjui-pageHeader">
	<form id="pagerForm" data-toggle="ajaxsearch" action="${base}/admin/card/list" method="post">
		<@pageHeadr />
		<div class="bjui-searchBar">
			<label>卡名称：</label>
			<input type="text" name="cardName" value="" class="form-control" size="10">&nbsp;
			<label>卡面额：</label>
			<input type="text" name="cardFacePrice" value="" class="form-control" size="10">&nbsp;
			<label>商品类型：</label>
			<input type="text" name="cardType" value="" class="form-control" size="10">&nbsp;
			<label>卡状态：</label>
			<select name="cardStatus" data-toggle="selectpicker" data-width="100">
				<option value="0">全部</option>
				<#list itemStatusEnums as enumvo>
					<option value="${enumvo.code}">${enumvo.desc}</option>
				</#list>
			</select>

			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
			<br />
			<a href="${base}/admin/card/add" class="btn btn-default" data-toggle="dialog" data-icon="plus" data-id="card-add" data-options="{title:'添加', height:300}">添加 </a>
		</div>
	</form>
</div>
<div class="bjui-pageContent tableContent">
	<table class="table table-bordered table-hover table-top" data-toggle="tablefixed" data-selected-multi="true">
		<thead>
			<tr>
				<th width="30">序号</th>
				<th>创建时间</th>
				<th>卡名称</th>
				<th>卡类型</th>
				<th title="元">卡面额</th>
				<th>卡状态</th>
				<th>有效期(天)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<#if page??>
			<#list page.list as bean>
			<tr>
				<td align="center">${bean_index+1}</td>
				<td>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}</td>
				<td>${bean.cardName!}</td>
				<td>${bean.cardType!}</td>
				<td>${bean.cardFacePrice!}</td>
                <td>
					<#list itemStatusEnums as enumvo>
						<#if bean.cardStatus!=0 && bean.cardStatus==enumvo.code>${enumvo.desc}</#if></#list></td>
				<td>${bean.validityTime!}</td>
				<td>
					<a href="${base}/admin/card/view?id=${bean.id}" class="btn btn-blue" data-toggle="dialog" data-id="card-view" data-options="{title:'查看', height:240}">查看 </a>
					<a href="${base}/admin/card/edit?id=${bean.id}" class="btn btn-green" data-toggle="dialog" data-id="card-edit" data-options="{title:'修改', height:300}">修改 </a>
					<a href="${base}/admin/card/delete?id=${bean.id}" class="btn btn-red" data-toggle="doajax" data-id="card-delete" data-confirm-msg="确定要删除吗？">删除</a>
				</td>
			</tr>
			</#list>
			</#if>
		</tbody>
	</table>
</div>
<@pageFooter />
