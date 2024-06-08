[#ftl]
[@c.page]
    <div class="seznam">

        [#list vizitka]
            [#items as vizitka]

                <a href="/vizitka/${vizitka.id}">
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
                                    <div><i class="bi bi-at"></i> ${vizitka.email}</div>
                                [/#if]
                                [#if vizitka.telefon?has_content]
                                    <div><i class="bi bi-phone"></i> ${vizitka.telefon}</div>
                                [/#if]
                                [#if vizitka.web?has_content]
                                    <div><i class="bi bi-globe"></i> ${vizitka.web}</div>
                                [/#if]
                            </div>
                        </div>

                    </div>
                </a>

            [/#items]
        [/#list]

        <a href="/nova">
            <div class="vizitka vizitka--nova">
                <svg width="100" height="100">
                    <rect width="20" height="100" x="40" y="0" fill="white"/>
                    <rect width="100" height="20" x="0" y="40" fill="white"/>
                </svg>
            </div>
        </a>
    </div>


[/@c.page]