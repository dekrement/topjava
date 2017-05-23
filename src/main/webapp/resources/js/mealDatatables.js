var ajaxUrl = 'ajax/meals/';
var datatableApi;

// $(document).ready(function () {
$(function () {
    datatableApi = $('#datatable').DataTable({
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "dateTime"
            },
            {
                "data": "description"
            },
            {
                "data": "calories"
            },
            {
                "defaultContent": "Edit",
                "orderable": false
            },
            {
                "defaultContent": "Delete",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ]
    });
    makeEditable();
    
    $("#dateTime").datetimepicker({
        format: 'Y-m-d h:i'
    });
    
    var $endDate = $("input[name='endDate']"),
        $startDate = $("input[name='startDate']"),
        $startTime =$("input[name='startTime']"),
        $endTime = $("input[name='endTime']");

    $startDate.datetimepicker({
        format: "Y-m-d",
        timepicker: false
    });
    $endDate.datetimepicker({
        format: "Y-m-d",
        timepicker: false
    });
    
    $startTime.datetimepicker({
        format: "H:i",
        datepicker: false
    });

    $endTime.datetimepicker({
        format: "H:i",
        datepicker: false
    });


});

function clearFilter() {
    $("#filter input").each(function(i, el){
        $(el).val("");
    });
    updateTable();
}