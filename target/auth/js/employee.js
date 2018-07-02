$(function(){
    $('#birthday').datepicker({
        dateFormat:'yy-mm-dd',
        showWeek:true,
        weekHeader:'周',
        firstDay:1,

        showOn:'button',
        buttonText:'日历',
        buttonImage:'../images/calendar.gif',
        buttonImageOnly:true,

        dayNamesMin:['日','一','二','三','四','五','六'],
        monthNames:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
        monthNamesShort:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
        changeMonth:true,
        changeYear:true,
        //生日限制
        maxDate:0,
        yearRange:'1950:2050',
    })
})