$(function(){
    $.ajax({
        url:"/selectQuestions",
        type:"post",
        success:function(response,status,xhr){
            var dataQuestion=$.parseJSON(response);
            var html="";
            $.each(dataQuestion,function(index,obj){
                html+='<h4>'+obj.user.loginname+'发表于'+ obj.date+'</h4>' +
                    '<h3>'+obj.title+'</h3>' +
                    '<div class="editor">'+obj.content+'</div>' +
                    '<div class="bottom">' +
                    '<span class="comment" questionId="'+obj.id+'">'+obj.count+'条评论</span>' +
                    '<span class="up" hidden>收起</span></div>' +
                    '<hr noshade="noshade" size="1"/>' +
                    '<div class="comment_list"></div>';
            });
            $('.content').append(html);

            var arr=[];
            var summary=[];
            $.each($('.editor'),function(index,value){
                arr[index]=$(value).html();
                summary[index]=arr[index].substr(0,100);
                //①
                if(arr[index].length>100){
                    summary[index]+='<span class="down">...显示全部</span>';
                    $(value).html(summary[index]);
                }
            });
            //②当点击“显示全部”时，“显示全部”隐藏起来，“收起”显示出来
            $.each($('.editor'),function(index,value){
                //事件委托绑定
                $(this).on('click','.down',function() {
                    $('.editor').eq(index).html(arr[index]);
                    $(this).hide();
                    $('.bottom .up').eq(index).show();
                });
            });
            //③当点击“收起”时，“收起”隐藏起来，“显示全部”显示出来
            $.each($('.bottom .up'),function(index,value){
                $(this).click(function () {
                    $('.editor').eq(index).html(summary[index]);
                    $(this).hide();
                    $('.editor .down').eq(index).show();
                });
            });




            $.each($('.bottom .comment'),function (index,value) {
                //当点击“0条评论”时，加载并显示当前问题的所有评论以及评论发表框,再次点击时隐藏评论发表框(表单)
                $(this).click(function () {
                     var comment_this=this;
                     if(!$('.comment_list').eq(index).has('form').length){
                         $.ajax({
                            url:"/selectComments",
                            type:"post",
                            data:{
                                  questionId:$(comment_this).attr('questionId')
                                },
                            success:function (response,status) {
                                alert(response);
                                //③显示当前问题的所有评论
                                var dataComment=$.parseJSON(response);
                                $.each(dataComment,function (index2,obj) {
                                    $('.comment_list').prepend('<dl class="comment_content">' +
                                        '<dt>'+obj.user.loginname+'</dt>' +
                                        '<dd>'+obj.comment+'</dd>' +
                                        '<dd>'+obj.date+'</dd>');
                                });
                                //①显示评论发表框
                                $('.comment_list').eq(index).append('<form><dl class="comment_add">' +
                                    '<dt><textarea type="text" name="comment"/></dt>' +
                                    '<dd><input type="hidden" name="questionId" value="'+$(comment_this).attr('questionId')+'" />' +
                                    '<input type="button" value="发表"/></dd></dl>');
                                //②提交当前问题的评论
                                $('.comment_list').eq(index).find('input[type="button"]').button().click(function(){
                                    $('.comment_list').eq(index).find('form').ajaxSubmit({
                                        url:"/addComment",
                                        type:'post',
                                        beforeSubmit: function(){
                                            $('.comment_list').eq(index).find('input[type="button"]').button('disable');
                                        },
                                        success:function(response){
                                            $('.comment_list').eq(index).find('input[type="button"]').button('enable');
                                            setTimeout(function(){
                                                $('.comment_list').eq(index).find('form').resetForm();
                                                //当用户提交评论后，直接显示在评论列表顶部
                                                var date=new Date();
                                                alert($('.comment_list').eq(index).find('form').find('textarea').fieldValue());
                                                $('.comment_list').eq(index).prepend(
                                                    '<dl class="comment_content">' +
                                                    /*如何获取当前时间和内容*/
                                                    '<dt>cookie</dt>' +
                                                    '<dd>'+$('.comment_list').eq(index).find('form').find('textarea').fieldValue()+'</dd>' +
                                                    '<dd>'+date.getFullYear()+'-'+date.getMonth()+'-'+date.getDate()+' '+
                                                    date.getHours()+':'+date.getMinutes()+':'+date.getSeconds()+'</dd></dl>');
                                            },1000);
                                        },
                                    });
                                });
                            }

                         });
                     }
                    if($('.comment_list').eq(index).is(':hidden')){
                        $('.comment_list').eq(index).show();
                    }else{
                        $('.comment_list').eq(index).hide();
                    }

                });
            });
        },
    });



    $('input[type="button"]').button({
        icons:{
            primary:'ui-icon-lightbulb',
        }
    }).click(function () {
        $('#question').dialog('open');
    });

    $('#question').dialog({
        autoOpen:false,
        madal:true,
        resizable:false,
        width:500,
        height:360,
        buttons:{
            发布:function(){
                $(this).ajaxSubmit({
                    url:"/addQuestion",
                    type:'POST',
                    beforeSubmit:function(){
                        $('#question').dialog('widget').find('button').button('disable');
                    },
                    success:function(response,statusText){
                        $('#question').dialog('widget').find('button').button('enable');
                        setTimeout(function(){
                            $('#question').dialog('close');
                            $('#question').resetForm();
                        },1000);
                    },
                });
            }
        },
    });




});

