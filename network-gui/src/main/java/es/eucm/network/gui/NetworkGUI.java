package es.eucm.network.gui;

import com.btr.proxy.search.ProxySearch;
import es.eucm.network.JavaRequestHelper;
import es.eucm.network.requests.RequestHelper;
import es.eucm.network.requests.ResourceCallback;

import java.net.ProxySelector;

public class NetworkGUI {

	public static void main(String args[]) {


		String urlTest = "http://downloads.sourceforge.net/project/e-adventure/ead2-stable/update.json";
		RequestHelper requestHelper = new JavaRequestHelper();
		requestHelper.url(urlTest).get(new ResourceCallback<Object>() {
			@Override
			public void error(Throwable e) {
			}

			@Override
			public void success(Object data) {
				System.out.println(data);
			}
		}, String.class, false);
	}
}
