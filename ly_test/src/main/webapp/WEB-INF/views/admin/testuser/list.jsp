<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/lycore.tld" prefix="ly"%>

<!-- BEGIN EXAMPLE TABLE PORTLET-->
<div class="portlet light" id="form_wizard_1">
    <div class="portlet-title">
        <div class="caption">
        	<i class="icon-layers font-green"></i>
            <span class="caption-subject font-green sbold uppercase">${menu.name }</span>
       	</div>
        <div class="actions">
        	<button class="btn sbold blue" id="insertBtn" onclick="post(${menu.mid});"><i class="fa fa-plus-circle"></i>增加</button>
            <input id="searchStr" name="searchStr" class="form-control input-inline input-sm" type="text" placeholder="${menu.titleAlias}"/>
			<button class="btn btn-sm green" onclick="search();"><i class="fa fa-search"></i> 搜索 </button>   
			<div class="btn-group">
	            <button data-toggle="dropdown" class="btn green dropdown-toggle" aria-expanded="false">排序
	                <i class="fa fa-angle-down"></i>
	            </button>
	            <ul class="dropdown-menu pull-right">
	                <li>
	                    <a href="<c:url value="/admin/tuser/get"/>${ly:toString(entity,'mid,pageSize,name')}&dt=desc&dtn=userId">
	                    <i class="fa fa-long-arrow-down"></i>编号降序</a>
	                </li>	     
	                <li>
	                    <a href="<c:url value="/admin/tuser/get"/>${ly:toString(entity,'mid,pageSize,name')}&dt=desc&dtn=name">
	                    <i class="fa fa-long-arrow-down"></i>${menu.titleAlias}降序</a>
	                </li>
	                <li>
	                    <a href="<c:url value="/admin/tuser/get"/>${ly:toString(entity,'mid,pageSize,name')}&dt=asc&dtn=name">
	                    <i class="fa fa-long-arrow-up"></i>${menu.titleAlias}升序</a>
	                </li>
	            </ul>
             </div>  
			<div class="btn-group">
	            <button data-toggle="dropdown" class="btn green dropdown-toggle" aria-expanded="false">工具
	                <i class="fa fa-angle-down"></i>
	            </button>
	            <ul class="dropdown-menu pull-right">
	                <li>
	                    <a href="<c:url value="/admin/tuser/xls"/>">
	                    <i class="fa fa-file-excel-o"></i>导出Excel</a>
	                </li>
	                <li>
	                    <a href="javascript:;">
	                    <i class="fa fa-file-pdf-o"></i>导出Pdf</a>
	                </li>
	                <li>
	                    <a href="javascript:;">
	                    <i class="fa fa-print"></i>打印</a>
	                </li>
	            </ul>
             </div>                     	
        </div>
    </div>
    <div class="portlet-body">
        <table class="table table-striped table-bordered table-advance table-hover" id="tlist">
            <thead>
                <tr>
                    <th width="10%"> 编号</th>
                    <th width="15%"> 姓名</th>
                    <th width="15%"> 手机 </th>
                    <th width="20%"> 邮箱 </th>
                    <th width="20%"> 日期 </th>
                    <th width="20%"> 操作 </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${page.content}" var="entity" varStatus="status">
                    <tr id="tr${entity.userId}">
                        <td>${entity.userId }</td>
                        <td>${entity.name }</td>
                        <td>${entity.mobile }</td>
                        <td>${entity.email }</td>
                        <td>${entity.createDate }</td>
                        <td>
                            <button class="btn btn-xs green" onclick="post(${menu.mid});"><i class="fa fa-plus-circle"></i> 增加 </button>
                            <button class="btn btn-xs green" onclick="put(${entity.userId});"><i class="fa fa-dot-circle-o"></i> 修改 </button>
                            <button class="btn btn-xs green" onclick="deleteOne(${entity.userId})"><i class="fa fa-minus-circle"></i> 删除 </button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="row">
	    	<div class="col-md-5 col-sm-5">
	    		<ly:pageSizeTag link="/admin/tuser/get${ly:toString(entity,'mid,name,dt,dtn')}" page="${page}"></ly:pageSizeTag>
	    	</div>
	    	<div class="col-md-7 col-sm-7 text-right">
                <ly:pageTag link="/admin/tuser/get${ly:toString(entity,'mid,name,dt,dtn')}&pageNo=" page="${page}"></ly:pageTag>
	    	</div>
    	</div>
    	 
    </div>
</div>
<!-- END EXAMPLE TABLE PORTLET-->

<script type="text/javascript">

	function search() {
	    window.location.href = "<c:url value='/admin/tuser/get'/>"+ "${ly:toString(entity,'mid,pageSize,dt,dtn')}"+ "&name="+$("#searchStr").val();
	}

    function post(mid) {
        window.location.href = "<c:url value='/admin/tuser/edit?mid="+mid+"'/>";
    }

    function put(userId) {
        window.location.href = "<c:url value='/admin/tuser/edit?userId="+userId+"'/>";
    }

    function deleteOne(id){
    	var formData = {userId:id};
    	$.post("<c:url value='/admin/tuser/delete'/>",formData,function(data){
    		var dat = $.parseJSON( data );
    	    alert(dat.msg);
    	    if(dat.result){
    	    	$("#tr"+id).hide();
    	    }
    	});
    }
</script>