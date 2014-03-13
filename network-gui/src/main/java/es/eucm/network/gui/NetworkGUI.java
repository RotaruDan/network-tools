package es.eucm.network.gui;

import es.eucm.network.JavaRequestHelper;
import es.eucm.network.requests.RequestHelper;
import es.eucm.network.requests.ResourceCallback;

import java.util.Map.Entry;

public class NetworkGUI {

	public static void main(String args[]) {

		String urlTest = "http://downloads.sourceforge.net/project/e-adventure/ead2-stable/update.json";
		RequestHelper requestHelper = new JavaRequestHelper();
		requestHelper.url(urlTest).get(new ResourceCallback<Object>() {
			@Override
			public void error(Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void success(Object data) {
				System.out.println(data);
				System.out.println("Success!");
				System.out.println("System properties:");
				for (Entry<Object, Object> e : System.getProperties()
						.entrySet()) {
					System.out.println(e.getKey() + ":" + e.getValue());
				}
			}
		}, String.class, false);
	}
}
