function makeEditable() {
    $('.delete').click(function () {
        deleteRow($(this).closest("tr").attr("id"));
    });

    $('#detailsForm').submit(function () {
        save();
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });
}

function add() {
    $('#id').val(null);
    $('#editRow').modal();
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function updateTable() {
    var callback = function (data) {
        datatableApi.clear();
        $.each(data, function (key, item) {
            datatableApi.row.add(item);
        });

        datatableApi.draw();
    };
    var $filter = $("#filter");
    if ($filter && $filter.length > 0) {
        $.ajax({
            type: "POST",
            url: ajaxUrl + "filter",
            data: $filter.serialize(),
            success: function (data) {
                callback(data);
            }
        });
    } else {
        $.get(ajaxUrl, function(data) {
            callback(data)
        });
    }

}

function toJSONObject(formArray) {//serialize data function
    var returnArray = {};
    for (var i = 0; i < formArray.length; i++) {
        if (formArray[i]['value'])
            returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return JSON.stringify(returnArray);
}

function save() {
    var form = $('#detailsForm');
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: toJSONObject(form.serializeArray()),
        contentType: "application/json",
        success: function () {
            $('#editRow').modal('hide');
            updateTable();
            successNoty('Saved');
        }
    });
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: 1500
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>",
        type: 'error',
        layout: 'bottomRight'
    });
}
