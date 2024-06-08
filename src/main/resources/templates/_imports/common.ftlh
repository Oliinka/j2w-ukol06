[#ftl]

[#macro page]
    <!DOCTYPE html>
    <html lang="cs">
    <head>
        <meta charset="UTF-8">
        <title>Vizitkovník</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
        <link rel="stylesheet" href="/css/style.css">
        <link rel="icon" type="image/png" href="/images/favicon.png">
    </head>
    <body>
    [#nested]
    </body>
    </html>
[/#macro]

[#macro back]
    <nav>
        <a href="/">◂ zpět na seznam</a>
    </nav>
[/#macro]

[#macro vizitka]
<div class="detail">
    <div class="vizitka">
        [#if vizitka.celeJmeno??]
            <div class="jmeno">${vizitka.celeJmeno}</div>
        [/#if]
        [#if vizitka.firma??]
            <div class="firma">${(vizitka.firma)!""}</div>
        [/#if]
        <div class="udaje">
                    <span class="adresa">

                        [#if vizitka.ulice??]
                            <div>${vizitka.ulice}</div>
                        [/#if]

                        <div>
                        [#if vizitka.psc??]
                            <span>${vizitka.psc}</span>
                        [/#if]
                            [#if vizitka.obec??]
                                <span>${vizitka.obec}</span>
                            [/#if]
                        </div>
                    </span>

            <div class="kontakty">
                [#if vizitka.email?has_content]
                    <div><i class="las la-at"></i> ${vizitka.email}</div>
                [/#if]
                [#if vizitka.telefon?has_content]
                    <div><i class="las la-phone-alt"></i> ${vizitka.telefon}</div>
                [/#if]
                [#if vizitka.web?has_content]
                    <div><i class="las la-globe"></i> ${vizitka.web}</div>
                [/#if]
            </div>
        </div>
    </div>
[/#macro]
