var ckeditor;//全局变量
$(function(){
    ckeditor=CKEDITOR.replace('content',{
        uiColor:'#BFEFFF',
        //language:'zh_cn',
        //skin:'kama',
        //removeDialogTabs:'image:Link',
        filebrowserImageUploadUrl:'/uploadImage',

    });
    $('#button').click(function(){

        $('#notice').val(ckeditor.getData());
        $('#form').submit();
    });

});