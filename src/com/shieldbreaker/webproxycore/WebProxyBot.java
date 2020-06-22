package com.shieldbreaker.webproxycore;

import com.shieldbreaker.bot.Bot;
import com.shieldbreaker.bot.BotManager;
import com.shieldbreaker.webproxycore.customhttpclients.*;

public abstract class WebProxyBot extends Bot {

    protected final BaseCustomHttpClient httpClient;

    public WebProxyBot(BotManager manager) {
        super(manager);

        //Select HttpClient according to the proxy
        String socksProxyAddress = parametersManager.getValue("socksProxy");
        String httpProxyAddress = parametersManager.getValue("httpProxy");

        if (!socksProxyAddress.isEmpty()) {             //SOCKS5 PROXY
            httpClient = new Socks5HttpClient(socksProxyAddress);
        } else if (!httpProxyAddress.isEmpty()) {       //HTTP PROXY
            httpClient = new HttpHttpClient(httpProxyAddress);
        } else {                                        //NO PROXY
            httpClient = new DefaultHttpClient();
        }
    }

}
