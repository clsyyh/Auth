$(function(){
    var boxs=$('input[type="checkbox"][id^="box_"]');
    //全选按钮
    $('#checkAll').click(function(){
        alert(this.checked);
        boxs.prop("checked",this.checked);
    });

    //当选中所有复选框时，全选按钮也被选中
    $('input[id^="box_"]').click(function(e){

        e.stopPropagation();
        var checkedBoxs=boxs.filter(":checked");
        $("#checkAll").prop("checked",checkedBoxs.length==boxs.length);
    });
    /*
        [注]如果把 dblclick 和 click 事件应用于同一元素，可能会产生问题。
    */
    //当点击数据行时，模拟点击复选框
    $('tr[id^="data_"]').hover(
        function(){
            $(this).css("backgroundColor","#eeccff");
        },function(){
            $(this).css("backgroundColor","#ffffff");
        }).click(function(){
            var checkedBoxId=this.id.replace("data_","box_");
            $('#'+checkedBoxId).trigger("click");
    });

    //双击某数据行时，模拟下载操作
    $('tr[id^="data_"]').dblclick(function(){
        var id=this.id.replace("data_","");
        $("a[id='down_"+id+"']").trigger("click");
    })
    /*
    此种写法不能实现双击效果
    function down(id){
        $("a[id='down_"+id+"']").trigger("click");
    };
    */
    //下载文档
    /*
    单击连接时href="#",有一个click事件，跳转到download请求
    这种方法的好处是可以设置双击数据行时模拟下载操作
   */
    $('a[id^="down_"]').click(function(){
        var id=this.id.replace("down_",'');
        window.location.href="download?id="+id;
    });
    //删除文档
    $('#delete').click(function(){
        var checkedBoxs=boxs.filter(":checked");
        var ids=checkedBoxs.map(function () {
            return this.value;
        });
        window.location.href="removeDocument?ids="+ids.get().join(',');
    })
});