<div class="bjui-pageContent">
    <div class="form-group">
		<label class="control-label">创建时间：</label>${(bean.gmtCreate?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">修改时间：</label>${(bean.gmtModified?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label" title="1 正常 2 冻结 9注销">状态：</label>${bean.statusId!}
	</div>
    <div class="form-group">
		<label class="control-label">用户ID：</label>${bean.userInfoId!}
	</div>
    <div class="form-group">
		<label class="control-label">总余额：</label>${bean.totalBalance!}
	</div>
    <div class="form-group">
		<label class="control-label">最后交易余额：</label>${bean.lastTradeBalance!}
	</div>
    <div class="form-group">
		<label class="control-label">最后交易时间：</label>${(bean.lastTradeDate?string('yyyy-MM-dd HH:mm:ss'))!}
	</div>
    <div class="form-group">
		<label class="control-label">校验码：</label>${bean.verificationCode!}
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
    </ul>
</div>