[#ftl]
[@c.page]
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

        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=${'${vizitka.ulice},${vizitka.obec}'?url}"
                    width="100%" height="100%"
                    frameborder="0"></iframe>
        </div>

        [@c.back/]

    </div>
[/@c.page]