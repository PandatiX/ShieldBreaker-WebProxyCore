package com.shieldbreaker.webproxycore;

import com.shieldbreaker.cli.BaseParametersManager;
import com.shieldbreaker.cli.ParametersManager;
import com.shieldbreaker.webproxycore.exceptions.DualityProxyException;
import org.apache.commons.cli.Option;

public abstract class WebProxyParametersManager extends BaseParametersManager {

    @Override
    protected void createCliOptions() {
        Option socksProxy = new Option("sp", "socksProxy", true, "Set SOCKS5 proxy address.");
        socksProxy.setArgName("IP:Port");
        addOption(socksProxy, ParametersManager.KEYS.NO_KEY);

        Option httpProxy = new Option("hp", "httpProxy", true, "Set HTTP proxy address.");
        httpProxy.setArgName("IP:Port");
        addOption(httpProxy, ParametersManager.KEYS.NO_KEY);
    }

    @Override
    protected void checkParameters() throws DualityProxyException {
        //Check for Socks and HTTP proxies
        if (!getValue("socksProxy").isEmpty() && !getValue("httpProxy").isEmpty())
            throw new DualityProxyException();
    }

    @Override
    public void setValue(String key, String value) {
        super.setValue(key, value);
    }
}
