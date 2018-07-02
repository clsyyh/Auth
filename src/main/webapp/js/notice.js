$(function(){
    /*
    $('img[id^="img_"]').click(function(){
        //获取当前公告id
        var nid=this.id.replace("img_","");

        $('#box').dialog({

            //对话框ui没有url属性
            //生成对话框，内容由url指定
            //url:'prevNotice?id='+id,

            autoOpen:true,
            modal:true,
            width:750,
            height:500,
            resizeable:false,
            title:'公告预览',
        });

    });
    */
    $('tr[id^="data_"]').hover(
        function(){
            $(this).css("backgroundColor","#eeccff");
        },function(){
            $(this).css("backgroundColor","#ffffff");
        }
    );

    var boxs=$('input[id^="box_"]');
    $('#delete').click(function(){

        var checkedBoxs=boxs.filter(":checked");
        var ids=checkedBoxs.map(function(){
            return this.value;
        });

        window.location.href="removeDept?ids="+ids.get().join(',');
    })
})
