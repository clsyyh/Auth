var totalPage=0;
var pNum=1;
var notitle="";
$(function(){
    //两个全局事件
    $(document).ajaxStart().ajaxStop();
    //①在文档加载完后就触发Ajax发送异步请求,查询所有的公告,首先显示第一页的数据
    queryNotice(pNum);//1
    //②再点击查询按钮后触发Ajax发送异步请求，根据条件查询公告,首先显示第一页的数据

    $('#button').click(function(){
        $('#noticeData').html("");
        $('#emptyInfo').html("");
        queryNotice(1);//1
    });

    /*
    在滚动时加载更多页面的数据
     */
    $(window).bind('scroll',function(){
        var winScrollHeight=$(this).scrollTop();
        var winHeight=$(this).height();
        var docHeight=$(document).height();
        if(docHeight==winHeight+winScrollHeight){
            //显示下一个页面的数据
            queryNotice(pNum+1);
            // 跳转到selectNoticeByPage请求，每一次产生一个新的pager，但totalPage,totalRecord都相同
        }
    });

});
function queryNotice(currentPage) {
     notitle=$('#no_title').val();
    $.ajax({
        url:"/selectNoticeByPage",
        type:"POST",
        data:{pageNum:currentPage,title:notitle},
        success:function(data){
            /*响应内容是一个json字符串(pager)
            要解析转换成json对象
             */
            alert(data);
            var jsonData=$.parseJSON(data);
            pNum=jsonData.currentPage;
            totalPage=jsonData.totalPage;
            /*
            用于条件查询判断
             */
            if(totalPage==0){
                alert(totalPage);
                $('#emptyInfo').html("没有找到查询内容.....")
            }

            var noticeList=jsonData.dataList;
            showNoticeData(noticeList);

            if(pNum==totalPage){
                $('#emptyInfo').html("没有更多查询内容.....");
                $(window).off('scroll');
            }
        },
        datatype:"json"
    });
};
function showNoticeData(noticeList) {
    if (noticeList != null) {
        var noticeDataHtml = "";
        //遍历对象数组
    $.each(noticeList, function (index, obj) {
        /*
        在后台读取出所有的loginname
        一些obj.user.loginname却是undefined??????
         */
        noticeDataHtml += "<tr>";
        noticeDataHtml += "<td>" + obj.id + "</td>";
        noticeDataHtml += "<td>" + obj.title + "</td>";
        noticeDataHtml += "<td>" + obj.content + "</td>";
        noticeDataHtml += "<td>" + obj.createDate + "</td>";
        noticeDataHtml += "<td>" + obj.user.loginname + "</td>";
        noticeDataHtml += "</tr>";
    });
    $('#noticeData').html($('#noticeData').html() + noticeDataHtml);
    }
};
