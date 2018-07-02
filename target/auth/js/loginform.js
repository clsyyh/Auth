$(function(){
    $('#error').dialog({
        autoOpen:false,
        modal:true,
        closeOnEscape:false,
        resizeable:false,
        draggable:false,
        width:300,
        height:50,
    }).parent().find('.ui-widget-header').hide();

    $('#login').dialog({
        autoOpen:false,
        modal:true,
        width:320,
        height:240,
        resizeable:false,
        title:'登录系统',
        buttons:{
            '登录':function(){
                $(this).submit();
            },
            '取消':function(){
                $(this).dialog('close');
            }
        }
    }).validate({
        submitHandler:function(form){
            $(form).ajaxSubmit({
                url:'/login',
                type:'POST',
                dataType:'json',
                resetForm:true,
                success:function(responseText,statusText) {
                    if (responseText.flag) {
                        window.location.href = "main";//请求
                    }
                    else {
                        $('#error').dialog('open');
                        setTimeout(function () {
                            $("#error").dialog('close');
                            //$('#login').resetForm();
                            $('#login span.star').html('*').removeClass('succ');
                            window.location.href = 'loginForm';//请求
                        }, 2000);
                    }
                },
            });
        },
        showErrors:function(errorMap,errorList){
            var errors=this.numberOfInvalids();
            if(errors>0){
                $('#login').dialog('option','height',errors*20+340);
            }
            else{
                $('#login').dialog('option','height',240);
            }
            this.defaultShowErrors();
        },

        errorLabelContainer:'ol.error',
        wrapper:'li',

        highlight:function(element,errorClass){
            $(element).css('border','1px solid #630');
            $(element).parent().find('span').html('*').removeClass('succ');
        },
        unhighlight:function(element,errorClass){
            $(element).css('border','1px solid #ccd');
            $(element).parent().find('span').html('&nbsp').addClass('succ');
        },
        rules:{
            loginname:{
                required:true,
                minlength:2,
            },
            password:{
                required:true,
                minlength:6,
            },
        },
        messages:{
            loginname:{
                required:'登录名不得为空!',
                minlength:jQuery.format('登录名不得小于{0}位'),
            },
            password:{
                required:'密码不得为空!',
                minlength:jQuery.format('密码不得小于{0}位'),
            },
        },
    });
    $('#login_a').click(function(){
        $('#login').dialog('open');
    });






})