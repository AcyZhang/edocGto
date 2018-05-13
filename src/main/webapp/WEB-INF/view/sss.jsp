<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>
<form method="get" action="${pageContext.request.contextPath }/edoc/inde">
    <input type="hidden" name="pageIndex" value="1" />
        <p>
            文档分类
            <select name="categoryId">
                <option value="0">全部</option>
                <option value="1">IT计算机</option>
                <option value="2">办公文档</option>
                <option value="3">外语学习</option>

            </select>
            <button type="submit"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button>
        </p>
        <table class="providerTable" cellpadding="0" cellspacing="0" border="2">
            <p>电子文档表</p>
            <tr class="firstTr">
                <th width="10%">文档编号</th>
                <th width="25%">文档名称</th>
                <th width="30%">文档摘要</th>
                <th width="10%">上传人</th>
                <th width="20%">上传日期</th>
                <th width="5%">操作</th>
            </tr>
            <c:forEach var="edoc" items="${list}">
            <tr>
                <td>
                    <span>${edoc.id}</span>
                </td>
                <td>
                    <span>${edoc.title}</span>
                </td>
                <td>
                    <span>${edoc.summary}</span>
                </td>
                <td>
                    <span>${edoc.uploaduser}</span>
                </td>
                <td>
                    <span>${edoc.createdate}</span>
                </td>
                <td>
                    <a href="javascript:" class="ssd" id="${edoc.id}">删除</a>
                </td>
            </tr>
</c:forEach>
        </table>
</form>


                <c:if test="${pages.currentPageNo > 1}">
                    <li class="paginate_button previous"><a
                            href="javascript:page_nav(document.forms[0],1);"
                            aria-controls="datatable-responsive" data-dt-idx="0"
                            tabindex="0">首页</a>
                    </li>
                    <li class="paginate_button "><a
                            href="javascript:page_nav(document.forms[0],${pages.currentPageNo-1});"
                            aria-controls="datatable-responsive" data-dt-idx="1"
                            tabindex="0">上一页</a>
                    </li>
                </c:if>
                <c:if test="${pages.currentPageNo < pages.totalPageCount }">
                    <li class="paginate_button "><a
                            href="javascript:page_nav(document.forms[0],${pages.currentPageNo+1 });"
                            aria-controls="datatable-responsive" data-dt-idx="1"
                            tabindex="0">下一页</a>
                    </li>
                    <li class="paginate_button next"><a
                            href="javascript:page_nav(document.forms[0],${pages.totalPageCount });"
                            aria-controls="datatable-responsive" data-dt-idx="7"
                            tabindex="0">最后一页</a>
                    </li>
                </c:if>

<script src="/statics/jquery-1.8.2.min.js"></script>
<script src="/statics/rollpage.js"></script>

<script type="text/javascript">
        $(".ssd").on("click",function(){
            var obj = $(this);
            if(confirm("确定要删除吗")){
                $.ajax({
                    type:"GET",
                    url:"/edoc/inDel",
                    data:{id:obj.attr("id")},
                    dataType:"json",
                    success:function(data){
                        if(data.messag == "1"){//删除成功：移除删除行
                            alert("删除成功");
                         location.reload();
                        }else if(data.messag == "0"){//删除失败
                            alert("对不起删除失败");
                        }
                    },
                    error:function(data){
                        alert("对不起，删除失败");
                    }
                });
            }
        });

</script>

</body>
</html>
