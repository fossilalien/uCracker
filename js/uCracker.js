
    function showHowItWoekDetails(){
            //var options = {};
            $("#showHowItWorkDetails").hide();
            $("#howItWorkDetails").show();
            showCallback();
            //$("#howItWorkDetails").show( "blind", options, 500, showCallback());
    };

    function showCallback() {
        $("#hideHowItWorkDetails").show();
    };

    function hideCallback() {
        $("#showHowItWorkDetails").show();
    };

    function hideHowItWorkDetails() {
        //var options = {};
        $("#hideHowItWorkDetails").hide();
        $("#howItWorkDetails").hide();
        hideCallback();
        //$("#howItWorkDetails").hide( "blind", options, 500, hideCallback());
    };
