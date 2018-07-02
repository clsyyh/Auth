$(function(){
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