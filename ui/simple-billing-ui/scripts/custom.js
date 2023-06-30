const hostPort = "http://localhost:8080/";

function calculateBills() {
    $.ajax({
        url: hostPort + "simple-billing/bill/current",
        type: 'GET',
        success: function (data) {
            let length = data.length;
            for (let i = 0; i < length; i++) {
                let meterReading = data[i];
                if (meterReading['meterType'] == 'ELECTRIC') {
                    $("#electricBillAmount").append("£ " + meterReading['bill']['actualAmount']);
                    $("#electricStartDate").append(meterReading['usageStartDate']);
                    $("#electricEndDate").append(meterReading['usageEndDate']);
                    $("#electricUnits").append(meterReading['unitsUsed']);
                    $("#electricNoOfDays").append(meterReading['noOfDays']);
                    $("#electricActualBillAmount").append("£ " + meterReading['bill']['actualAmount']);
                    $("#electricPaidBillAmount").append("£ " + meterReading['bill']['paidAmount']);
                    $("#electricBillBalance").append(meterReading['bill']['balance']);
                    $("#electricBillMessage").append(meterReading['bill']['message']);
                } else {
                    $("#gasBillAmount").append("£ " + meterReading['bill']['actualAmount']);
                    $("#gasStartDate").append(meterReading['usageStartDate']);
                    $("#gasEndDate").append(meterReading['usageEndDate']);
                    $("#gasUnits").append(meterReading['unitsUsed']);
                    $("#gasNoOfDays").append(meterReading['noOfDays']);
                    $("#gasActualBillAmount").append("£ " + meterReading['bill']['actualAmount']);
                    $("#gasPaidBillAmount").append("£ " + meterReading['bill']['paidAmount']);
                    $("#gasBillBalance").append(meterReading['bill']['balance']);
                    $("#gasBillMessage").append(meterReading['bill']['message']);
                }
            }
        }
    });
    $.ajax({
        url: hostPort + "simple-billing/bill/monthPredict",
        type: 'GET',
        success: function (data) {
            let length = data.length;
            for (let i = 0; i < length; i++) {
                let avgBill = data[i];
                if (avgBill['meterType'] == 'ELECTRIC') {
                    $("#electricAvg").append("£ " + avgBill['monthlyUsage']);
                } else {
                    $("#gasAvg").append("£ " + avgBill['monthlyUsage']);

                }
            }
        }
    });
}


$(document).ready(function () {
    doInit();

});

function doInit() {
    calculateBills();
    loadRates();
    loadMeterReadings();
    loadPayments();
    handleSubmitMeterReading();
}

function loadMeterReadings() {
    makeAjaxAndPopulateTable("meterReadingTable", hostPort + "simple-billing/reading/all");
    makeAjaxAndPopulateTable("hMeterReadingTable", hostPort + "simple-billing/reading/historical");

}

function loadPayments() {
    makeAjaxAndPopulateTable("paymentTable", hostPort + "simple-billing/payment");
}

function loadRates() {
    makeAjaxAndPopulateTable("rateTable", hostPort + "simple-billing/rates");
}

function makeAjaxAndPopulateTable(tableName, url) {
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            var table = $('#' + tableName).DataTable({
                data: data,
                columns: Object.keys(data[0]).map(function (item) {
                    return {data: item, title: item}
                })
            })
        }
    });
}


function handleSubmitMeterReading() {
    $("#readingSubmitForm").submit(function (e) {
        e.preventDefault();
        let form = $(this);
        let actionUrl = hostPort + "simple-billing/reading/submit";
        let formData = {
            meterType: $("#readingSubmitMeterType").val(),
            readingDate: $("#meterReadingDate").val(),
            readingValue: $("#readingValue").val(),
            isStartingReading: $("#startingReading").is(":checked") ? "true" : "false",
        };
        console.log(JSON.stringify(formData));
        $.ajax({
            type: "POST",
            url: actionUrl,
            data: JSON.stringify(formData),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (res) {
                console.log(JSON.stringify(res))
                $("#readingModal").modal('hide');
                $("#successModal").modal('show');
            },
            error: function (error) {
                console.log(JSON.stringify(error));
            }
        });
    });
}
