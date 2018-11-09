<#assign base=request.contextPath />
<div class="bjui-pageContent" style="padding-top: 30px;">
    <form action="${base}/api/sendSms/rote" data-toggle="validate" method="post">
        <input type="text" name="id" value="${id}" class="hidden">
        <div class="form-group">
            <label class="control-label x85">手机号：</label>
            <input type="number" name="phone" value="" placeholder="手机号" size="20" data-rule="required">
        </div>
    </form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close">取消</button></li>
        <li><button type="submit" class="btn-default">发送</button></li>
    </ul>
</div>